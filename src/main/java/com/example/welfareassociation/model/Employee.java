package com.example.welfareassociation.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

    private String employeeID,employeeName,
            department,phoneNumber,
            email,employmentStatus,role;

    public Employee(){

    }

    public Employee(String employeeID, String employeeName,
                    String department, String phoneNumber,
                    String email, String employmentStatus, String role) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employmentStatus = employmentStatus;
        this.role=role;
    }




    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }
    public String getRole(){
        return role;
    }





    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    public void setRole(String role){
        this.role=role;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ",role='" + role + '\'' +
                '}';
    }
}
