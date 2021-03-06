package com.cloud.user.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    public User() {
    }

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

    public User(Long id, String username, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
}
