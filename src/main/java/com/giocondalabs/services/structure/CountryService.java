package com.giocondalabs.services.structure;

import com.giocondalabs.entities.structure.CountryEntity;
import java.util.List;

public interface CountryService {

    CountryEntity findById(Long id);

    List<CountryEntity> findAll();

    void save(CountryEntity country);
}
