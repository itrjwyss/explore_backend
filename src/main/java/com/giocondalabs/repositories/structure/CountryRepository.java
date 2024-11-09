package com.giocondalabs.repositories.structure;

import com.giocondalabs.entities.structure.CountryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<CountryEntity> {  }
