package com.giocondalabs.implementation;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.HistoryEntity;
import com.giocondalabs.entities.identity.VisitorEntity;
import com.giocondalabs.objects.data.DeviceData;
import com.giocondalabs.services.devices.PhoneService;
import com.giocondalabs.services.devices.VisitorDeviceService;
import com.giocondalabs.services.identity.HistoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Date;

@ApplicationScoped
public class IdentityManagerImpl implements IdentityManager {

    @Inject
    PhoneService phoneService;

    @Inject
    VisitorDeviceService visitorDeviceService;

    @Inject
    HistoryService historyService;

    @Override
    public PhoneEntity checkDevice(DeviceData data) {
        PhoneEntity phone = phoneService.findByUniqueId(data.uniqueId());

        if (phone == null) {
            phone = new PhoneEntity();

            phone.setUniqueId(data.uniqueId());
            phone.setBrand(data.brand());
            phone.setModel(data.model());
            phone.setSdkInt(data.sdkInt());
            phone.setReleaseVersion(data.realiseVersion());

            phone = phoneService.save(phone);
        }

        return phone;
    }

    @Override
    public VisitorDeviceEntity checkRelation(
        PhoneEntity phone,
        VisitorEntity visitor,
        Integer versionCode,
        String versionName
    ) {
        Date date = new Date();

        VisitorDeviceEntity relation = visitorDeviceService.findByInactivationAndVisitorAndPhone(
            visitor, phone
        );

        if (relation == null) {
            relation = visitorDeviceService.findByInactivationAndPhone(phone);
        }

        if (relation != null) {
            HistoryEntity history = historyService.findByVisitorDevice(relation);

            if (history != null) {
                history.setEndDay(date);
                history.setEndHour(date);
                historyService.save(history);
            }

            relation.setInactivationDate(date);
            relation.setInactivationHour(date);
            visitorDeviceService.save(relation);
        }

        relation = new VisitorDeviceEntity();
        relation.setVersionCode(versionCode);
        relation.setVersionName(versionName);
        relation.setVisitor(visitor);
        relation.setPhone(phone);
        relation = visitorDeviceService.save(relation);

        return relation;
    }
}
