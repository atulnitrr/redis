package com.redis.jedis.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JedisApplication.class, args);
		System.out.println("app runni");
	}

}
