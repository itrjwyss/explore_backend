package com.giocondalabs.services.devices;

import com.giocondalabs.entities.devices.PhoneEntity;

public interface PhoneService {

    PhoneEntity findById(Long id);

    PhoneEntity findByUniqueId(String uniqueId);

    PhoneEntity save(PhoneEntity phone);
}
