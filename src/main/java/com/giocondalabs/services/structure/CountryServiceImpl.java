package com.giocondalabs.services.structure;

import com.giocondalabs.entities.structure.CountryEntity;
import com.giocondalabs.repositories.structure.CountryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CountryServiceImpl implements CountryService {

    @Inject
    CountryRepository repository;

    @Override
    public CountryEntity findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CountryEntity> findAll() {
        return repository.findAll().list();
    }

    @Transactional
    @Override
    public void save(CountryEntity country) {
        if (country.getId() == null) {
            CountryEntity temp = findById(country.getId());

            temp.setIso(country.getIso());
            temp.setName(country.getName());
            temp.setStateLabel(country.getStateLabel());
            temp.setCityLabel(country.getCityLabel());

            repository.persist(temp);
        } else {
            repository.persistAndFlush(country);
        }
    }
}
