package ir.najaftech.najafer.Doctor;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    
    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@RequestParam String id) {
        Doctor doctor = this.doctorService.findById(id);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor,@RequestParam String id) {
        Doctor updatedDoctor = doctorService.updateDoctor(doctor, id);
        return ResponseEntity.ok(updatedDoctor);
    }
    
}
