package ir.najaftech.najafer.UserAuthentication;


public class UserAuthenticationResponse {
    private String token;

    public UserAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
