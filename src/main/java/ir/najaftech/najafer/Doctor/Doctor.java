package ir.najaftech.najafer.Doctor;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
    private String name;
    private String lastName;
    private String fullName;
    private String profession;
    private String officeAddress;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer nezamvazife;

    public Doctor(String id, Integer nezamvazife, String name, String lastName, String profession, String emailAddress ,String officeAddress) {
        this.id = id;
        this.nezamvazife = nezamvazife;
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.officeAddress = officeAddress;
        this.emailAddress = emailAddress;
        this.fullName = name + lastName;
    }

    public Doctor(Integer nezamvazife, String name, String lastName, String profession, String officeAddress, String emailAddress) {
        this.nezamvazife = nezamvazife;
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.officeAddress = officeAddress;
        this.emailAddress = emailAddress;
        this.fullName = name + lastName;
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
        return this.name;
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

}
