package ir.najaftech.najafer.Doctor;

import java.util.List;

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

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Doctor updateDoctor, String id) {
        Doctor oldDoctor = doctorRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Doctor not found"));
        Doctor newDoctor = doctorMerger(oldDoctor, updateDoctor);
        doctorRepository.save(newDoctor);
        return newDoctor;
    }

    public Doctor doctorMerger(Doctor doctor, Doctor updateDoctor) {
        doctor.setEmailAddress(updateDoctor.getEmailAddress() == null ? doctor.getEmailAddress() : updateDoctor.getEmailAddress());
        doctor.setFullName(updateDoctor.getFullName() == null ? doctor.getFullName() : updateDoctor.getFullName());
        doctor.setNezamvazife(doctor.getNezamvazife());
        doctor.setOfficeAddress(updateDoctor.getOfficeAddress() == null ? doctor.getOfficeAddress() : updateDoctor.getOfficeAddress());
        doctor.setProfession(updateDoctor.getProfession() == null ? doctor.getProfession() : updateDoctor.getProfession());
        return doctor;
    }
}
