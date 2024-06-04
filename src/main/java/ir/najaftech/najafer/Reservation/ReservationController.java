package ir.najaftech.najafer.Reservation;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/{doctorId}/{userId}")
    public ResponseEntity<Reservation> createReservation(@PathVariable String doctorId, @PathVariable String userId, @RequestBody Reservation reservation) {
        Reservation reserved = reservationService.addReservation(doctorId, userId, reservation);
        return ResponseEntity.ok(reserved);
    }

    @GetMapping
    public ResponseEntity<Object> retrieveAllReservations() {
        List<Reservation> reservations = reservationService.retrieveAllReservations();
        return ResponseEntity.ok(reservations);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> retrieveReservation(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }
}
