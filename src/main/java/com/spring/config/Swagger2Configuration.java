package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan
@EnableSwagger2
@EnableWebMvc	
public class Swagger2Configuration {

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.any())
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "Spring Oauth2 Service",
	      "Spring Oauth2 Service Application (mailto:)",
	      "v1.0",
	      "Terms of Service URL",
	      "Loyalty Department",
	      null,
	      "API license URL");
	    return apiInfo;
	}
}
