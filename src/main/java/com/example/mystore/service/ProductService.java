package com.example.mystore.service;

import com.example.mystore.model.binding.ProductAddBindingModel;
import com.example.mystore.model.binding.ProductSearchingBindingModel;
import com.example.mystore.model.entity.ProductEntity;
import com.example.mystore.model.view.productViews.*;
import com.example.mystore.model.view.userViews.UserChatViewModel;
import com.example.mystore.securityUser.ShopUserDetails;
import java.util.List;
import java.util.Set;

public interface ProductService {

    void initializeProducts();

    void deleteFistProduct();

    ProductEntity addProductBindingModel(ProductAddBindingModel productAddBindingModel, ShopUserDetails sellAndBuyUser);

    List<ProductSearchViewModel> filterBy(ProductSearchingBindingModel productSearchingBindingModel, Long principalId,
                                          boolean getOnlyPromotions);

    ProductEntity findById(Long productId);

    ProductEntity addProductEntity(ProductEntity product);

    public boolean isConsist(Set<ProductEntity> productEntitySet, BaseProductViewModel product);

    public boolean isConsist(Set<ProductEntity> productEntitySet, ProductEntity product);

    void deleteProductById(Long id);

    Set<ProductEntity> findProductsByUserId(Long id);

    ProductEditViewModel findByIdProductSearchAndEditViewModel(Long id);

    ProductEntity updateProductById(Long id, ProductEditViewModel productEditViewModel);

    public ProductDetailsViewDto getAndIncreaseViewsProductById(Long id);

    Set<ProductChatViewModel> getProductsFromChatsByUserByUserId(Long id);

    Set<UserChatViewModel> findProductChattersByProductIdAndSellerId(Long productId, Long sellerId);

    List<ProductSearchViewModel> getThreeRandomProducts();

    public void changePromotions();

    public void removeExpiredProducts();

    boolean isCurrentUserHaveAuthorizationToEditProductCheckingBySellerIdAndCurrentUserId(Long productId, Long currentUserId);

}
