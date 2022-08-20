package com.example.mystore.service.impl;

import com.example.mystore.model.entity.PictureEntity;
import com.example.mystore.repository.PictureRepository;
import com.example.mystore.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public PictureEntity addPictureEntity(PictureEntity picture1) {
        return pictureRepository.save(picture1);
    }

    @Override
    public PictureEntity getFirstPicture() {
        return pictureRepository.findAll().get(0);
    }

    @Override
    public PictureEntity addPictureInDb(PictureEntity pictureEntity) {

        return this.pictureRepository.save(pictureEntity);
    }

    @Override
    public void deletePictureById(Long id) {
        this.pictureRepository.deleteById(id);
    }

    @Override
    public Optional<PictureEntity> findByUrl(String urlPicture) {
       return this.pictureRepository.findByUrl(urlPicture);
    }

    @Override
    public void deleteOldPictureById(Long id) {
        this.pictureRepository.deleteById(id);
    }

}