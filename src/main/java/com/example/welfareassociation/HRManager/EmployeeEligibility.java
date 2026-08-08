package com.example.welfareassociation.HRManager;

import java.io.Serializable;

public class EmployeeEigibility implements Serializable {

    private String employeeID;
    private String employeeName;
    private String employeeStatus;
    private String attendance;
    private String serviceDuration;
    private String salary;
    private String documents;
    private String eligibility;

    public EmployeeEigibility() {
    }

    public EmployeeEigibility(String employeeID,
                              String employeeName,
                              String employeeStatus,
                              String attendance,
                              String serviceDuration,
                              String salary,
                              String documents,
                              String eligibility) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
        this.attendance = attendance;
        this.serviceDuration = serviceDuration;
        this.salary = salary;
        this.documents = documents;
        this.eligibility = eligibility;
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

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(String serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    @Override
    public String toString() {
        return employeeID + " - " + employeeName;
    }
}