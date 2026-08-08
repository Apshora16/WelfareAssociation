package com.example.welfareassociation.HRManager;

import java.io.Serializable;
import java.time.LocalDate;

public class HrReport implements Serializable {

    private String reportType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String department;
    private String reportPreview;

    public HrReport() {
    }

    public HrReport(String reportType, LocalDate fromDate,
                    LocalDate toDate, String department,
                    String reportPreview) {
        this.reportType = reportType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.department = department;
        this.reportPreview = reportPreview;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReportPreview() {
        return reportPreview;
    }

    public void setReportPreview(String reportPreview) {
        this.reportPreview = reportPreview;
    }

    @Override
    public String toString() {
        return reportType + " - " + department;
    }
}