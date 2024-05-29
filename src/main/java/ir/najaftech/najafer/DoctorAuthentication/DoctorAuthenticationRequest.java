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
        private String name;
        private String lastName;
        private String emailAddress;
        private String password;
        private String profession;
        private int nezamvazife;

        
        public DoctorRegisterRequest(String name, String lastName, String emailAddress, String password,
                String profession, int nezamvazife) {
            this.name = name;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.password = password;
            this.profession = profession;
            this.nezamvazife = nezamvazife;
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
