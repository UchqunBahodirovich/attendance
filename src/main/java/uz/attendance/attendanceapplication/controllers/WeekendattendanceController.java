package uz.attendance.attendanceapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;
import uz.attendance.attendanceapplication.service.dao.interfaces.EmployeeDAO;
import uz.attendance.attendanceapplication.service.dao.interfaces.WeekendattendanceDAO;
import uz.attendance.attendanceapplication.wrappers.Weekendwrapper;

import javax.validation.Valid;
import java.util.List;

@Service
public class WeekendattendanceController {
    private WeekendattendanceDAO dao;
    private EmployeeDAO employeeDAO;

    Weekendwrapper wrapper=new Weekendwrapper();

    @Autowired
    public WeekendattendanceController(WeekendattendanceDAO weekendattendanceDAO,EmployeeDAO employeeDAO) {
        this.dao = weekendattendanceDAO;
        this.employeeDAO=employeeDAO;
    }
    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Weekendattendance>> getAllWeekendattendance() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Weekendattendance> getWeekendattendance(@PathVariable int id) {
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Weekendattendance>> saveWeekendattendance(@Valid @RequestBody Weekendattendance weekendattendance) {
        dao.generateWeekendattendance(weekendattendance);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    private Weekendwrapper collectWrapper(){
        List<Employee> employees=employeeDAO.getAll() ;

        wrapper.setWeekendattendances(dao.getAll());
        wrapper.setEmployees(employees);

        return wrapper;
    }
}
