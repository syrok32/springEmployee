package com.example.demo.department;

import com.example.demo.Employee;
import com.example.demo.emploeeAdd.EmployeeService;
import com.example.demo.erorr.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        List<Employee> employees = employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found in department " + departmentId);
        }
        return employees;
    }

    @Override
    public int getSalarySumByDepartment(int departmentId) {
        List<Employee> employees = getEmployeesByDepartment(departmentId);
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public int getMaxSalaryByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(() -> new EmployeeNotFoundException("No employees found in department " + departmentId));
    }

    @Override
    public int getMinSalaryByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(() -> new EmployeeNotFoundException("No employees found in department " + departmentId));
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getEmployeeMap().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int departmentId) {
        return List.of();
    }
}