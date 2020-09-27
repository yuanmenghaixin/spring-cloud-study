package com.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为Ribbon的配置类
 * 注意：该类不能放在主应用程序上下文@ComponentScan所扫描的包中，否则配置将会被所有Ribbon Client共享。
 * @author 周立
 */
@Configuration
public class RibbonConfiguration {
  @Bean
  public IRule ribbonRule() {
    // 负载均衡规则，改为随机
    return new RandomRule();
  }

 /* @Bean
  @ConditionalOnMissingBean
  public IRule ribbonRule(IClientConfig conf) {
    ZoneAvoidanceRule rule=new ZoneAvoidanceRule();
    rule.initWithNiwsConfig(conf);
    return rule;
  }*/
}
