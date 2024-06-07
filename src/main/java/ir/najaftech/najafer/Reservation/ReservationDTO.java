package ir.najaftech.najafer.Reservation;

import java.time.LocalDate;

import ir.najaftech.najafer.User.User;

public class ReservationDTO {
    private String description;
    private LocalDate date;
    private int age;
    private Sex sex;
    private User user;
    
    public ReservationDTO(String description, LocalDate date, int age, Sex sex, User user) {
        this.description = description;
        this.date = date;
        this.age = age;
        this.sex = sex;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ReservationDTO [description=" + description + ", date=" + date + ", age=" + age + ", sex=" + sex
                + ", user=" + user + "]";
    }

}
