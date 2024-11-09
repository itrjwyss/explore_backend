package com.giocondalabs.implementation;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.VisitorEntity;
import com.giocondalabs.objects.data.DeviceData;

public interface IdentityManager {

    PhoneEntity checkDevice(DeviceData data);

    VisitorDeviceEntity checkRelation(
        PhoneEntity phone,
        VisitorEntity visitor,
        Integer versionCode,
        String versionName
    );
}
