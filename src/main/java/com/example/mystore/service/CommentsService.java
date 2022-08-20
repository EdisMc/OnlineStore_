package com.example.mystore.service;

import com.example.mystore.model.binding.CommentBindingDto;
import com.example.mystore.model.entity.CommentEntity;

public interface CommentsService {

    void deleteByProductId(Long id);

    CommentEntity saveComment(CommentBindingDto commentBindingDto, Long productId, Long AuthorId);
}
