package uz.attendance.attendanceapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Workdayattendance;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkdayattendanceRepository extends JpaRepository<Workdayattendance,Integer> {
    Workdayattendance findByArrivalTime(LocalDateTime arrivalTime);
    Workdayattendance findById(int id);
    Workdayattendance findByDepartTime(LocalDateTime departTime);
    List<Workdayattendance> findByEmployeeId(int id);

}
