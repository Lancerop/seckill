package com.team.config;

import com.team.manager.SedissonManage;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname SedissonManageAutoConfiguration
 * @Description TODO
 * @Date 2021/7/16 下午9:58
 * @Created by muyi
 */

@Configuration
public class SedissonManageAutoConfiguration {
    public SedissonManageAutoConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean({SedissonManage.class})
    public SedissonManage sedissonManage(RedissonClient redissonClient) {
        return new SedissonManage(redissonClient);
    }
}
