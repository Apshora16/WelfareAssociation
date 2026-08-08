package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Report;
import com.example.welfareassociation.model.ReportDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;


public class SystemReportsController
{
    @javafx.fxml.FXML
    private TextArea reportPreviewTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private ListView<Report> reportHistoryListView;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        reportTypeComboBox.setItems(FXCollections.observableArrayList(
                "Employee Report","Role Management Report",
                "System Activity Report","Database Report","Backup Report"
        ));

        reportPreviewTextArea.setEditable(false);

        statusLabel.setText("");

        loadReportHistory();
    }

    private void loadReportHistory(){

        if(ReportDatabase.getReportList().isEmpty()){

            ReportDatabase.addReport(new Report(
                    "Employee Report",
                    "Employee records generated successfully.",

                    LocalDate.now().toString()
            ));

            ReportDatabase.addReport(new Report(
                    "System Activity Report",
                    "System activities monitored successfully.",
                    LocalDate.now().toString()
            ));
        }


        reportHistoryListView.setItems(ReportDatabase.getReportList());

        reportHistoryListView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable,oldValue, report)->{

                    if (report!= null){

                        reportPreviewTextArea.setText(report.getReportContent());

                    }
                });
    }

    @javafx.fxml.FXML
    public void generateButtonOA(ActionEvent actionEvent) {

        String reportType= reportTypeComboBox.getValue();

        if(reportType == null){

            statusLabel.setText("Please select a report type.");

            showAlert(Alert.AlertType.WARNING,
                    "Report",
                    "Please select a report type.");

            return;
        }

        String reportContent;

        switch(reportType){

            case "Employee Report":
                reportContent=
                        "======EMPLOYEE REPORT=====\n\n" +
                                "Total Employees: "
                        +com.example.welfareassociation.model.EmployeeDatabase
                                .getEmployeeList().size()
                                + "\n\nEmployee records generated successfully.";
                break;

            case "Role Management Report":
                reportContent=
                        "===== ROLE MANAGEMENT REPORT =====\n\n" +
                                "Role management information generated successfully.";
                break;


            case "System Activity Report":
                reportContent =
                        "===== SYSTEM ACTIVITY REPORT =====\n\n" +
                                "Total Activities : "
                                + com.example.welfareassociation.model.ActivityDatabase
                                .getActivityList().size()
                                + "\n\nSystem activity report generated successfully.";
                break;


            case "Database Report":
                reportContent =
                        "===== DATABASE REPORT =====\n\n" +
                                "Database status is normal.\nAll employee records are available.";
                break;


            case "Backup Report":
                reportContent =
                        "===== BACKUP REPORT =====\n\n" +
                                "Latest backup completed successfully.";
                break;


            default:
                reportContent="No report available";


        }

        reportPreviewTextArea.setText(reportContent);

        Report report = new Report(
                reportType, reportContent,
                LocalDate.now().toString()
        );

        ReportDatabase.addReport(report);

        reportHistoryListView.refresh();

        reportHistoryListView.getSelectionModel().select(report);

        statusLabel.setText("Report generated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Report generated successfully.");
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,"/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {

            System.out.println("Logout Successfully.");

            SceneSwitcher.switchScene(
                    actionEvent,
                    "/com.example.welfareassociation/hello-view.fxml"
            );
        }
    }


    @javafx.fxml.FXML
    public void exportButtonOA(ActionEvent actionEvent) {

        if (reportPreviewTextArea.getText().isEmpty()) {

            statusLabel.setText("No report available.");

            showAlert(Alert.AlertType.WARNING,
                    "Export",
                    "Please generate a report first.");

            return;
        }

        showAlert(Alert.AlertType.INFORMATION,
                "Export",
                "Report exported successfully.");

        statusLabel.setText("Report exported.");


    }


    private void showAlert(Alert.AlertType type,
                           String title,
                           String message) {

        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}