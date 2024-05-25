package ir.najaftech.najafer.UserAuthentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ir.najaftech.najafer.JwtSecurityConfiguration.JwtService;
import ir.najaftech.najafer.User.Role;
import ir.najaftech.najafer.User.User;
import ir.najaftech.najafer.User.UserRepository;

@Service
public class UserAuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    public UserAuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthenticationResponse authenticate(UserAuthenticationRequest request) {
        User user = userRepository.findByEmailAddress(request.getUserEmail()).orElseThrow(() -> 
        new UsernameNotFoundException("User with Email "+request.getUserEmail() + " was not found"));
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUserEmail() ,request.getUserPassword())
        );

        var jwtToken = jwtService.generateToken(user);
        return new UserAuthenticationResponse(jwtToken, user.getUsername());
    }

    public UserAuthenticationResponse register(UserAuthenticationRequest.RegisterationRequest request) {
        User user = User.builder()
                        .emailAddress(request.getUserEmail())
                        .name(request.getName())
                        .lastName(request.getLastName())
                        .password(passwordEncoder.encode(request.getUserPassword()))
                        .username(request.getUsername())
                        .role(Role.USER)
                        .dob(request.getDob())
                        .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new UserAuthenticationResponse(jwtToken, user.getUsername());
    }

}
