package com.diamam.statsApp.service;

import com.diamam.statsApp.entity.Statistics;

import java.util.List;

public interface StoreService {

    void saveData(Statistics stats);
    Statistics getSingleData(Integer id);
    List<Statistics> getListData();

}
