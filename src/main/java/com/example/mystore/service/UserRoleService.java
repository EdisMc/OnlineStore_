package com.example.mystore.service;

import com.example.mystore.model.entity.UserRoleEntity;
import com.example.mystore.model.entity.enums.UserRoleEnum;

public interface UserRoleService {

     void initializeRoles();

     UserRoleEntity findByRole(UserRoleEnum userRoleEnum);
}
