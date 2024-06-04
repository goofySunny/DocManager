package ir.najaftech.najafer.Reservation;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import ir.najaftech.najafer.Doctor.Doctor;
import ir.najaftech.najafer.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int age;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference("doctor")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;

    
    public Reservation(String id, String description, LocalDate date, int age, Sex sex, Doctor doctor, User user) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.age = age;
        this.sex = sex;
        this.doctor = doctor;
        this.user = user;
    }

    public Reservation() {
    }

    public Reservation(String description, LocalDate date, int age, Sex sex) {
        this.description = description;
        this.date = date;
        this.age = age;
        this.sex = sex;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", description=" + description + ", date=" + date + ", doctor=" + doctor
                + ", user=" + user + "]";
    }
}
