package com.giocondalabs.entities.structure;

import com.giocondalabs.entities.general.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
@SuppressWarnings("unused")
public class CountryEntity extends GenericEntity {

    @Column(length = 80, nullable = false, unique = true)
    private String name;

    @Column(length = 2, nullable = false, unique = true)
    private String iso;

    @Column(length = 30, name = "state_label")
    private String stateLabel;

    @Column(length = 30, name = "city_label")
    private String cityLabel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public String getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(String cityLabel) {
        this.cityLabel = cityLabel;
    }
}
