package ir.najaftech.najafer.DoctorAuthentication;

public class DoctorAuthenticationResponse {
    private String token;
    private String fullName;
    
    public DoctorAuthenticationResponse(String token, String fullName) {
        this.token = token;
        this.fullName = fullName;
    }
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
