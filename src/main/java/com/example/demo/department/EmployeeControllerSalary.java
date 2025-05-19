package com.example.demo.department;

import com.example.demo.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeControllerSalary {

    private final EmployeeServiseSalary employeeServiseSalary;

    private EmployeeControllerSalary(EmployeeServiseSalary employeeServiseSalary) {
        this.employeeServiseSalary = employeeServiseSalary;

    }

    @GetMapping(path = "/departments/max-salary")
    public String findMaxSalaryEmployeeByDepartment(@RequestParam("departmentId") int department) {
        Employee employee = employeeServiseSalary.findMaxSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/min-salary")
    public String findMinSalaryEmployeeByDepartment(@RequestParam("departmentId") int department) {
        Employee employee = employeeServiseSalary.findMinSalaryEmployeeByDepartment(department);
        return employee.getLastName() + " " + employee.getFirstName() + " " + employee.getSalary();
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allEmployeesByDepartment(@RequestParam("departmentId") int department) {
        return employeeServiseSalary.allEmployeesByDepartment(department);

    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getTopEmployeesByDepartment() {
        return employeeServiseSalary.allEmployeesDepartments();
    }

}
