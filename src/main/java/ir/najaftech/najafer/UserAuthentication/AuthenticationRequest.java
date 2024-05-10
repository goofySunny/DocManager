package ir.najaftech.najafer.UserAuthentication;

import java.time.LocalDate;

public class AuthenticationRequest {
    private String userEmail;
    private String userPassword;


    public class RegisterationRequest {
        private String userEmail;
        private String userPassword;
        private LocalDate dob;
        private String name;
        private String lastName;
    }
}
