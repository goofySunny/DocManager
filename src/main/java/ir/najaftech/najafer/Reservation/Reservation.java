package ir.najaftech.najafer.Reservation;

import java.time.LocalDate;

import ir.najaftech.najafer.Doctor.Doctor;
import ir.najaftech.najafer.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    public Reservation() {
    }

    public Reservation(String id, String description, LocalDate date, Doctor doctor, User user) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.doctor = doctor;
        this.user = user;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", description=" + description + ", date=" + date + ", doctor=" + doctor
                + ", user=" + user + "]";
    }
}
