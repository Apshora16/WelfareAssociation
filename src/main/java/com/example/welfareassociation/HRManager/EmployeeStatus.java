package com.example.welfareassociation.HRManager;

import java.io.Serializable;

public class EmployeeStatus implements Serializable {

    private String employeeID;
    private String employeeName;
    private String currentStatus;
    private String transferHistory;
    private String promotionHistory;
    private String leaveRecords;

    public EmployeeStatus() {
    }

    public EmployeeStatus(String employeeID, String employeeName,
                          String currentStatus, String transferHistory,
                          String promotionHistory, String leaveRecords) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.currentStatus = currentStatus;
        this.transferHistory = transferHistory;
        this.promotionHistory = promotionHistory;
        this.leaveRecords = leaveRecords;
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

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getTransferHistory() {
        return transferHistory;
    }

    public void setTransferHistory(String transferHistory) {
        this.transferHistory = transferHistory;
    }

    public String getPromotionHistory() {
        return promotionHistory;
    }

    public void setPromotionHistory(String promotionHistory) {
        this.promotionHistory = promotionHistory;
    }

    public String getLeaveRecords() {
        return leaveRecords;
    }

    public void setLeaveRecords(String leaveRecords) {
        this.leaveRecords = leaveRecords;
    }

    @Override
    public String toString() {
        return employeeID + " - " + employeeName;
    }
}