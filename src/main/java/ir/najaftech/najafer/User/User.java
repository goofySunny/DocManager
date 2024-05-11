package ir.najaftech.najafer.User;


import java.time.LocalDate;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String name;
    private String lastName;
    private String emailAddress;
    private LocalDate dob;
    private String password;

    public User(String id, String username, String name, String lastName, String emailAddress, LocalDate dob, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.password = password;
    }


    public User(String username, String name, String lastName, String emailAddress, LocalDate dob, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dob = dob;
        this.password = password;
    }

    private User(Builder builder) {
        this.username = builder.username;
        this.emailAddress = builder.emailAddress;
        this.dob = builder.dob;
        this.password = builder.password;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
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


    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String name;
        private String lastName;
        private String emailAddress;
        private LocalDate dob;
        private String password;

        private Builder() {}

        public Builder username(String username) {
            this.username = username;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
