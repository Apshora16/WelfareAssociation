package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class OrganizationReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker fromDateDatePicker;

    @FXML
    private DatePicker toDateDatePicker;

    @FXML
    private TextArea reportSummaryTextArea;


    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "Welfare Program Report",
                "Department Coordination Report",
                "Activity Monitoring Report",
                "Organizational Summary Report"
        );
    }


    @FXML
    public void handleGenerateReport(ActionEvent actionEvent) {

        String reportType = reportTypeComboBox.getValue();

        if (reportType == null) {
            reportSummaryTextArea.setText(
                    "Please select a report type."
            );
            return;
        }

        reportSummaryTextArea.setText(
                "Report Type: " + reportType +
                        "\nFrom: " + fromDateDatePicker.getValue() +
                        "\nTo: " + toDateDatePicker.getValue() +
                        "\n\nReport generated successfully."
        );
    }


    @FXML
    public void handlePreview(ActionEvent actionEvent) {

        reportSummaryTextArea.setText(
                "Report Preview\n\n" +
                        "Report Type: " + reportTypeComboBox.getValue() +
                        "\nFrom Date: " + fromDateDatePicker.getValue() +
                        "\nTo Date: " + toDateDatePicker.getValue()
        );
    }


    @FXML
    public void handleDownloadPDF(ActionEvent actionEvent) {

        System.out.println("PDF downloaded.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        reportTypeComboBox.setValue(null);
        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);
        reportSummaryTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        reportTypeComboBox.setValue(null);
        fromDateDatePicker.setValue(null);
        toDateDatePicker.setValue(null);
        reportSummaryTextArea.clear();

        System.out.println("Report generation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}