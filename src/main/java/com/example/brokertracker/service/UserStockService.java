package com.example.brokertracker.service;


import com.example.brokertracker.model.UserStock;
import com.example.brokertracker.repository.UserStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStockService {
    private final UserStockRepository userStockRepository;

    @Autowired
    public UserStockService(UserStockRepository userStockRepository) {
        this.userStockRepository = userStockRepository;
    }


    public List<UserStock> getUserStocks(Long user_id) {
       return userStockRepository.findByUser_Id(user_id);
    }
}
