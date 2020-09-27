package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author zhouli
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerMovieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieApplication.class, args);
  }
}
