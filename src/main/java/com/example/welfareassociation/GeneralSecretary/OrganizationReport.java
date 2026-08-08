package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;
import java.time.LocalDate;

public class OrganizationReport implements Serializable {

    private String reportType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reportSummary;

    public OrganizationReport() {
    }

    public OrganizationReport(String reportType,
                              LocalDate fromDate,
                              LocalDate toDate,
                              String reportSummary) {
        this.reportType = reportType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reportSummary = reportSummary;
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

    public String getReportSummary() {
        return reportSummary;
    }

    public void setReportSummary(String reportSummary) {
        this.reportSummary = reportSummary;
    }

    @Override
    public String toString() {
        return reportType + " Report (" + fromDate + " to " + toDate + ")";
    }
}