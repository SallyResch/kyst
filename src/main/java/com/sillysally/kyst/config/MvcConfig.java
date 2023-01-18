package com.sillysally.kyst.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/frontend/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("/frontend/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("frontend/build/index.html");
    }
}
