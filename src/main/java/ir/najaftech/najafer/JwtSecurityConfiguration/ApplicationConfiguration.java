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

import ir.najaftech.najafer.Doctor.DoctorRepository;
import ir.najaftech.najafer.User.UserRepository;

@Configuration
public class ApplicationConfiguration {

    private UserRepository userRepository;
    private DoctorRepository doctorRepository;

    @Autowired
    public ApplicationConfiguration(UserRepository userRepository, DoctorRepository doctorRepository) {
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
    }

    @Bean
    @Qualifier("doctorEmailDetailsService")
    public UserDetailsService doctorEmailDetailsService() {
        return doctorEmail -> doctorRepository.findByEmailAddress(doctorEmail)
            .orElseThrow(() -> new UsernameNotFoundException("Doctor by the specified email was not found"));
    }

    @Bean
    @Qualifier("doctorFullNameDetailsService")
    public UserDetailsService doctorFullNameDetailsService() {
        return doctorFullName -> doctorRepository.findByFullName(doctorFullName)
            .orElseThrow(() -> new UsernameNotFoundException("Doctor by the specified Fullname not found"));
    }

    @Bean
    @Qualifier("userEmailDetailsService") 
    public UserDetailsService userEmailDetailsService() {
        return userEmail -> userRepository.findByEmailAddress(userEmail)
            .orElseThrow(() -> new UsernameNotFoundException("User by the specified Email was not found"));
    }

    @Bean
    @Qualifier("usernameDetailsService")
    @Primary 
    public UserDetailsService usernameDetailsService() {
        return username -> userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User by the specified Username was not found"));
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
    @Qualifier("doctorEmailAddressAuthProvider")
    public AuthenticationProvider doctorEmailAddressAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(doctorEmailDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    @Qualifier("doctorFullNameAuthProvider")
    public AuthenticationProvider doctorFullNameAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(doctorFullNameDetailsService());
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
        return new ProviderManager(List.of(usernameAuthProvider(), userEmailAuthProvider(), doctorEmailAddressAuthProvider(), doctorFullNameAuthProvider()));
    }
    
}
