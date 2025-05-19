package com.example.demo.emploeeAdd;

import com.example.demo.Employee;
import com.example.demo.erorr.EmployeeAlreadyAddedException;
import com.example.demo.erorr.EmployeeNotFoundException;
import com.example.demo.erorr.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInter {
    Map<String, Employee> employeeMap = new HashMap<>();

    private static final int MAX_EMPLOYEES = 10;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Employee storage is full.");
        }

        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already exists.");
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String lastname) {
        Employee employee = findEmployee(name, lastname);
        employeeMap.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = new Employee(name, lastName, 20000, 3);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("dsd");

    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;


    }
}
