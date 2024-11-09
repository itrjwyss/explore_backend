package com.giocondalabs.services.devices;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.VisitorEntity;

public interface VisitorDeviceService {

    VisitorDeviceEntity findById(Long id);

    public VisitorDeviceEntity findByInactivationAndPhone(PhoneEntity phone);

    VisitorDeviceEntity findByInactivationAndVisitorAndPhone(
        VisitorEntity visitor,
        PhoneEntity phone
    );

    VisitorDeviceEntity save(VisitorDeviceEntity visitorDevice);
}
