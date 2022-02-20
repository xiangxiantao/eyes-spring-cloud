package com.xxt.order.loadbalance;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author xiantao.xiang
 * @date 2022-02-20 23:37
 **/
@Slf4j
public class MyLoadBalance extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //do nothing
    }

    @Override
    public Server choose(Object o) {
        final ILoadBalancer loadBalancer = this.getLoadBalancer();
        if (log.isInfoEnabled()) {
            log.info("使用自定义的loadBalance，始终使用第一个可用服务");
        }
        return loadBalancer.getReachableServers().get(0);
    }
}
