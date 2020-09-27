package com.cloud.controller;

import com.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author zhouli
 */
@RequestMapping("/users")
@RestController
public class UserController {


    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        System.out.println("调用user服务的端口：" + applicationContext.getEnvironment().getProperty("server.port"));
        //return this.userRepository.findById(id);
        return new User(1L, "account1", "张三", 20, new BigDecimal(100.00));
    }
}
