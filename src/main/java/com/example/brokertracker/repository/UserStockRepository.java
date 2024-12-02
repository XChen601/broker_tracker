package com.example.brokertracker.repository;

import com.example.brokertracker.model.User;
import com.example.brokertracker.model.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {
    List<UserStock> findByUser_Id(Long userId);

}
