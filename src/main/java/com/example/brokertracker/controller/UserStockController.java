package com.example.brokertracker.controller;

import com.example.brokertracker.model.UserStock;
import com.example.brokertracker.service.UserStockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user_stocks")
public class UserStockController {
    private final UserStockService userStockService;

    public UserStockController(UserStockService userStockService) {
        this.userStockService = userStockService;
    }

    @GetMapping("/{user_id}")
    public List<UserStock> getUserStocks(@PathVariable Long user_id) {
        return userStockService.getUserStocks(user_id);
    }

}
