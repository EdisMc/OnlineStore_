package com.example.mystore.service;

import com.example.mystore.model.entity.CategoryEntity;
import com.example.mystore.model.entity.enums.CategoryEnum;

public interface CategoryService {

    void initializedCategories();

    CategoryEntity findByCategory(CategoryEnum category);

    CategoryEntity updateCategory(CategoryEntity category);

}
