package com.example.gethelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class GetHelloWorldApplication {
	public static void main(String[] args) {
		SpringApplication.run(GetHelloWorldApplication.class, args);
	}

}
