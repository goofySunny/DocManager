package ir.najaftech.najafer.UserAuthentication;

import java.time.LocalDate;

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
        private String userEmail;
        private String username;
        private String userPassword;
        private LocalDate dob;
        private String name;
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
