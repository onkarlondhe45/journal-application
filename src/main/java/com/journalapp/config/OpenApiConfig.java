package com.journalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Journal Application API")
				.description("This Journal Application enables user to write journal.").version("1.0.0")
				.termsOfService("Terms of service URL")
				.contact(new Contact().name("Onkar Londhe").email("onkarlondhe78@gmail.com").url("https://github.com/onkarlondhe45"))
				.license(new License().name("Onkar Londhe").url("onkar.londhe")));
	}
}
