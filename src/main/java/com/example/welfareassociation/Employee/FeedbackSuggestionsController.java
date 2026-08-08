package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Feedback;
import com.example.welfareassociation.model.FeedbackDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class FeedbackSuggestionsController
{
    @javafx.fxml.FXML
    private ComboBox<String> categoryComboBox;
    @javafx.fxml.FXML
    private TextField topicTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        categoryComboBox.setItems(
                FXCollections.observableArrayList(
                        "Suggestion",
                        "Complaint",
                        "System Improvement",
                        "Training",
                        "Other"
                )
        );

        categoryComboBox.setValue(null);
        topicTF.clear();
        descriptionTA.clear();

        statusLabel.setText("");
    }



    @javafx.fxml.FXML
    public void submitFeedbackButtonOA(ActionEvent actionEvent) {

        String category = categoryComboBox.getValue();
        String topic = topicTF.getText().trim();
        String description = descriptionTA.getText().trim();

        if (category == null
                || topic.isEmpty()
                || description.isEmpty()) {

            statusLabel.setText("Please complete all fields.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields."
            );

            return;
        }

        Feedback feedback = new Feedback(
                category,
                topic,
                description,
                "Submitted"
        );

        FeedbackDatabase.addFeedback(feedback);

        statusLabel.setText("Feedback submitted successfully.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Feedback submitted successfully."
        );

        categoryComboBox.setValue(null);
        topicTF.clear();
        descriptionTA.clear();
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {

        categoryComboBox.setValue(null);
        topicTF.clear();
        descriptionTA.clear();

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