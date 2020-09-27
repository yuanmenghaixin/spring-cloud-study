package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author zhouli
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMovieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieApplication.class, args);
  }
}
