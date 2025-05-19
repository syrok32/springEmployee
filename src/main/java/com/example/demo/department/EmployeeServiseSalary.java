package com.example.demo.department;

import com.example.demo.Employee;
import com.example.demo.EmployeeServiseSalaryInter;
import com.example.demo.emploeeAdd.EmployeeService;
import com.example.demo.erorr.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiseSalary implements EmployeeServiseSalaryInter {

    private final EmployeeService employeeService;

    public  EmployeeServiseSalary(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new  EmployeeNotFoundException("No" + department));
    }
    @Override
    public Employee findMinSalaryEmployeeByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("NO" + department));
        }
    @Override
    public List<Employee> allEmployeesByDepartment(int department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.getEmployeeMap().values().stream()
                .collect(groupingBy(Employee::getDepartment));
    }

}
