package uz.attendance.attendanceapplication.wrappers;

import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;

import java.util.List;

public class Weekendwrapper {

    private List<Employee> employees;
    private List<Weekendattendance> weekendattendances;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public  List<Weekendattendance> getWeekendattendances(){return weekendattendances;}

    public void setWeekendattendances(List<Weekendattendance> weekendattendances){this.weekendattendances=weekendattendances;}



}
