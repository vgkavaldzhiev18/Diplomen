package com.app.pizzashop.configuration;


import com.app.pizzashop.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.headers().frameOptions().disable();

        security.authorizeRequests((request) ->
                request.requestMatchers( "/login", "/admin-login")
                        .anonymous()
                        .requestMatchers("/order/**" ).authenticated()
                        .requestMatchers(  "/admin/confirmUsers/**").hasAuthority("ADMIN")
        );
        security.oauth2Login().loginPage("/login")
                .successHandler(successHandler)
                .and().formLogin().loginPage("/admin-login")
                .failureUrl("/admin-login").defaultSuccessUrl("/admin/confirmUsers");
        security.userDetailsService((UserDetailsService) userService);
        security.logout().logoutSuccessUrl("/");

        return security.build();
    }

}
