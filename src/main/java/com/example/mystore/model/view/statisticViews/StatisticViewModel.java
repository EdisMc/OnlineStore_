package com.example.mystore.model.view.statisticViews;

import java.time.LocalDateTime;

public class StatisticViewModel {

    private LocalDateTime created;

    private LocalDateTime modified;

    private Long authenticatedRequests;

    private Long anonymousRequests;

    private Long indexPageViews;

    private Long allProductsPageViews;

    private Long loginPageViews;

    private Long registerPageViews;

    private Long promotionsPageViews;

    private Long messagesPageViews;

    private Long favoritesPageViews;

    private Long myProfilePageViews;

    private Long myProductsPageViews;

    private Long addProductPageViews;

    private Long userInSystemPageViews;

    private Long statisticsPageViews;

    public StatisticViewModel() {
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Long getAuthenticatedRequests() {
        return authenticatedRequests;
    }

    public Long getAnonymousRequests() {
        return anonymousRequests;
    }

    public Long getIndexPageViews() {
        return indexPageViews;
    }

    public Long getAllProductsPageViews() {
        return allProductsPageViews;
    }

    public Long getLoginPageViews() {
        return loginPageViews;
    }

    public Long getRegisterPageViews() {
        return registerPageViews;
    }

    public Long getPromotionsPageViews() {
        return promotionsPageViews;
    }

    public Long getMessagesPageViews() {
        return messagesPageViews;
    }

    public Long getFavoritesPageViews() {
        return favoritesPageViews;
    }

    public Long getMyProfilePageViews() {
        return myProfilePageViews;
    }

    public Long getMyProductsPageViews() {
        return myProductsPageViews;
    }

    public Long getAddProductPageViews() {
        return addProductPageViews;
    }

    public Long getUserInSystemPageViews() {
        return userInSystemPageViews;
    }

    public Long getStatisticsPageViews() {
        return statisticsPageViews;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

}
