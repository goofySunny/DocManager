package ir.najaftech.najafer.DoctorAuthentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAuthenticationRequest {
    private String emailAddress;
    private String password;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DoctorRegisterRequest {
        @NotEmpty(message = "Required")
        @NotNull(message = "Required")
        private String fullName;
        @NotEmpty(message = "Required")
        @NotNull(message = "Required")
        @Email(message = "Invalid Email address")
        private String emailAddress;
        @NotEmpty
        @NotNull
        @Size(min = 8, max = 24, message = "password must be between 8 and 24 characters long")
        private String password;
        private String profession;
        @Positive
        @NotNull
        private int nezamvazife;

    }
}