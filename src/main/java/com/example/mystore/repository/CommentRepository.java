package com.example.mystore.repository;

import com.example.mystore.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    void deleteByProductEntityId(Long id);
}
