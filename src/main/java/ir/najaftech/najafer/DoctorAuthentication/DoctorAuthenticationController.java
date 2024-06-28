package ir.najaftech.najafer.DoctorAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/doctors/auth")
public class DoctorAuthenticationController {

    private DoctorAuthenticationService doctorAuthenticationService;

    @Autowired
    public DoctorAuthenticationController(DoctorAuthenticationService doctorAuthenticationService) {
        this.doctorAuthenticationService = doctorAuthenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody DoctorAuthenticationRequest request) {
        return ResponseEntity.ok(doctorAuthenticationService.login(request));
    }

    @PostMapping("register")
    public ResponseEntity<Object> register(@Valid @RequestBody DoctorAuthenticationRequest.DoctorRegisterRequest request) {
        return ResponseEntity.ok(doctorAuthenticationService.register(request));
    }

}
