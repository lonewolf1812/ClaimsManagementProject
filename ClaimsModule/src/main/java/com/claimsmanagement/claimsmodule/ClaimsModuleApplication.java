package com.claimsmanagement.claimsmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
//@EnableFeignClients
@EnableJpaRepositories("com.claimsmanagement.claimsmodule.respository")
@EntityScan("com.claimsmanagement.claimsmodule.model")
@SpringBootApplication
@EnableSwagger2
public class ClaimsModuleApplication {
    
	@Bean
    @LoadBalanced
   public RestTemplate getRestTemplate()
   {
		return new RestTemplate();
  }
    
	public static void main(String[] args) {
		SpringApplication.run(ClaimsModuleApplication.class, args);
	}
	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.claimsmanagement.claimsmodule")).build();
	   }
}
