package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class HrReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private ComboBox<String> selectDepartmentComboBox;

    @FXML
    private DatePicker fromDateDatePicker;

    @FXML
    private DatePicker toDateDatePicker;

    @FXML
    private TextArea reportPreviewTextArea;


    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "Employee Report",
                "Attendance Report",
                "Eligibility Report",
                "Recruitment Report",
                "Employee Status Report"
        );

        selectDepartmentComboBox.getItems().addAll(
                "Production",
                "Human Resources",
                "Finance",
                "Administration",
                "Quality Control"
        );
    }


    @FXML
    public void handleGenerateReport(ActionEvent actionEvent) {

        HrReport report = new HrReport();

        report.setReportType(
                reportTypeComboBox.getValue()
        );

        report.setFromDate(
                fromDateDatePicker.getValue()
        );

        report.setToDate(
                toDateDatePicker.getValue()
        );

        report.setDepartment(
                selectDepartmentComboBox.getValue()
        );

        report.setReportPreview(
                "HR Report generated successfully."
        );

        reportPreviewTextArea.setText(
                "Report Type: " + report.getReportType() +
                        "\nDepartment: " + report.getDepartment() +
                        "\nFrom: " + report.getFromDate() +
                        "\nTo: " + report.getToDate()
        );

        System.out.println("HR Report generated.");
    }


    @FXML
    public void handlePreview(ActionEvent actionEvent) {

        reportPreviewTextArea.setText(
                "HR Report Preview\n\n" +
                        "Report Type: " + reportTypeComboBox.getValue() +
                        "\nDepartment: " + selectDepartmentComboBox.getValue() +
                        "\nFrom Date: " + fromDateDatePicker.getValue() +
                        "\nTo Date: " + toDateDatePicker.getValue()
        );
    }


    @FXML
    public void handleDownloadPDF(ActionEvent actionEvent) {

        System.out.println("PDF download selected.");
    }


    @FXML
    public void handleSavePDF(ActionEvent actionEvent) {

        System.out.println("PDF saved.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        reportTypeComboBox.setValue(null);
        selectDepartmentComboBox.setValue(null);
        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);
        reportPreviewTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        reportTypeComboBox.setValue(null);
        selectDepartmentComboBox.setValue(null);
        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);
        reportPreviewTextArea.clear();

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}