package com.giocondalabs.entities.identity;

import com.giocondalabs.entities.general.GenericEntity;
import com.giocondalabs.entities.structure.CityEntity;
import com.giocondalabs.entities.structure.CountryEntity;
import com.giocondalabs.entities.structure.StateLocationEntity;
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
@Table(name = "visitor")
public class VisitorEntity extends GenericEntity {

    private static final String VISITOR_STATUS_ACTIVE = "ACTIVE";
    private static final String VISITOR_STATUS_PENDING = "PENDING";
    private static final String VISITOR_STATUS_BLOCKED = "BLOCKED";
    private static final String VISITOR_STATUS_DELETED = "DELETED";

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 200)
    private String picture;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    @Column(length = 75, nullable = false)
    private String password;

    @Column(name="registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate = new Date();

    @Column(length = 10, nullable = false)
    private String status = VISITOR_STATUS_PENDING;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private CountryEntity country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_location_id")
    private StateLocationEntity stateLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CityEntity city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
