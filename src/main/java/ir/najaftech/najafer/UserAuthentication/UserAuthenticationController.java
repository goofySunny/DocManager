package ir.najaftech.najafer.UserAuthentication;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/user/auth/")
public class UserAuthenticationController {

    private UserAuthenticationService userAuthenticationService;

    public UserAuthenticationController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest credentials) {
        if (credentials.getUserEmail().isEmpty() || credentials.getUserPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userAuthenticationService.authenticate(credentials));
    }

    @PostMapping("register")
    public ResponseEntity<UserAuthenticationResponse> register(@RequestBody UserAuthenticationRequest.RegisterationRequest credentials) {
        return ResponseEntity.ok(userAuthenticationService.register(credentials)); //TODO : fix the response entity to return the actual URI path and not just a plain response entity of 200
    }
}
