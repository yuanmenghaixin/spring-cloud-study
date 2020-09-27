package com.cloud.user.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User(Long id, String username, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
