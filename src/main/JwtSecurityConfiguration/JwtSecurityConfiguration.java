import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfiguration {

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
}
