package com.giocondalabs.entities.identity;

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
@Table(name = "verification")
public class VerificationEntity extends GenericEntity {

    private static final String VERIFICATION_STATUS_CREATED = "CREATED";
    private static final String VERIFICATION_STATUS_EXPIRED = "EXPIRED";
    private static final String VERIFICATION_STATUS_VERIFIED = "VERIFIED";

    @Column(length = 75, nullable = false, unique = true)
    private String token;

    @Temporal(TemporalType.DATE)
    private Date day = new Date();

    @Temporal(TemporalType.TIME)
    private Date hour = new Date();

    @Column(length = 10, nullable = false)
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private VisitorEntity visitor;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VisitorEntity getVisitor() {
        return visitor;
    }

    public void setVisitor(VisitorEntity visitor) {
        this.visitor = visitor;
    }
}
