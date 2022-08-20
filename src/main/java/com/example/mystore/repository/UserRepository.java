package com.example.mystore.repository;

import com.example.mystore.model.entity.UserEntity;
import com.example.mystore.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByEmailAndPassword(String email,String password);

    Set<UserEntity> findUserEntitiesByRolesContaining(UserRoleEntity role);
}
