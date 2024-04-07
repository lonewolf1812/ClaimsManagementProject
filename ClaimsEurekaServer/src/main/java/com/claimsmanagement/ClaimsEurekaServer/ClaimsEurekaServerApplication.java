package com.claimsmanagement.ClaimsEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ClaimsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimsEurekaServerApplication.class, args);
	}

}
