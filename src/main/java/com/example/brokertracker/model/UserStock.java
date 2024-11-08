package com.example.brokertracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_stocks")
public class UserStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_stock_id")
    private Long userStockId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "stock_name")
    private String stockName;

    private Long quantity;


}
