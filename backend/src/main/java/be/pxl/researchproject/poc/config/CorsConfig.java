package be.pxl.researchproject.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Add allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add allowed HTTP methods
                .allowedHeaders("*"); // Add allowed headers
    }
}