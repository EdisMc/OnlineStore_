package com.example.mystore.service.impl;

import com.example.mystore.event.InitializationEvent;
import com.example.mystore.model.entity.LocationEntity;
import com.example.mystore.model.entity.enums.LocationEnum;
import com.example.mystore.repository.LocationRepository;
import com.example.mystore.service.LocationService;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Order(1)
    @EventListener(InitializationEvent.class)
    @Override
    public void initializeLocations() {
        if(this.locationRepository.count() == 0){
            for (LocationEnum locationEnum : LocationEnum.values()) {
                LocationEntity newLocation = new LocationEntity();
                newLocation.setLocation(locationEnum);
                this.locationRepository.save(newLocation);
            }
        }
    }

    @Override
    public LocationEntity findByLocation(LocationEnum locationEnum) {
        return this.locationRepository.findByLocation(locationEnum).get();
    }
}
