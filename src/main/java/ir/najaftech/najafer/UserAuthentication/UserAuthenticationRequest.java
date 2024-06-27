package ir.najaftech.najafer.UserAuthentication;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class UserAuthenticationRequest {
    private String userEmail;
    private String userPassword;

    public UserAuthenticationRequest(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public static class RegisterationRequest {
        @Email
        @NotNull(message = "This field is required")
        @NotEmpty(message = "This field is required")
        private String userEmail;
        @NotEmpty(message = "This field is required")
        @NotNull(message = "This field is required")
        private String username;
        @Size(min = 8, max = 24, message = "Password must be between 8 and 24 characters")
        @NotEmpty(message = "This field is required")
        @NotNull(message = "This field is required")
        private String userPassword;
        @Past(message = "Bro?")
        private LocalDate dob;
        @NotEmpty(message = "This field is required")
        @NotNull(message = "This field is required")
        private String name;
        @NotEmpty(message = "This field is required")
        @NotNull(message = "This field is required")
        private String lastName;

        

        public RegisterationRequest(String userEmail, String userPassword, LocalDate dob, String name,
                String lastName, String username) {
            this.userEmail = userEmail;
            this.userPassword = userPassword;
            this.dob = dob;
            this.name = name;
            this.lastName = lastName;
            this.username = username;
        }

        public String getUserEmail() {
            return userEmail;
        }
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
        public String getUserPassword() {
            return userPassword;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
        public LocalDate getDob() {
            return dob;
        }
        public void setDob(LocalDate dob) {
            this.dob = dob;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        
    }
}
