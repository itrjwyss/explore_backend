package com.giocondalabs.entities.devices;

import com.giocondalabs.entities.general.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "browser")
public class BrowserEntity extends GenericEntity {

    @Column(nullable = false, length = 50)
    private String name;

    //Kind of Device
    @Column(nullable = false, length = 25)
    private String category;

    @Column(nullable = false, length = 25)
    private String os;

    @Column(nullable = false, length = 10)
    private String version;

    @Column(length = 50)
    private String vendor;

    @Column(nullable = false, length = 10, name = "os_version")
    private String osVersion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
}
