package uz.attendance.attendanceapplication.service.dao.interfaces;

import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Workdayattendance;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkdayattendanceDAO {
    List<Workdayattendance> getAll();
    List<Workdayattendance> getAllInEmployee(Employee employee);
    Workdayattendance getById(int id);
    Workdayattendance getByArrivalTime(LocalDateTime arrivaltime);
    Workdayattendance getByDepartTime(LocalDateTime departtime);
    void generateWorkdayattendance(Workdayattendance workdayattendance);
//    void editWorkdayattendance(Workdayattendance workdayattendance);
//    void deleteWeekandattendance(int id);
}
