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
    name = "city",
    indexes = {
        @Index(columnList = "name")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "UniqueNameAndStateLocation", columnNames = {"name", "state_location_id"})
    }
)
@SuppressWarnings("unused")
public class CityEntity extends GenericEntity {

    @Column(length = 80, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "state_location_id")
    private StateLocationEntity stateLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateLocationEntity getStateLocation() {
        return stateLocation;
    }

    public void setStateLocation(StateLocationEntity stateLocation) {
        this.stateLocation = stateLocation;
    }
}
