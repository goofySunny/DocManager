package ir.najaftech.najafer.Doctor;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ir.najaftech.najafer.Reservation.Reservation;
import ir.najaftech.najafer.User.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Doctor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String emailAddress;
    private String password;
    private String fullName;
    private String profession;
    private String officeAddress;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer nezamvazife;

    @JsonManagedReference("doctor")
    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservation;

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
