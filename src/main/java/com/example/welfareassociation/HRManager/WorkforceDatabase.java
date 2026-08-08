package com.example.welfareassociation.HRManager;

public class WorkforceDatabase {

    private String searchEmployeeID;
    private String department;
    private String employeeName;
    private String designation;
    private String employeeStatus;
    private String employeeInformation;

    public WorkforceDatabase() {
    }

    public WorkforceDatabase(String searchEmployeeID,
                             String department,
                             String employeeName,
                             String designation,
                             String employeeStatus,
                             String employeeInformation) {

        this.searchEmployeeID = searchEmployeeID;
        this.department = department;
        this.employeeName = employeeName;
        this.designation = designation;
        this.employeeStatus = employeeStatus;
        this.employeeInformation = employeeInformation;
    }

    public String getSearchEmployeeID() {
        return searchEmployeeID;
    }

    public void setSearchEmployeeID(String searchEmployeeID) {
        this.searchEmployeeID = searchEmployeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(String employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    @Override
    public String toString() {
        return "WorkforceDatabase{" +
                "searchEmployeeID='" + searchEmployeeID + '\'' +
                ", department='" + department + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", designation='" + designation + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", employeeInformation='" + employeeInformation + '\'' +
                '}';
    }
}