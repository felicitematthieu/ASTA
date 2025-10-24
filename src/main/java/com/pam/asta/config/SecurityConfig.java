package com.pam.asta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**").permitAll()  // accès libre à la page de login et aux ressources statiques
                        .anyRequest().authenticated() // le reste nécessite une connexion
                )
                .formLogin(form -> form
                        .loginPage("/login")            // page de login personnalisée
                        .loginProcessingUrl("/login")   // URL du formulaire
                        .defaultSuccessUrl("/home", true) // redirection après succès
                        .failureUrl("/login?error=true") // redirection après échec
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("matthieu")
                .password("{noop}1234") // {noop} => mot de passe non encodé (pour test)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}