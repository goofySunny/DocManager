package ir.najaftech.najafer.UserAuthentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ir.najaftech.najafer.JwtSecurityConfiguration.JwtService;
import ir.najaftech.najafer.User.User;
import ir.najaftech.najafer.User.UserRepository;

@Service
public class UserAuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;

    public UserAuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public UserAuthenticationResponse authenticate(UserAuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUserEmail() ,request.getUserPassword())
        );
        User user = userRepository.findByEmailAddress(request.getUserEmail()).orElseThrow(() -> 
        new UsernameNotFoundException("User with Email "+request.getUserEmail() + " was not found"));
        var jwtToken = jwtService.generateToken(user);
        return new UserAuthenticationResponse(jwtToken, user.getUsername());
    }

}
