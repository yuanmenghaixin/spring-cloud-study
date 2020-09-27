package com.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhouli
 */
@Entity
@Data


public class User {
    public User() {
    }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String username;
  @Column
  private String name;
  @Column
  private Integer age;
  @Column
  private BigDecimal balance;

    public User(Long id, String username, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
}
