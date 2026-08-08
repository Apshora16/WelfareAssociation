package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDatabase {
    private static final ObservableList<Employee> employeeList =
            FXCollections.observableArrayList();

    // Add a new employee
    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Return all employees
    public static ObservableList<Employee> getEmployeeList() {
        return employeeList;
    }

    // Find employee by ID
    public static Employee findEmployeeByID(String employeeID) {

        for (Employee employee : employeeList) {

            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }

        return null;
    }

    // Remove an employee
    public static boolean removeEmployee(String employeeID) {

        Employee employee = findEmployeeByID(employeeID);

        if (employee != null) {
            employeeList.remove(employee);
            return true;
        }

        return false;
    }


    public static void updateEmployee(Employee employee,
                                      String name,
                                      String department,
                                      String phone,
                                      String email,
                                      String status) {

        employee.setEmployeeName(name);
        employee.setDepartment(department);
        employee.setPhoneNumber(phone);
        employee.setEmail(email);
        employee.setEmploymentStatus(status);
    }


    public static ObservableList<Employee> searchEmployee(String keyword) {

        ObservableList<Employee> result =
                FXCollections.observableArrayList();

        for (Employee employee : employeeList) {

            if (employee.getEmployeeID().toLowerCase().contains(keyword.toLowerCase())
                    || employee.getEmployeeName().toLowerCase().contains(keyword.toLowerCase())) {

                result.add(employee);
            }
        }

        return result;
    }


}
