package com.example.mystore.repository;

import com.example.mystore.model.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity,Long> {

    void deleteByProductId(Long id);

    void deleteById(Long id);

   Optional<PictureEntity> findByUrl(String urlPicture);
}
