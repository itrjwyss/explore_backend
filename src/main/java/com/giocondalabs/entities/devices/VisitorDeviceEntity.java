package com.giocondalabs.entities.devices;

import com.giocondalabs.entities.general.GenericEntity;
import com.giocondalabs.entities.identity.VisitorEntity;
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
@Table(name = "visitor_device")
public class VisitorDeviceEntity extends GenericEntity {

    @Column(name = "activation_date")
    @Temporal(TemporalType.DATE)
    private Date activationDate = new Date();

    @Column(name = "activation_hour")
    @Temporal(TemporalType.TIME)
    private Date activationHour = new Date();

    @Column(name = "last_date")
    @Temporal(TemporalType.DATE)
    private Date lastDate = new Date();

    @Column(name = "last_hour")
    @Temporal(TemporalType.TIME)
    private Date lastHour = new Date();

    @Column(name = "inactivation_date")
    @Temporal(TemporalType.DATE)
    private Date inactivationDate = null;

    @Column(name = "inactivation_hour")
    @Temporal(TemporalType.TIME)
    private Date inactivationHour = null;

    @Column(name = "version_code")
    private Integer versionCode;

    @Column(name = "version_name")
    private String versionName;

    @Column(name = "push_notification_token")
    private String pushNotificationToken = null;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private VisitorEntity visitor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PhoneEntity phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private BrowserEntity browser;

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getActivationHour() {
        return activationHour;
    }

    public void setActivationHour(Date activationHour) {
        this.activationHour = activationHour;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Date getLastHour() {
        return lastHour;
    }

    public void setLastHour(Date lastHour) {
        this.lastHour = lastHour;
    }

    public Date getInactivationDate() {
        return inactivationDate;
    }

    public void setInactivationDate(Date inactivationDate) {
        this.inactivationDate = inactivationDate;
    }

    public Date getInactivationHour() {
        return inactivationHour;
    }

    public void setInactivationHour(Date inactivationHour) {
        this.inactivationHour = inactivationHour;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPushNotificationToken() {
        return pushNotificationToken;
    }

    public void setPushNotificationToken(String pushNotificationToken) {
        this.pushNotificationToken = pushNotificationToken;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public void setVisitor(VisitorEntity visitor) {
        this.visitor = visitor;
    }

    public PhoneEntity getPhone() {
        return phone;
    }

    public void setPhone(PhoneEntity phone) {
        this.phone = phone;
    }

    public BrowserEntity getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserEntity browser) {
        this.browser = browser;
    }
}
