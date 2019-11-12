package uz.attendance.attendanceapplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="weekendattendances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weekendattendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Nullable
    @Column(name = "departure_time")
    private LocalDateTime departTime;

    @Nullable
    @Column(name = "worked_time")
    private int workedTime;

    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "employee_id", referencedColumnName = "id")
    @JsonBackReference(value = "we-e")
    private Employee employee;
}
