package ir.najaftech.najafer.Reservation;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private String description;
    private LocalDate date;
    private int age;
    private Sex sex;
    private String userFullName;
    private String userEmail;
 
}
