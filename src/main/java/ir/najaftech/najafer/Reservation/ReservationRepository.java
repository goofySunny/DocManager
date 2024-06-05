package ir.najaftech.najafer.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.najaftech.najafer.Doctor.Doctor;
import ir.najaftech.najafer.User.User;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    
    List<Reservation> findAllByUser(User user);
    List<Reservation> findAllByDoctor(Doctor doctor);

}
