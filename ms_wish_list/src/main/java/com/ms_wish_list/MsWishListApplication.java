package com.ms_wish_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class MsWishListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWishListApplication.class, args);
	}

}
