package com.example.mystore.service.impl;

import com.example.mystore.event.InitializationEvent;
import com.example.mystore.model.entity.CategoryEntity;
import com.example.mystore.model.entity.enums.CategoryEnum;
import com.example.mystore.repository.CategoryRepository;
import com.example.mystore.service.CategoryService;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @Order(3)
    @EventListener(InitializationEvent.class)
    @Override
    public void initializedCategories() {

        if (this.categoryRepository.count() == 0) {
            for (CategoryEnum category : CategoryEnum.values()) {
                CategoryEntity categoryEntity =  new CategoryEntity();
                categoryEntity.
                        setCategory(category).
                        setDescription(category.name());
                this.categoryRepository.save(categoryEntity);
            }
        }

    }

    @Override
    public CategoryEntity findByCategory(CategoryEnum category) {
        return this.categoryRepository.findByCategory(category).get();
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }




}
