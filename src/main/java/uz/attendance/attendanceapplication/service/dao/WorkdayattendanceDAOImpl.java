package uz.attendance.attendanceapplication.service.dao;

import org.springframework.stereotype.Service;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Workdayattendance;
import uz.attendance.attendanceapplication.repositories.WorkdayattendanceRepository;
import uz.attendance.attendanceapplication.service.dao.interfaces.WorkdayattendanceDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkdayattendanceDAOImpl implements WorkdayattendanceDAO {

    private WorkdayattendanceRepository repository;

    public WorkdayattendanceDAOImpl(WorkdayattendanceRepository workdayattendanceRepository) {
        this.repository = workdayattendanceRepository;
    }

    @Override
    public List<Workdayattendance> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Workdayattendance> getAllInEmployee(Employee employee) {
        return repository.findByEmployeeId(employee.getId());
    }

    @Override
    public Workdayattendance getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Workdayattendance getByArrivalTime(LocalDateTime arrivaltime) {
        return repository.findByArrivalTime(arrivaltime);
    }

    @Override
    public Workdayattendance getByDepartTime(LocalDateTime departtime) {
        return repository.findByDepartTime(departtime);
    }

    @Override
    public void generateWorkdayattendance(Workdayattendance workdayattendance) {
        repository.save(workdayattendance);
    }
}
