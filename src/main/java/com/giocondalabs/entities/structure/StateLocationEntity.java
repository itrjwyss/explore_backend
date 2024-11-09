package com.giocondalabs.entities.structure;

import com.giocondalabs.entities.general.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "state_location",
    indexes = {
        @Index(columnList = "name")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "UniqueNameAndCountry", columnNames = {"name", "country_id"})
    }
)
@SuppressWarnings("unused")
public class StateLocationEntity extends GenericEntity {

    @Column(length = 80, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CountryEntity country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
