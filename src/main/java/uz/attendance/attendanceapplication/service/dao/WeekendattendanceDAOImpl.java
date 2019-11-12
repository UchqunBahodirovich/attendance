package uz.attendance.attendanceapplication.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;
import uz.attendance.attendanceapplication.repositories.WeekendattendanceRepository;
import uz.attendance.attendanceapplication.service.dao.interfaces.WeekendattendanceDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeekendattendanceDAOImpl implements WeekendattendanceDAO{

    private  WeekendattendanceRepository repository;

    @Autowired
    public WeekendattendanceDAOImpl(WeekendattendanceRepository weekendattendanceRepository) {
        this.repository = weekendattendanceRepository;
    }

    @Override
    public List<Weekendattendance> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Weekendattendance> getAllInEmployee(Employee employee) {
        return repository.findByEmployeeId(employee.getId());
    }

    @Override
    public Weekendattendance getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Weekendattendance getByArrivalTime(LocalDateTime arrivaltime) {
        return repository.findByArrivalTime(arrivaltime);
    }

    @Override
    public void generateWeekendattendance(Weekendattendance weekendattendance) {
        repository.save(weekendattendance);
    }

}