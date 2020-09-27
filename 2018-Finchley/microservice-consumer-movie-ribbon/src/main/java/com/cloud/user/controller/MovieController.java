package com.cloud.user.controller;

import com.cloud.user.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouli
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
    private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        // ...电影微服务的业务...
        return user;
    }

    @GetMapping("/logInstance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        LOGGER.info("调用的服务信息-{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
