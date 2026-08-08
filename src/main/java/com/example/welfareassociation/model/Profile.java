package com.example.welfareassociation.model;

import java.io.Serializable;

public class Profile implements Serializable {

    private static final long serialVersionUID=1L;

    private String employeeId;
    private String fullName;
    private String department;
    private String phone;
    private String email;

    public Profile(String employeeId, String fullName, String department, String phone, String email) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        this.phone = phone;
        this.email = email;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
