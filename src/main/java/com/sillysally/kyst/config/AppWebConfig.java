package com.sillysally.kyst.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppWebConfig implements WebMvcConfigurer {
    /*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/user").setViewName("userPage");
        registry.addViewController("/admin").setViewName("adminPage");
        registry.addViewController("/signup").setViewName("signupPage");
        registry.addViewController("/login").setViewName("loginPage");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    */

    }
}
