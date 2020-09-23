package com.cloud.controller;

import com.cloud.entity.User;
import com.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author zhouli
 */
@RequestMapping("/users")
@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ApplicationContext applicationContext;

  @GetMapping("/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    System.out.println("调用user服务的端口："+applicationContext.getEnvironment().getProperty("server.port"));
    return this.userRepository.findById(id);
  }
}
