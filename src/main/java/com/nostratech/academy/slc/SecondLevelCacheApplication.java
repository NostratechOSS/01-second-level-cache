package com.nostratech.academy.slc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SecondLevelCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondLevelCacheApplication.class, args);
	}

}
