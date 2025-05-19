package com.example.demo;

import java.util.Objects;

public class Employee {

    public static int countId = 1;
    private int id;
    private final String lastName;
    private final String firstName;
    private int salary;
    private final int department;


    public Employee(String lastName, String firstName, int salary, int department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }


    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFullName() {

        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +

                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
