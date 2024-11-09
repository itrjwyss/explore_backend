package com.giocondalabs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.giocondalabs.entities.identity.VisitorEntity;
import com.giocondalabs.objects.request.RegisterRequest;
import com.giocondalabs.objects.response.MessageResponse;
import com.giocondalabs.services.identity.VisitorService;
import com.giocondalabs.services.structure.CountryService;
import com.giocondalabs.utils.JsonProcessing;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.rmi.UnexpectedException;

@Path("api/identity")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IdentityController extends BaseController {

    @Inject
    VisitorService visitorService;

    @Inject
    CountryService countryService;

    @POST
    @Path("/register")
    public Response register(RegisterRequest request) throws UnexpectedException, JsonProcessingException {
        MessageResponse messageResponse;

        if (request != null && request.isValid()) {
            VisitorEntity searchVisitor = visitorService.findByEmail(request.visitorData().email());

            if (searchVisitor != null) {
                VisitorEntity visitor = new VisitorEntity();

                visitor.setName(request.visitorData().name());
                visitor.setLastName(request.visitorData().lastName());
                visitor.setPicture(request.visitorData().picture());
                visitor.setEmail(request.visitorData().email());
                visitor.setPassword(request.visitorData().password());
                visitor.setCountry(
                    countryService.findById(request.visitorData().countryId())
                );

                visitor = visitorService.save(visitor);



                return Response
                    .ok(
                        new MessageResponse(
                            true,
                            "Tu usuario ha sido creado con éxito.\nEn breve recibirás un correo electrónico para verificar tu cuenta."
                        )
                    )
                    .header(
                        AUTHORIZATION,
                        crypto.encrypt(
                            JsonProcessing.parseObjectToJson(
                                createAuthorization(null)
                            )
                        )
                    )
                    .build();
            } else {
                messageResponse = new MessageResponse(
                    false,
                    "El correo electrónico que deseas utilizar ya se encuentra en uso"
                );
            }
        } else {
            messageResponse = new MessageResponse(
                false,
                "Tu solicitud de registro no es válida"
            );
        }

        return Response.ok(messageResponse).build();
    }
}
