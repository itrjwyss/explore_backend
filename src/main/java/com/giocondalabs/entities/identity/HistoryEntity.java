package com.giocondalabs.entities.identity;

import com.giocondalabs.entities.devices.VisitorDeviceEntity;
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
@Table(name = "history")
public class HistoryEntity extends GenericEntity {

    @Column(nullable = false, length = 100)
    private String keycode;

    @Column(name = "start_day")
    @Temporal(value = TemporalType.DATE)
    private Date startDay = new Date();

    @Column(name = "start_hour")
    @Temporal(value = TemporalType.TIME)
    private Date startHour = new Date();

    @Column(name = "end_day")
    @Temporal(value = TemporalType.DATE)
    private Date endDay = null;

    @Column(name = "end_hour")
    @Temporal(value = TemporalType.TIME)
    private Date endHour = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_device_id")
    private VisitorDeviceEntity visitorDevice;

    public HistoryEntity() { }

    public HistoryEntity(String keycode, VisitorDeviceEntity visitorDevice) {
        this.keycode = keycode;
        this.visitorDevice = visitorDevice;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public VisitorDeviceEntity getVisitorDevice() {
        return visitorDevice;
    }

    public void setVisitorDevice(VisitorDeviceEntity visitorDevice) {
        this.visitorDevice = visitorDevice;
    }
}
