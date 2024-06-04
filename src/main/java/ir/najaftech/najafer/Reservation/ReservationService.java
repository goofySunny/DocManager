package ir.najaftech.najafer.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.najaftech.najafer.Doctor.DoctorRepository;
import ir.najaftech.najafer.User.UserRepository;

@Service
public class ReservationService {

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(DoctorRepository doctorRepository, UserRepository userRepository,
            ReservationRepository reservationRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }
    
}
