package com.intuit.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.intuit.spring.service", "com.intuit.spring.dao" , "com.intuit.spring.controller" })
public class AppConfig {

}
