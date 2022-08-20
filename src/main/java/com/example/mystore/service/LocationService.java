package com.example.mystore.service;

import com.example.mystore.model.entity.LocationEntity;
import com.example.mystore.model.entity.enums.LocationEnum;

public interface LocationService {

    void initializeLocations();

    LocationEntity findByLocation(LocationEnum sofiaGrad);
}
