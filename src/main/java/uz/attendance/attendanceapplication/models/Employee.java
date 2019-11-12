package uz.attendance.attendanceapplication.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Nullable
    @Column(name = "first_name")
    private String firstName;

    @Nullable
    @Column(name = "last_name")
    private String lastName;

    @Column(name="position")
    private String position;

    @Column(name = "identification")
    private String identification;

    @OneToMany(
            targetEntity = Workdayattendance.class,
            mappedBy = "employee",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference(value = "wo-e")
    private Set<Workdayattendance> workdayAttendances;


    @OneToMany(
            targetEntity = Weekendattendance.class,
            mappedBy = "employee",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference(value="we-e")
    private Set<Weekendattendance> weekendAttendances;
}
