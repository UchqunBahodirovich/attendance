package uz.attendance.attendanceapplication.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.repositories.EmployeeRepository;
import uz.attendance.attendanceapplication.service.dao.interfaces.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeDAOImpl(EmployeeRepository employeeRepository){
        this.repository =employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Employee getByIdentification(String idenfication) {
        return repository.findByIdentification(idenfication);
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        Employee temp =repository.findById(employee.getId());
        temp.setFirstName(employee.getFirstName());
        temp.setLastName(employee.getLastName());
        temp.setIdentification(employee.getIdentification());
        temp.setPosition(employee.getPosition());
        repository.save(temp);

    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
