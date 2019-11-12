package uz.attendance.attendanceapplication.service.dao.interfaces;

import uz.attendance.attendanceapplication.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();
    Employee getById(int id);
    Employee getByIdentification(String idenfication);
    void saveEmployee(Employee employee);
    void editEmployee(Employee employee);
    void deleteEmployee(int id);
}
