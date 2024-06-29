package ir.najaftech.najafer.UserAuthentication;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthenticationRequest {
    private String userEmail;
    private String userPassword;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
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
    }
}