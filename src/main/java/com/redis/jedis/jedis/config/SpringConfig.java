package com.redis.jedis.jedis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class SpringConfig {


    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;


    @Value("${redis.jedis.pool.max-total}")
    private int maxTotal;


    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;


    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;


    @Bean
    public JedisClientConfiguration jedisClientConfiguration() {

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisClientConfigurationBuilder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        final GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        return jedisClientConfigurationBuilder.poolConfig(poolConfig).build();
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(host);
        standaloneConfiguration.setPort(port);
        return new JedisConnectionFactory(standaloneConfiguration, jedisClientConfiguration());
    }


    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }



}
