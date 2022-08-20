package com.example.mystore.web.rest;

import com.example.mystore.model.view.productViews.ProductFavoriteViewModel;
import com.example.mystore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserFavoritesController {

    private final UserService userService;

    public UserFavoritesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/favorites")
    public ResponseEntity<List<ProductFavoriteViewModel>> getAllFavorites(@PathVariable Long id) {
        List<ProductFavoriteViewModel> returnFavoritesViwModels = this.userService.returnFavoritesViwModels(id);
        return ResponseEntity.ok(returnFavoritesViwModels);
    }

}
