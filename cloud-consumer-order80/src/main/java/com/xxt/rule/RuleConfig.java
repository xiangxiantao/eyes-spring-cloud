package com.xxt.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiantao.xiang
 * @date 2022-02-20 23:11
 **/
@Configuration
public class RuleConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
