package com.giocondalabs.entities.devices;

import com.giocondalabs.entities.general.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone")
public class PhoneEntity extends GenericEntity {

    @Column(length = 20, nullable = false, unique = true, name = "unique_id")
    private String uniqueId;

    @Column(length = 30, nullable = false)
    private String brand;

    @Column(length = 30, nullable = false)
    private String model;

    @Column(name = "sdk_int")
    private Integer sdkInt;

    @Column(length = 50, name = "release_version")
    private String releaseVersion;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSdkInt() {
        return sdkInt;
    }

    public void setSdkInt(Integer sdkInt) {
        this.sdkInt = sdkInt;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }
}
