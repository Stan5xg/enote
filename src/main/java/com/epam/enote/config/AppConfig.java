package com.epam.enote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.epam.enote", "com.epam.enote.config"})
public class AppConfig {
}
