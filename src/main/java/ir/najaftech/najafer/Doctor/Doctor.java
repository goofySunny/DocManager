package ir.najaftech.najafer.Doctor;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.najaftech.najafer.User.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Doctor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String emailAddress;
    private String password;
    private String fullName;
    private String profession;
    private String officeAddress;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer nezamvazife;

    public Doctor() {
    }

    public Doctor(String emailAddress, String password, String fullName, String profession, String officeAddress,
            Role role, Integer nezamvazife) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.fullName = fullName;
        this.profession = profession;
        this.officeAddress = officeAddress;
        this.role = role;
        this.nezamvazife = nezamvazife;
    }

    public Doctor(String id, String emailAddress, String password, String fullName, String profession,
            String officeAddress, Role role, Integer nezamvazife) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.fullName = fullName;
        this.profession = profession;
        this.officeAddress = officeAddress;
        this.role = role;
        this.nezamvazife = nezamvazife;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNezamvazife() {
        return nezamvazife;
    }

    public void setNezamvazife(Integer nezamvazife) {
        this.nezamvazife = nezamvazife;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.fullName;
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

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", emailAddress=" + emailAddress + ", password=" + password + ", fullName="
                + fullName + ", profession=" + profession + ", officeAddress=" + officeAddress + ", role=" + role
                + ", nezamvazife=" + nezamvazife + "]";
    }

}
