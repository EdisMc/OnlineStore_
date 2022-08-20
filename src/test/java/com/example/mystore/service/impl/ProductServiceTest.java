package com.example.mystore.service.impl;

import com.example.mystore.init.TestDataInit;
import com.example.mystore.model.binding.CommentBindingDto;
import com.example.mystore.model.entity.CommentEntity;
import com.example.mystore.model.entity.ProductEntity;
import com.example.mystore.model.entity.UserEntity;
import com.example.mystore.model.entity.enums.CategoryEnum;
import com.example.mystore.model.entity.enums.LocationEnum;
import com.example.mystore.repository.CommentRepository;
import com.example.mystore.service.CommentsService;
import com.example.mystore.service.ProductService;
import com.example.mystore.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    @Mock
    private CommentRepository commentRepository;

    @Autowired
    private TestDataInit testDataInit;

    private CommentsService commentsServiceToTest;

    @BeforeEach
    void setUp(){
        commentsServiceToTest = new CommentServiceImpl(commentRepository,userService,productService);
    }


    @Test
    void save_Comment(){

        UserEntity user = this.testDataInit.createTestUser("user@abv.bg");

        ProductEntity product = this.testDataInit.createTestProduct(
                "Test product 1,for testing purpose",
                "Test Product 1",
                BigDecimal.valueOf(20L),
                LocationEnum.SOFIA_GRAD,
                user,
                CategoryEnum.ELECTRONICS,
                true
        );

        CommentEntity newCommentForReturnWithId = testDataInit.createComment(user,product);

        CommentEntity newCommentForSaveWithOutId = testDataInit.createComment(user,product);
        newCommentForSaveWithOutId.setId(null);

        CommentBindingDto commentBindingDto = new CommentBindingDto().setTextContent("Test comment content.");




        when(productService.findById(product.getId())).
                thenReturn(product);

        when(userService.findById(user.getId())).
                thenReturn(user);

        when(commentRepository.save(newCommentForSaveWithOutId)).
                thenReturn(newCommentForReturnWithId);

        CommentEntity testComment = commentsServiceToTest.
                saveComment(commentBindingDto, product.getId(), user.getId());





        Assertions.assertEquals(user.getEmail(),testComment.getAuthor().getEmail());
        Assertions.assertEquals(user.getFirstName(),testComment.getAuthor().getFirstName());
        Assertions.assertEquals(user.getLastName(),testComment.getAuthor().getLastName());
        Assertions.assertEquals(newCommentForReturnWithId.getProduct().getTitle(),testComment.getProduct().getTitle());


    }


}
