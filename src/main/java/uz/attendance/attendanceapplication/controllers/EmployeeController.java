package uz.attendance.attendanceapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.service.dao.interfaces.EmployeeDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins =" https://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeDAO dao;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.dao=employeeDAO;
    }
    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
        dao.saveEmployee(employee);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<List<Employee>> updateEmployee(@Valid @RequestBody Employee employee) {
        dao.editEmployee(employee);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        dao.deleteEmployee(id);
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }
}
