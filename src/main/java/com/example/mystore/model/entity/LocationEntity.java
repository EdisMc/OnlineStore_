package com.example.mystore.model.entity;

import com.example.mystore.model.entity.enums.LocationEnum;
import javax.persistence.*;

@Table(name = "locations")
@Entity
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LocationEnum location;

    public LocationEntity() {
    }

    public Long getId() {
        return id;
    }

    public LocationEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocationEnum getLocation() {
        return location;
    }

    public LocationEntity setLocation(LocationEnum location) {
        this.location = location;
        return this;
    }

}
