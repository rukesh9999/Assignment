package com.api.store.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

	
	@Bean
	public Docket apibean()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
				
	}
	
	
	public ApiInfo getApiInfo()
	{
   		
		return new ApiInfoBuilder()
				   .title("Store-API")
				   .version("1.0")
				   .description("used for storing the urls")
				   .contact(new Contact("rukesh", "http://www.techlearn.com", "rukesh235@gmail.com"))
				   .license("Apache licence 2.0")
				   .build();
		
	}
}
