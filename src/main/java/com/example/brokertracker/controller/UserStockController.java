package com.example.brokertracker.controller;

import com.example.brokertracker.model.UserStock;
import com.example.brokertracker.service.UserStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{user_id}")
    public ResponseEntity<UserStock> createUserStock(@PathVariable Long user_id, @RequestBody UserStock userStock) {
        UserStock savedUserStock = userStockService.createUserStock(user_id, userStock);
        return new ResponseEntity<>(savedUserStock, HttpStatus.CREATED);
    }

    @PutMapping("/{user_stock_id}")
    public ResponseEntity<UserStock> updateUserStock(@PathVariable Long user_stock_id, @RequestBody UserStock userStock) {
        UserStock updatedUserStock = userStockService.updateUserStock(user_stock_id, userStock);
        return new ResponseEntity<>(updatedUserStock, HttpStatus.OK);
    }

}
