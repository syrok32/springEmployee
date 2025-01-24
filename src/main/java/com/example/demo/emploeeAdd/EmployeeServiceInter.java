package com.example.demo.emploeeAdd;

import com.example.demo.Employee;

public interface EmployeeServiceInter {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(String name, String lastname);

    Employee findEmployee(String name, String lastName);
}
