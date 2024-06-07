package ir.najaftech.najafer.Reservation;

import java.time.LocalDate;

public class ReservationDTO {
    private String description;
    private LocalDate date;
    private int age;
    private Sex sex;
    private String userFullName;
    private String userEmail;

    
    public ReservationDTO(String description, LocalDate date, int age, Sex sex, String userFullName, String userEmail) {
        this.description = description;
        this.date = date;
        this.age = age;
        this.sex = sex;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
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
    public String getUserFullName() {
        return userFullName;
    }
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "ReservationDTO [description=" + description + ", date=" + date + ", age=" + age + ", sex=" + sex
                + ", userFullName=" + userFullName + ", userEmail=" + userEmail + "]";
    }
 
}
