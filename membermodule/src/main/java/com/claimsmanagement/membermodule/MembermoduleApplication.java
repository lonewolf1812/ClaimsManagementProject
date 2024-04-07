package com.claimsmanagement.membermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
public class MembermoduleApplication {

	 
		@Bean
	    @LoadBalanced
	    public RestTemplate getRestTemplate()
		{
			return new RestTemplate();
	    }
		
		@Bean
		public HttpHeaders getHttpHeaders()
		{
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			return header;
		}
		
		public static void main(String[] args) {
		SpringApplication.run(MembermoduleApplication.class, args);
		}

		@Bean
		public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.claimsmanagement.membermodule")).build();

		}  

}
