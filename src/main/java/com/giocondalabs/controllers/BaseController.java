package com.giocondalabs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.HistoryEntity;
import com.giocondalabs.objects.beans.Authorization;
import com.giocondalabs.objects.beans.Validation;
import com.giocondalabs.objects.response.MessageResponse;
import com.giocondalabs.services.identity.HistoryService;
import com.giocondalabs.utils.Crypto;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.rmi.UnexpectedException;
import org.jboss.logging.Logger;

import static com.giocondalabs.utils.GeneralFunctions.convertIdToString;
import static com.giocondalabs.utils.GeneralFunctions.convertStringToId;
import static com.giocondalabs.utils.JsonProcessing.parseJsonToObject;
import static com.giocondalabs.utils.JsonProcessing.parseObjectToJson;

public class BaseController {

    protected static final String AUTHORIZATION = "authorization";

    @Inject
    protected HistoryService historyService;

    @Inject
    protected Crypto crypto;

    @Inject
    protected Logger logger;

    protected Authorization parseAuthorization(String authorization) {
        try {
            return parseJsonToObject(
                crypto.decrypt(authorization),
                Authorization.class
            );
        } catch (JsonProcessingException e) {
            logger.error("BaseController - parseAuthorization- JsonProcessingException", e);
            return null;
        } catch (UnexpectedException e) {
            logger.error("BaseController - parseAuthorization- UnexpectedException", e);
            return null;
        }
    }

    protected Authorization createAuthorization(
        VisitorDeviceEntity visitorDevice
    ) throws UnexpectedException {
        String key = System.currentTimeMillis() + "-" + visitorDevice.getVisitor().getId().toString();
        key = crypto.encrypt(key);

        HistoryEntity history = new HistoryEntity(
            key,
            visitorDevice
        );
        historyService.save(history);

        return new Authorization(
            key,
            crypto.encrypt(visitorDevice.getPhone().getUniqueId()),
            convertIdToString(visitorDevice.getVisitor().getId())
        );
    }

    protected Validation validateToken(String token) {
        Validation validation = null;

        if (token != null) {
            Authorization authorization = parseAuthorization(token);
            if (authorization != null) {
                HistoryEntity history = historyService.findByKeycode(authorization.jti());
                try {
                    String sub = crypto.decrypt(authorization.sub());
                    Long vid = convertStringToId(authorization.vid());
                    if (
                        history != null &&
                        history.getEndDay() == null &&
                        history.getVisitorDevice().getPhone().getUniqueId().equalsIgnoreCase(sub) &&
                        history.getVisitorDevice().getVisitor().getId().equals(vid)
                    ) {
                        validation = new Validation(
                            history,
                            sub,
                            vid
                        );
                    }
                } catch (UnexpectedException e) {
                    logger.error("BaseController - validateToken- UnexpectedException", e);
                }
            }
        }

        return validation;
    }

    protected Response isUnauthorized() {
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    protected Response getMessageResponse(
        String message,
        Validation validation,
        VisitorDeviceEntity visitorDevice
    ) throws UnexpectedException, JsonProcessingException {
        // Invalidar el History
        return Response
            .ok(
                new MessageResponse(
                    true,
                    message
                )
            )
            .header(
                AUTHORIZATION,
                crypto.encrypt(
                    parseObjectToJson(
                        createAuthorization(
                            visitorDevice
                        )
                    )
                )
            )
            .build();
    }
}
