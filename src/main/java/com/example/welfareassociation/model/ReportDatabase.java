package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ReportDatabase {

    private static final ObservableList<Report> reportList =
            FXCollections.observableArrayList();

    public static void addReport(Report report) {

        reportList.add(report);

    }

    public static ObservableList<Report> getReportList() {

        return reportList;

    }

    public static void clearReports() {

        reportList.clear();

    }


}
