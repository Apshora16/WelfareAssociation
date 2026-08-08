package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Assistance;
import com.example.welfareassociation.model.AssistanceDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ApplyAssistanceController
{
    @javafx.fxml.FXML
    private ComboBox<String> assistanceTypeComboBox;
    @javafx.fxml.FXML
    private TextField documentsTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        assistanceTypeComboBox.setItems(
                FXCollections.observableArrayList(
                        "Medical",
                        "Education",
                        "Housing",
                        "Emergency",
                        "Financial"
                )
        );
        assistanceTypeComboBox.setValue(null);
        descriptionTA.clear();
        amountTF.clear();
        documentsTF.clear();

        statusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {

        assistanceTypeComboBox.setValue(null);
        descriptionTA.clear();
        amountTF.clear();
        documentsTF.clear();

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
    public void submittedApplicationButtonOA(ActionEvent actionEvent) {

        String type = assistanceTypeComboBox.getValue();
        String description = descriptionTA.getText().trim();
        String amount = amountTF.getText().trim();
        String document = documentsTF.getText().trim();

        if (type == null
                || description.isEmpty()
                || amount.isEmpty()
                || document.isEmpty()) {

            statusLabel.setText("Please complete all fields.");

            showAlert(Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields.");

            return;
        }

        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {

            statusLabel.setText("Invalid amount.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Invalid Amount",
                    "Please enter a valid numeric amount."
            );

            return;
        }


        Assistance assistance = new Assistance(
                type,
                description,
                amount,
                document,
                "Pending"
        );

        AssistanceDatabase.addAssistance(assistance);

        statusLabel.setText("Application submitted successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Application submitted successfully.");

        assistanceTypeComboBox.setValue(null);
        descriptionTA.clear();
        amountTF.clear();
        documentsTF.clear();
    }



    @javafx.fxml.FXML
    public void browseButtonOA(ActionEvent actionEvent) {

        documentsTF.setText("C:\\Documents\\Application.pdf");

        statusLabel.setText("Document selected.");

        showAlert(Alert.AlertType.INFORMATION,
                "Browse",
                "Document selected successfully.");
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