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
@Table(name="workday_attendances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workdayattendance {

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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(columnDefinition = "integer", name = "employee_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference(value = "wo-e")
    private Employee employee;
}
