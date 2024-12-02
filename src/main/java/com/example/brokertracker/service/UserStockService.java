package com.example.brokertracker.service;


import com.example.brokertracker.model.User;
import com.example.brokertracker.model.UserStock;
import com.example.brokertracker.repository.UserRepository;
import com.example.brokertracker.repository.UserStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStockService {
    private final UserStockRepository userStockRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserStockService(UserStockRepository userStockRepository, UserRepository userRepository) {
        this.userStockRepository = userStockRepository;
        this.userRepository = userRepository;
    }


    public List<UserStock> getUserStocks(Long user_id) {
       return userStockRepository.findByUser_Id(user_id);
    }

    public UserStock createUserStock(Long user_id, UserStock userStock) {
        // get user from user id and set userstock user to that
        Optional<User> user = userRepository.findById(user_id);
        if (user.isPresent()) {
            userStock.setUser(user.get());
            return userStockRepository.save(userStock);
        } else {
            throw new RuntimeException("User not found with id " + user_id);
        }
    }

    public UserStock updateUserStock(Long userStockId, UserStock userStock) {
        Optional<UserStock> existingUserStock = userStockRepository.findById(userStockId);
        if (existingUserStock.isPresent()) {
            UserStock userStockToUpdate = existingUserStock.get();
            userStockToUpdate.setQuantity(userStock.getQuantity());
            return userStockRepository.save(userStockToUpdate);
        } else {
            throw new RuntimeException("UserStock not found with id " + userStockId);
        }

    }
}
