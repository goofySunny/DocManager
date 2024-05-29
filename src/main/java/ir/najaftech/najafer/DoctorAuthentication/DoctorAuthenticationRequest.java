package ir.najaftech.najafer.DoctorAuthentication;

public class DoctorAuthenticationRequest {
    private String emailAddress;
    private String password;
    
    public DoctorAuthenticationRequest(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public static class DoctorRegisterRequest {
        private String fullName;
        private String emailAddress;
        private String password;
        private String profession;
        private int nezamvazife;

        
        public DoctorRegisterRequest(String fullName, String emailAddress, String password,
                String profession, int nezamvazife) {
            this.fullName = fullName;
            this.emailAddress = emailAddress;
            this.password = password;
            this.profession = profession;
            this.nezamvazife = nezamvazife;
        }

        public String getFullName() {
            return fullName;
        }
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
        public String getEmailAddress() {
            return emailAddress;
        }
        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getProfession() {
            return profession;
        }
        public void setProfession(String profession) {
            this.profession = profession;
        }

        public int getNezamvazife() {
            return nezamvazife;
        }

        public void setNezamvazife(int nezamvazife) {
            this.nezamvazife = nezamvazife;
        }
    }
}
