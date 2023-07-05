package com.portfolio.amo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Grafen Whor
 */

@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer{
    
     @Override
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
    public void addCorsMappings(CorsRegistry registry) {
                .exposedHeaders("Authorization")
                .allowCredentials(true);
        
    }*/

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedMethods("*");
    }
}





   