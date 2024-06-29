package ir.najaftech.najafer.DoctorAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ir.najaftech.najafer.Doctor.Doctor;
import ir.najaftech.najafer.Doctor.DoctorRepository;
import ir.najaftech.najafer.JwtSecurityConfiguration.JwtService;

@Service
public class DoctorAuthenticationService {

    private DoctorRepository doctorRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DoctorAuthenticationService(DoctorRepository doctorRepository, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public DoctorAuthenticationResponse login(DoctorAuthenticationRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmailAddress(), loginRequest.getPassword()
                )
            );

        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
        Doctor doc = doctorRepository.findByEmailAddress(loginRequest.getEmailAddress()).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        String jwt = jwtService.generateToken(doc);
        return new DoctorAuthenticationResponse(jwt, doc.getFullName());
    }

    public DoctorAuthenticationResponse register(DoctorAuthenticationRequest.DoctorRegisterRequest request) {
        Doctor doctor = Doctor.builder()
            .emailAddress(request.getEmailAddress())
            .fullName(request.getFullName())
            .nezamvazife(request.getNezamvazife())
            .password(passwordEncoder.encode(request.getPassword()))
            .profession(request.getProfession())
            .build();
        doctorRepository.save(doctor);
        return login(new DoctorAuthenticationRequest(doctor.getEmailAddress(), doctor.getPassword()));
    }
}
