package ir.najaftech.najafer.UserAuthentication;


public class UserAuthenticationResponse {
    private String token;
    private String username;

    public UserAuthenticationResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
