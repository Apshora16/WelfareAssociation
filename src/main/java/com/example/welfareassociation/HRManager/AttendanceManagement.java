package com.example.welfareassociation.HRManager;

import java.io.Serializable;

public class AttendanceManagement implements Serializable {

    private String employeeID;
    private String employeeName;
    private String month;
    private String attendanceRate;
    private String absences;
    private String overtime;

    public AttendanceManagement() {
    }

    public AttendanceManagement(String employeeID,
                                String employeeName,
                                String month,
                                String attendanceRate,
                                String absences,
                                String overtime) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.month = month;
        this.attendanceRate = attendanceRate;
        this.absences = absences;
        this.overtime = overtime;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public String getAbsences() {
        return absences;
    }

    public void setAbsences(String absences) {
        this.absences = absences;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return employeeID + " - " + employeeName;
    }
}