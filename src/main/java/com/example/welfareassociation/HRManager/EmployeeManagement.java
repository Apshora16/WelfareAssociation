package com.example.welfareassociation.HRManager;

import java.io.Serializable;

public class EmployeeManagement implements Serializable {

    private String employeeID;
    private String employeeName;
    private String phoneNumber;
    private String employeeAddress;
    private String department;
    private String address;

    public EmployeeManagement() {
    }

    public EmployeeManagement(String employeeID,
                              String employeeName,
                              String phoneNumber,
                              String employeeAddress,
                              String department,
                              String address) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.employeeAddress = employeeAddress;
        this.department = department;
        this.address = address;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return employeeID + " - " + employeeName;
    }
}