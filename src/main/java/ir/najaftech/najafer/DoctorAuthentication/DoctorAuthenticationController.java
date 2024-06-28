package ir.najaftech.najafer.DoctorAuthentication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;
    }
}
