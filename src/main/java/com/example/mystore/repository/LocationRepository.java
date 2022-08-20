package com.example.mystore.repository;

import com.example.mystore.model.entity.LocationEntity;
import com.example.mystore.model.entity.enums.LocationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {

    Optional<LocationEntity> findByLocation(LocationEnum locationEnum);
}
