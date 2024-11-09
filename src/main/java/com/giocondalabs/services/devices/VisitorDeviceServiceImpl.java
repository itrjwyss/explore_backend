package com.giocondalabs.services.devices;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.entities.devices.VisitorDeviceEntity;
import com.giocondalabs.entities.identity.VisitorEntity;
import com.giocondalabs.repositories.devices.VisitorDeviceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VisitorDeviceServiceImpl implements VisitorDeviceService {

    @Inject
    VisitorDeviceRepository repository;

    @Override
    public VisitorDeviceEntity findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public VisitorDeviceEntity findByInactivationAndPhone(PhoneEntity phone) {
        return repository.findByInactivationAndPhone(phone);
    }

    @Override
    public VisitorDeviceEntity findByInactivationAndVisitorAndPhone(VisitorEntity visitor, PhoneEntity phone) {
        return repository.findByInactivationAndVisitorAndPhone(visitor, phone);
    }

    @Transactional
    @Override
    public VisitorDeviceEntity save(VisitorDeviceEntity visitorDevice) {
        if (visitorDevice.getVisitor() == null) {
            VisitorDeviceEntity temp = findById(visitorDevice.getId());

            temp.setActivationDate(visitorDevice.getActivationDate());
            temp.setActivationHour(visitorDevice.getActivationHour());
            temp.setLastDate(visitorDevice.getLastDate());
            temp.setLastHour(visitorDevice.getLastHour());
            temp.setInactivationDate(visitorDevice.getInactivationDate());
            temp.setInactivationHour(visitorDevice.getInactivationHour());

            temp.setVersionCode(visitorDevice.getVersionCode());
            temp.setVersionName(visitorDevice.getVersionName());
            temp.setPushNotificationToken(visitorDevice.getPushNotificationToken());

            temp.setVisitor(visitorDevice.getVisitor());
            temp.setPhone(visitorDevice.getPhone());
            temp.setBrowser(visitorDevice.getBrowser());

            repository.persist(temp);
            return temp;
        } else {
            repository.persistAndFlush(visitorDevice);
            return visitorDevice;
        }
    }
}
