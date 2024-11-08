package com.example.brokertracker.controller;

import com.example.brokertracker.model.User;
import com.example.brokertracker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception e) {
            logger.error("Error creating user", e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (Exception e) {
            logger.error("Error updating user", e);
            return ResponseEntity.status(500).body(null);
        }
    }

}
