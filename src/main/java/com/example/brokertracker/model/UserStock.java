package com.example.brokertracker.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "user_stocks",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = {"user_id", "stock_name"})
    }
)
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

    public Long getUserStockId() {
        return userStockId;
    }

    public User getUser() {
        return user;
    }

    public String getStockName() {
        return stockName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setUserStockId(Long userStockId) {
        this.userStockId = userStockId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
