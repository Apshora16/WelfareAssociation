package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AttendanceManagementController {

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private ComboBox<String> selectMonthComboBox;

    @FXML
    private TextField attendanceRateTextField;

    @FXML
    private TextField absencesTextField;

    @FXML
    private TextArea overtimeTextArea;


    @FXML
    public void initialize() {

        selectMonthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );
    }


    @FXML
    public void handleCalculate(ActionEvent actionEvent) {

        System.out.println("Calculating attendance rate...");

        attendanceRateTextField.setText("95%");
    }


    @FXML
    public void handleGenerateReport(ActionEvent actionEvent) {

        System.out.println("Attendance report generated.");

    }


    @FXML
    public void handleExport(ActionEvent actionEvent) {

        System.out.println("Attendance report exported.");

    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        AttendanceManagement attendance =
                new AttendanceManagement();

        attendance.setEmployeeID(
                employeeIDTextField.getText()
        );

        attendance.setEmployeeName(
                employeeNameTextField.getText()
        );

        attendance.setMonth(
                selectMonthComboBox.getValue()
        );

        attendance.setAttendanceRate(
                attendanceRateTextField.getText()
        );

        attendance.setAbsences(
                absencesTextField.getText()
        );

        attendance.setOvertime(
                overtimeTextArea.getText()
        );

        System.out.println("Attendance record saved.");
    }


    @FXML
    public void HandleClear(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        selectMonthComboBox.setValue(null);
        attendanceRateTextField.clear();
        absencesTextField.clear();
        overtimeTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        selectMonthComboBox.setValue(null);
        attendanceRateTextField.clear();
        absencesTextField.clear();
        overtimeTextArea.clear();

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}