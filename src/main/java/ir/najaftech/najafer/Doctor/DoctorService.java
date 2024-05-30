package ir.najaftech.najafer.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(String id) {
        return doctorRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));
    }
}
