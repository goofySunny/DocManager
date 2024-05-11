package ir.najaftech.najafer.UserAuthentication;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/user/login")
public class UserAuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    public UserAuthenticationController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest credentials) {
        if (credentials.getUserEmail().isEmpty() || credentials.getUserPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userAuthenticationService.authenticate(credentials));
    }
}
