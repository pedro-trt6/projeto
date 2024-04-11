package br.cnj.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("pedro").roles("USER").password("{noop}123")
        .and()
        .withUser("admin").roles("ADMIN").password("{noop}123");
    }

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {        
        return http.authorizeHttpRequests(
                request -> request.requestMatchers(new AntPathRequestMatcher("/api/casos/**"))
                .hasRole("USER")
            )
            .authorizeHttpRequests(
                    request -> request.requestMatchers(new AntPathRequestMatcher("/api/arquivos/**"))
                    .hasRole("ADMIN").anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()).build();
    }
}
