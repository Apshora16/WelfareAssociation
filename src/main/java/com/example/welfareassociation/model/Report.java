package com.example.welfareassociation.model;

import java.io.Serializable;

public class Report implements Serializable {

    private static final long serialVersionUID=1L;

    private String reportType, reportContent, generateData;


    public Report() {
    }


    public Report(String reportType, String reportContent, String generateData) {
        this.reportType = reportType;
        this.reportContent = reportContent;
        this.generateData = generateData;
    }


    public String getReportType() {
        return reportType;
    }

    public String getReportContent() {
        return reportContent;
    }

    public String getGenerateData() {
        return generateData;
    }


    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public void setGenerateData(String generateData) {
        this.generateData = generateData;
    }


    @Override
    public String toString() {
        return "Report{" +
                "reportType='" + reportType + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", generateData='" + generateData + '\'' +
                '}';
    }
}
