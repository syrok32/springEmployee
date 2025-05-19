package com.example.demo.department;

import com.example.demo.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartment(int departmentId);

    int getSalarySumByDepartment(int departmentId);

    int getMaxSalaryByDepartment(int departmentId);

    int getMinSalaryByDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();

    List<Employee> allEmployeesByDepartment(int departmentId);
}
