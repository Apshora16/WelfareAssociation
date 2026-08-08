package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.EmployeeDatabase;
import com.example.welfareassociation.model.SecurityDatabase;
import com.example.welfareassociation.model.SecurityLog;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.time.LocalDate;

public class SystemSecurityController
{
    @javafx.fxml.FXML
    private Label activeSessionsLabel;
    @javafx.fxml.FXML
    private Label totalUsersLabel;
    @javafx.fxml.FXML
    private ListView<SecurityLog> accessLogsListView;
    @javafx.fxml.FXML
    private Label lastScanLabel;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Label securityStatusLabel;


    @javafx.fxml.FXML
    public void initialize() {


        statusLabel.setText("");

        loadAccessLogs();
    }

    private void loadAccessLogs() {

        if (SecurityDatabase.getSecurityLogs().isEmpty()) {

            SecurityDatabase.addLog(
                    new SecurityLog(
                            "Secure",
                            LocalDate.now().toString(),
                            String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                            "1",
                            "Admin logged into the system."
                    ));

            SecurityDatabase.addLog(
                    new SecurityLog(
                            "Secure",
                            LocalDate.now().toString(),
                            String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                            "1",
                            "Employee account created."
                    ));

            SecurityDatabase.addLog(
                    new SecurityLog(
                            "Warning",
                            LocalDate.now().toString(),
                            String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                            "1",
                            "Role updated successfully."
                    ));

            SecurityDatabase.addLog(
                    new SecurityLog(
                            "Secure",
                            LocalDate.now().toString(),
                            String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                            "1",
                            "Database backup completed."
                    ));
        }

        accessLogsListView.setItems(SecurityDatabase.getSecurityLogs());
        SecurityLog latestLog= SecurityDatabase.getSecurityLogs().get(
                SecurityDatabase.getSecurityLogs().size() -1
        );

        securityStatusLabel.setText(
                "Security Status:" + latestLog.getSecurityStatus());

        lastScanLabel.setText(
                "Last Scan:" + latestLog.getLastScan());

        totalUsersLabel.setText(
                "Total Users : " + latestLog.getTotalUsers());

        activeSessionsLabel.setText(
                "Active Sessions : " + latestLog.getActiveSessions());


    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,"/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void scanButtonOA(ActionEvent actionEvent) {

        SecurityLog log = new SecurityLog(
                "Secure",
                LocalDate.now().toString(),
                String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                "1",
                "System scan completed successfully."
        );

        SecurityDatabase.addLog(log);

        loadAccessLogs();

        statusLabel.setText("System scan completed.");

        showAlert(Alert.AlertType.INFORMATION,
                "System Scan",
                "System scanned successfully.");
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
    public void updateButtonOA(ActionEvent actionEvent) {


        SecurityLog log = new SecurityLog(
                "Secure",
                LocalDate.now().toString(),
                String.valueOf(EmployeeDatabase.getEmployeeList().size()),
                "1",
                "Security settings updated."
        );

        SecurityDatabase.addLog(log);

        loadAccessLogs();

        statusLabel.setText("Security updated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Security Update",
                "System security updated successfully.");
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