package ir.najaftech.najafer.UserAuthentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationResponse {
    private String token;
    private String username;

}
