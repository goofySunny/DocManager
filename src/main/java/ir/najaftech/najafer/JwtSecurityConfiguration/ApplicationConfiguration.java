package ir.najaftech.najafer.JwtSecurityConfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ir.najaftech.najafer.User.UserRepository;


@Configuration
public class ApplicationConfiguration {

    private UserRepository userRepository;

    @Autowired
    public ApplicationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    

    @Bean
    @Qualifier("userEmailDetailsService") 
    public UserDetailsService userEmailDetailsService() {
        return userEmail -> userRepository.findByEmailAddress(userEmail)
            .orElseThrow(() -> new UsernameNotFoundException("User by the specified email was not found"));
    }

    @Bean
    @Qualifier("usernameDetailsService")
    @Primary 
    public UserDetailsService usernameDetailsService() {
        return username -> userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User by the specified email was not found"));
    }

    @Bean
    @Qualifier("usernameAuthProvider")
    @Primary
    public AuthenticationProvider usernameAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usernameDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Bean
    @Qualifier("userEmailAuthProvider")
    public AuthenticationProvider userEmailAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userEmailDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return new ProviderManager(List.of(usernameAuthProvider(), userEmailAuthProvider()));
    }
    
}
