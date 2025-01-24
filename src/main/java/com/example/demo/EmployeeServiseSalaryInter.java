package com.example.demo;

import java.util.List;
import java.util.Map;

public interface EmployeeServiseSalaryInter {
    Employee findMaxSalaryEmployeeByDepartment(int department);

    Employee findMinSalaryEmployeeByDepartment(int department);

    List<Employee> allEmployeesByDepartment(int department);


    Map<Integer, List<Employee>> allEmployeesDepartments();
}
