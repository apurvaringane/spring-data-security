package org.jspiders.springdatasecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    //authentication
    @Bean
    public InMemoryUserDetailsManager UserDetails()
    {
        UserDetails apurva= User.builder()
                .username("apurva")
                .password("{noop}123")
                .roles("ADMIN","HR","TRACKER")
                .build();

        UserDetails ankita=User.builder()
                .username("ankita")
                .password("{noop}456")
                .roles("HR","TRACKER")
                .build();

        UserDetails arpita=User.builder()
                .username("arpita")
                .password("{noop}789")
                .roles("TRACKER")
                .build();

        return new InMemoryUserDetailsManager(apurva,ankita,arpita);

    }
    //authorization
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //http.authorizeHttpRequest
        http.authorizeHttpRequests(config ->
                        config
                              // .requestMatchers("/").hasRole("TRACKER")
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/tracker").hasRole("TRACKER")
                                .requestMatchers("/hr").hasRole("HR")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().authenticated())

                .formLogin(Customizer.withDefaults())
                .exceptionHandling(cfg->
                        cfg.accessDeniedPage("/access-denied"));
       return http.build();
    }
}
