package com.diamam.statsApp.service;

import com.diamam.statsApp.entity.Statistics;
import com.diamam.statsApp.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStoreService implements StoreService {

    private final StatisticsRepository repository;

    @Override
    public void saveData(Statistics stats) {
        repository.save(stats);
    }

    @Override
    public Statistics getSingleData(Integer id) {
        return repository.findById(id).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public List<Statistics> getListData() {
        return repository.findAll();
    }

    @Autowired
    public DataStoreService(StatisticsRepository repository) {
        this.repository = repository;
    }


}
