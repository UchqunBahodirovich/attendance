package uz.attendance.attendanceapplication.service.dao.interfaces;

import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;

import java.time.LocalDateTime;
import java.util.List;

public interface WeekendattendanceDAO {
   List<Weekendattendance> getAll();
   List<Weekendattendance> getAllInEmployee(Employee employee);
   Weekendattendance getById(int id);
   Weekendattendance getByArrivalTime(LocalDateTime arrivaltime);
   void generateWeekendattendance(Weekendattendance weekendattendance);
//   void editWeekendattendance(Weekendattendance weekendattendance);
//   void deleteWeekendattendance(int id);


}
