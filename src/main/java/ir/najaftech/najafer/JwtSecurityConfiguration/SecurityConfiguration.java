package ir.najaftech.najafer.JwtSecurityConfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private List<AuthenticationProvider> authProvider;
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, List<AuthenticationProvider> authProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authProvider = authProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(
            auth -> {
                auth.requestMatchers("api/v1/users/auth/**").permitAll().anyRequest().authenticated();   
            });
        http.sessionManagement(
            session -> {
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            });
        // http.addFilter(JwtAuthenticationFilter.class);
        authProvider.forEach(http::authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers(header -> header.frameOptions(Customizer.withDefaults()));
        return http.build();
    }
}
