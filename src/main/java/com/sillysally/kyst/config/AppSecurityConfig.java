package com.sillysally.kyst.config;

import com.sillysally.kyst.authorities.UserRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration //överskrider en viss funktionalitet (security filter chain i detta fall)
@EnableWebSecurity //överskrider vår säkerhet i endpoints med vissa roller
@EnableMethodSecurity //Enables PreAuthorise
public class AppSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/", "/login", "/error","/signup", "/restAPI/encode").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/user").hasRole("MODERATOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        return http.build();
    }
    //TODO Tell spring security which password to use
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("Sally")
                .password("password")
                //.roles("ADMIN") //<----Old way of .authorities (only role)
                .authorities(UserRoles.ADMIN.getGrantedAuthorities()) //<----- new way (both permissions and role)
                .build();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password")
                .authorities(UserRoles.USER.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(admin, user1);
    }
}
