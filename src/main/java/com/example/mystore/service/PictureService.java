package com.example.mystore.service;

import com.example.mystore.model.entity.PictureEntity;
import java.util.Optional;

public interface PictureService {

    PictureEntity addPictureEntity(PictureEntity picture1);

    PictureEntity getFirstPicture();

    PictureEntity addPictureInDb(PictureEntity pictureEntity);

    void deletePictureById(Long id);

   Optional <PictureEntity> findByUrl(String urlPicture);

    void deleteOldPictureById(Long id);
}
