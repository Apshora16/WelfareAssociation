package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Complaint;
import com.example.welfareassociation.model.ComplaintDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SubmitComplaintController
{
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TextField subjectTF;
    @javafx.fxml.FXML
    private TextField evidenceTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        categoryComboBox.setItems(
                FXCollections.observableArrayList(
                        "Harassment",
                        "Safety Issue",
                        "Salary",
                        "Work Environment",
                        "Other"
                )
        );

        categoryComboBox.setValue(null);
        subjectTF.clear();
        descriptionTA.clear();
        evidenceTF.clear();

        statusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void submitApplicationButtonOA(ActionEvent actionEvent) {

        String category = categoryComboBox.getValue();
        String subject = subjectTF.getText().trim();
        String description = descriptionTA.getText().trim();
        String evidence = evidenceTF.getText().trim();

        if (category == null
                || subject.isEmpty()
                || description.isEmpty()
                || evidence.isEmpty()) {

            statusLabel.setText("Please complete all fields.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields."
            );

            return;
        }

        Complaint complaint = new Complaint(
                category,
                subject,
                description,
                evidence,
                "Pending"
        );

        ComplaintDatabase.addComplaint(complaint);

        statusLabel.setText("Complaint submitted successfully.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Complaint submitted successfully."
        );

        categoryComboBox.setValue(null);
        subjectTF.clear();
        descriptionTA.clear();
        evidenceTF.clear();
    }



    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {

        categoryComboBox.setValue(null);
        subjectTF.clear();
        descriptionTA.clear();
        evidenceTF.clear();

        statusLabel.setText("Form cleared.");

    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/com.example.welfareassociation/Employee/EmployeeDashboard.fxml"
        );
    }



    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL)
                == ButtonType.OK) {

            System.out.println("Logout Successfully.");

            SceneSwitcher.switchScene(
                    actionEvent,
                    "/com.example.welfareassociation/hello-view.fxml"
            );
        }
    }



    @javafx.fxml.FXML
    public void browseButtonOA(ActionEvent actionEvent) {

        evidenceTF.setText("C:\\Documents\\Evidence.pdf");

        statusLabel.setText("Evidence selected.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Browse",
                "Evidence selected successfully."
        );
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