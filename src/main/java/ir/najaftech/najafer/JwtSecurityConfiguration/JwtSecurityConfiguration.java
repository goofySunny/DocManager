package ir.najaftech.najafer.JwtSecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import ir.najaftech.najafer.User.UserRepository;


@Configuration
@EnableWebSecurity
public class JwtSecurityConfiguration {

    private UserRepository userRepository;

    @Autowired
    public JwtSecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth -> {
                auth.anyRequest().authenticated();   
            });
        http.sessionManagement(
            session -> {
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            });
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(header -> header.frameOptions(Customizer.withDefaults()));
        return http.build();
    }

    @Bean UserDetailsService userDetailsService() {
        return userEmail -> userRepository.findByEmail(userEmail).orElseThrow(() -> new UsernameNotFoundException("User by the specified email was not found"));
    }
}
