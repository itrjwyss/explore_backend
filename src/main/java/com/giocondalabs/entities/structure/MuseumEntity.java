package com.giocondalabs.entities.structure;

import com.giocondalabs.entities.general.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "museum")
public class MuseumEntity extends GenericEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String picture;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name="registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CountryEntity country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_location_id")
    private StateLocationEntity stateLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CityEntity city;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean active = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public StateLocationEntity getStateLocation() {
        return stateLocation;
    }

    public void setStateLocation(StateLocationEntity stateLocation) {
        this.stateLocation = stateLocation;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
