package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Training;
import com.example.welfareassociation.model.TrainingDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ApplyTrainingController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectProgramComboBox;
    @javafx.fxml.FXML
    private ListView<String> availableTrainingListView;
    @javafx.fxml.FXML
    private DatePicker programDateDatePicker;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        availableTrainingListView.setItems(
                FXCollections.observableArrayList(
                        "Leadership Training",
                        "Safety Training",
                        "Machine Operation",
                        "Computer Skills",
                        "Communication Skills"
                )
        );

        selectProgramComboBox.setItems(
                FXCollections.observableArrayList(
                        "Leadership Training",
                        "Safety Training",
                        "Machine Operation",
                        "Computer Skills",
                        "Communication Skills"
                )
        );

        selectProgramComboBox.setValue(null);
        programDateDatePicker.setValue(null);

        statusLabel.setText("");
    }



    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {

        availableTrainingListView.refresh();

        statusLabel.setText("Training list refreshed.");
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

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {

            System.out.println("Logout Successfully.");

            SceneSwitcher.switchScene(
                    actionEvent,
                    "/com.example.welfareassociation/hello-view.fxml"
            );
        }
    }



    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {

        String program = selectProgramComboBox.getValue();
        LocalDate date = programDateDatePicker.getValue();

        if (program == null || date == null) {

            statusLabel.setText("Please complete all fields.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please select a training program and date."
            );

            return;
        }

        Training training = new Training(
                program,
                date.toString(),
                "Pending"
        );

        TrainingDatabase.addTraining(training);

        statusLabel.setText("Training application submitted.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Training application submitted successfully."
        );

        selectProgramComboBox.setValue(null);
        programDateDatePicker.setValue(null);
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