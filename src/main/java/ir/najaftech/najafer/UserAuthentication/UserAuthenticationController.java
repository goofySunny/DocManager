package ir.najaftech.najafer.UserAuthentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users/auth")
public class UserAuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    public UserAuthenticationController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest credentials) {
        if (credentials.getUserEmail().isEmpty() || credentials.getUserPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userAuthenticationService.authenticate(credentials));
        }
    }

    @PostMapping("register")
    public ResponseEntity<UserAuthenticationResponse> register(@RequestBody UserAuthenticationRequest.RegisterationRequest credentials) {
        return ResponseEntity.ok().body(userAuthenticationService.register(credentials));
    }
}
