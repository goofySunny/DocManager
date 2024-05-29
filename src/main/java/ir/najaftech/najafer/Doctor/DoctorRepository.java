package ir.najaftech.najafer.Doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    
    public Optional<Doctor> findByEmailAddress(String email);
    public Optional<Doctor> findByFullName(String fullName);

}
