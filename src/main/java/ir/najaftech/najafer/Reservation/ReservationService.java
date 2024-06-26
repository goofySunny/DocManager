package ir.najaftech.najafer.Reservation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ir.najaftech.najafer.Doctor.Doctor;
import ir.najaftech.najafer.Doctor.DoctorRepository;
import ir.najaftech.najafer.User.User;
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
    
    public Reservation addReservation(String doctorId, String userId, Reservation reservation) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        reservation.setDoctor(doctor);
        reservation.setUser(user);
        reservationRepository.save(reservation);
        return reservation; 
    }

    public Reservation getReservation(String id) {
        return reservationRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("No such reservation"));
    }

    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> retrieveAllByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return reservationRepository.findAllByUser(user);
    }

    public List<ReservationDTO> retrieveAllByDoctor(String id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));
        List<Reservation> reservations = reservationRepository.findAllByDoctor(doctor);
        List<ReservationDTO> reservationDTOs = new ArrayList<ReservationDTO>();
        for (Reservation reservation : reservations) {
            ReservationDTO iterate = new ReservationDTO(reservation.getDescription(), reservation.getDate(), reservation.getAge(), reservation.getSex(),
                    reservation.getUser().getName() + " " + reservation.getUser().getLastName(), reservation.getUser().getEmailAddress());
            reservationDTOs.add(iterate);
        }
        return reservationDTOs;
    }

}
