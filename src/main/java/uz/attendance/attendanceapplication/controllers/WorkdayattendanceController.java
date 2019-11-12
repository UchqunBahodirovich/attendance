package uz.attendance.attendanceapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Workdayattendance;
import uz.attendance.attendanceapplication.service.dao.interfaces.EmployeeDAO;
import uz.attendance.attendanceapplication.service.dao.interfaces.WorkdayattendanceDAO;
import uz.attendance.attendanceapplication.wrappers.Workdaywrapper;

import javax.validation.Valid;
import java.util.List;

public class WorkdayattendanceController {
    private WorkdayattendanceDAO dao;
    private EmployeeDAO employeeDAO;

    Workdaywrapper wrapper=new Workdaywrapper();

    @Autowired
    public WorkdayattendanceController(WorkdayattendanceDAO workdayattendanceDAO, EmployeeDAO employeeDAO) {
        this.dao = workdayattendanceDAO;
        this.employeeDAO=employeeDAO;
    }
    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Workdayattendance>> getAllWorkdayattendance() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Workdayattendance> getWorkdayattendance(@PathVariable int id) {
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Workdayattendance>> saveWorkdayattendance(@Valid @RequestBody Workdayattendance workdayattendance) {
        dao.generateWorkdayattendance(workdayattendance);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    private Workdaywrapper collectWrapper(){
        List<Employee> employees=employeeDAO.getAll() ;

        wrapper.setWorkdayattendances(dao.getAll());
        wrapper.setEmployees(employees);

        return wrapper;
    }

}
