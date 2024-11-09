package com.giocondalabs.services.identity;

import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.HistoryEntity;

public interface HistoryService {

    HistoryEntity findById(Long id);

    HistoryEntity findByKeycode(String keycode);

    HistoryEntity findByVisitorDevice(VisitorDeviceEntity visitorDevice);

    void save(HistoryEntity history);
}
