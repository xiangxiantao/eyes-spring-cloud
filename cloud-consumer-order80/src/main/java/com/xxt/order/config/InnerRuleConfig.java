package com.xxt.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.xxt.order.loadbalance.MyLoadBalance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将IRule的配置内被容器自动加载，会使得全局的负载均衡算法改变
 * @author xiantao.xiang
 * @date 2022-02-20 23:33
 **/
//@Configuration
public class InnerRuleConfig {

    @Bean
    public IRule rule() {
        return new MyLoadBalance();
    }

}
