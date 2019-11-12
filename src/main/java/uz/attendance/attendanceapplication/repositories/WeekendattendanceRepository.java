package uz.attendance.attendanceapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;

import java.time.LocalDateTime;
import java.util.List;

public interface WeekendattendanceRepository extends JpaRepository<Weekendattendance, Integer> {
    Weekendattendance findByArrivalTime(LocalDateTime arrivalTime);
    Weekendattendance findById(int id);
    Weekendattendance  findByDepartTime(LocalDateTime departTime);
    List<Weekendattendance > findByEmployeeId(int id);

}
