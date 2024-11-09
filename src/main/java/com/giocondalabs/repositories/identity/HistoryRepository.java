package com.giocondalabs.repositories.identity;

import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.HistoryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HistoryRepository implements PanacheRepository<HistoryEntity> {

    public HistoryEntity findByKeycode(String keycode) {
        return find("keycode", keycode).firstResult();
    }

    public HistoryEntity findByVisitorDevice(VisitorDeviceEntity visitorDevice) {
        return find("visitorDevice", visitorDevice).firstResult();
    }
}
