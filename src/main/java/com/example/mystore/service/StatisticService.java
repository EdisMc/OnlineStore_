package com.example.mystore.service;

import com.example.mystore.model.view.statisticViews.StatisticViewModel;
import java.security.Principal;

public interface StatisticService {

    void onRequest(String requestURI, Principal userPrincipal);

    void initializeStatistic();

    StatisticViewModel getStatisticInfo();
}
