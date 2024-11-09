package com.giocondalabs.services.devices;

import com.giocondalabs.entities.devices.PhoneEntity;
import com.giocondalabs.repositories.devices.PhoneRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PhoneServiceImpl implements PhoneService {

    @Inject
    PhoneRepository repository;

    @Override
    public PhoneEntity findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public PhoneEntity findByUniqueId(String uniqueId) {
        return repository.findByUniqueId(uniqueId);
    }

    @Transactional
    @Override
    public PhoneEntity save(PhoneEntity phone) {
        if (phone.getId() != null) {
            PhoneEntity temp = findById(phone.getId());

            temp.setUniqueId(phone.getUniqueId());
            temp.setBrand(phone.getBrand());
            temp.setModel(phone.getModel());
            temp.setSdkInt(phone.getSdkInt());
            temp.setReleaseVersion(phone.getReleaseVersion());

            repository.persist(temp);
            return temp;
        } else {
            repository.persistAndFlush(phone);
            return phone;
        }
    }
}
