package com.claimsmanagement.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@EnableSwagger2
public class AuthorizationServiceApplication {

	@Bean
    @LoadBalanced
   public RestTemplate getRestTemplate()
   {
		return new RestTemplate();
  }
	public static void main(String[] args) {
	
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.claimsmanagement.authorization")).build();
	}

}
