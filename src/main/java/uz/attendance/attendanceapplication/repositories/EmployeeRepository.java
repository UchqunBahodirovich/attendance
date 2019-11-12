package uz.attendance.attendanceapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.attendance.attendanceapplication.models.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Override
    List<Employee> findAll();
    Employee findById(int id);
    Employee findByIdentification(String identification);


}
