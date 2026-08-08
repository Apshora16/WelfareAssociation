package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AttendanceDatabase {

    private static final ObservableList<Attendance> attendanceList =
            FXCollections.observableArrayList();

    public static ObservableList<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public static void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }
}
