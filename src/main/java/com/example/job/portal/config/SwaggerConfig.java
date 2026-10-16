package com.example.job.portal.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Job Bee", version = "1.0", description = "Simple Job Portal using Spring Boot"))
public class SwaggerConfig {
}
