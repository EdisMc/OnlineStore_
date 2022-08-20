package com.example.mystore.repository;

import com.example.mystore.model.entity.CategoryEntity;
import com.example.mystore.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByCategory(CategoryEnum category);
}
