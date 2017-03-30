package com.denarced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SecHtmlLoginTryoutApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(SecHtmlLoginTryoutApplication.class, args);
	}
}
