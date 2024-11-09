package com.giocondalabs.repositories.devices;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.VisitorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VisitorDeviceRepository implements PanacheRepository<VisitorDeviceEntity> {

    public VisitorDeviceEntity findByInactivationAndPhone(PhoneEntity phone) {
        return find(
            """
                inactivationDate IS NULL
                AND phone = :phone
            """,
            phone
        ).firstResult();
    }

    public VisitorDeviceEntity findByInactivationAndVisitorAndPhone(
        VisitorEntity visitor,
        PhoneEntity phone
    ) {
        return find(
            """
                inactivationDate IS NULL
                AND visitor = :visitor
                AND phone = :phone
            """,
            visitor,
            phone
        ).firstResult();
    }
}
