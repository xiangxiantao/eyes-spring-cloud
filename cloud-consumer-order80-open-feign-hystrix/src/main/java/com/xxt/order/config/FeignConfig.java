package com.xxt.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiantao.xiang
 * @date 2022-02-21 20:50
 **/
@Configuration
public class FeignConfig {

    /**
     * 调整日志级别为全部输出
     *
     * @return
     */
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
