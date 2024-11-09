package com.giocondalabs.repositories.devices;

import com.giocondalabs.entities.devices.PhoneEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PhoneRepository implements PanacheRepository<PhoneEntity> {

    public PhoneEntity findByUniqueId(String uniqueId) {
        return find("uniqueId", uniqueId).firstResult();
    }
}
