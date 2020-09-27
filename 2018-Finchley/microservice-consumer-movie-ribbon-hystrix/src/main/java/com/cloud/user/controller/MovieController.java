package com.cloud.user.controller;

import com.cloud.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouli
 */
@RestController
public class MovieController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /* @HystrixCommand(fallbackMethod = "findByIdFallback",
             commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")
                *//* , @HystrixProperty(name = "hystrix.command.HystrixCommandKey.metrics.rollingStats.timeInMilliseconds", value = "10000")},
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "2")
                , @HystrixProperty(name = "maxQueueSize", value = "10")*//*})*/
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @GetMapping("/users/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        User user = this.restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        // ...电影微服务的业务...
        System.out.println(user);
        return user;
    }

    @GetMapping("/logInstance")
    @ResponseBody
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        LOGGER.info("调用的服务信息-{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    public User findByIdFallback(Long id) {
        User user = new User(-1, "默认用户");
        return user;
    }
}
