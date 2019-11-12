package uz.attendance.attendanceapplication.wrappers;

import uz.attendance.attendanceapplication.models.Employee;
import uz.attendance.attendanceapplication.models.Weekendattendance;
import uz.attendance.attendanceapplication.models.Workdayattendance;

import java.util.List;

public class Workdaywrapper {
    private List<Employee> employees;
    private List<Workdayattendance> workdayattendances;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public  List<Workdayattendance> getWorkdayattendances(){return workdayattendances;}

    public void setWorkdayattendances(List<Workdayattendance> workdayattendances){this.workdayattendances=workdayattendances;}


}
