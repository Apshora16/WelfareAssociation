package com.example.welfareassociation.HRManager;

public class WelfareVerification {

    private String applicantID;
    private String applicantName;
    private String employeeStatus;
    private String attendance;
    private String serviceHistory;
    private String documents;
    private String verificationStatus;
    private String remarks;

    // Default constructor
    public WelfareVerification() {
    }

    // Parameterized constructor
    public WelfareVerification(String applicantID, String applicantName,
                               String employeeStatus, String attendance,
                               String serviceHistory, String documents,
                               String verificationStatus, String remarks) {

        this.applicantID = applicantID;
        this.applicantName = applicantName;
        this.employeeStatus = employeeStatus;
        this.attendance = attendance;
        this.serviceHistory = serviceHistory;
        this.documents = documents;
        this.verificationStatus = verificationStatus;
        this.remarks = remarks;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public String getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(String serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "WelfareVerification{" +
                "applicantID='" + applicantID + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", attendance='" + attendance + '\'' +
                ", serviceHistory='" + serviceHistory + '\'' +
                ", documents='" + documents + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}