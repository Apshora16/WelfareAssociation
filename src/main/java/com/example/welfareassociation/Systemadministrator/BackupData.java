package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Backup;
import com.example.welfareassociation.model.BackupDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class BackupData
{
    @javafx.fxml.FXML
    private ComboBox<String> backupSourceComboBox;
    @javafx.fxml.FXML
    private TextField backupLocationTF;
    @javafx.fxml.FXML
    private ListView<Backup> backupHistoryListView;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        backupSourceComboBox.setItems(
                FXCollections.observableArrayList(
                        "Employee Database",
                        "Role Management",
                        "System Reports",
                        "System Activities",
                        "Security Data"
                ));

        statusLabel.setText("");

        loadBackupHistory();
    }

    private void loadBackupHistory() {

        if (BackupDatabase.getBackupList().isEmpty()) {

            BackupDatabase.addBackup(
                    new Backup(
                            "Employee Database",
                            "D:\\Backup",
                            LocalDate.now().toString(),
                            "Completed"
                    ));

            BackupDatabase.addBackup(
                    new Backup(
                            "System Reports",
                            "D:\\Backup",
                            LocalDate.now().toString(),
                            "Completed"
                    ));
        }

        backupHistoryListView.setItems(
                BackupDatabase.getBackupList());
    }


    @javafx.fxml.FXML
    public void restoreBackupButtonOA(ActionEvent actionEvent) {

        Backup backup = backupHistoryListView.getSelectionModel().getSelectedItem();

        if (backup == null) {

            statusLabel.setText("Please select a backup.");

            showAlert(Alert.AlertType.WARNING,
                    "Restore Backup",
                    "Please select a backup from the history.");

            return;
        }

        statusLabel.setText("Backup restored successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Restore Backup",
                "Backup restored successfully.");
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,"/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml");

    }

    @javafx.fxml.FXML
    public void createBackupButtonOA(ActionEvent actionEvent) {

        String source = backupSourceComboBox.getValue();
        String location = backupLocationTF.getText().trim();

        if (source == null || location.isEmpty()) {

            statusLabel.setText("Please select source and location.");

            showAlert(Alert.AlertType.WARNING,
                    "Backup",
                    "Please select a backup source and location.");

            return;
        }

        Backup backup = new Backup(
                source,
                location,
                LocalDate.now().toString(),
                "Completed"
        );

        BackupDatabase.addBackup(backup);

        backupHistoryListView.refresh();

        backupHistoryListView.getSelectionModel().select(backup);

        statusLabel.setText("Backup created successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Backup",
                "Backup created successfully.");
    }


    @javafx.fxml.FXML
    public void browseButtonOA(ActionEvent actionEvent) {

        backupLocationTF.setText("D:\\Backup");

        statusLabel.setText("Backup location selected.");

        showAlert(Alert.AlertType.INFORMATION,
                "Browse",
                "Backup location selected successfully.");
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