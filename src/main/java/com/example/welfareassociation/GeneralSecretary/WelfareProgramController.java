package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class WelfareProgramController {

    @FXML
    private TextField programNameTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField eligibilityCriteriaTextField;

    @FXML
    private DatePicker deadlineDatePicker;

    @FXML
    private ComboBox<String> assignWelfareOfficerComboBox;


    @FXML
    public void initialize() {

        assignWelfareOfficerComboBox.getItems().addAll(
                "Welfare Officer 1",
                "Welfare Officer 2",
                "Welfare Officer 3",
                "Welfare Officer 4"
        );
    }


    @FXML
    public void handleCreateProgram(ActionEvent actionEvent) {

        WelfareProgram program = new WelfareProgram();

        program.setProgramName(
                programNameTextField.getText()
        );

        program.setDescription(
                descriptionTextField.getText()
        );

        program.setEligibilityCriteria(
                eligibilityCriteriaTextField.getText()
        );

        program.setDeadline(
                deadlineDatePicker.getValue()
        );

        program.setWelfareOfficer(
                assignWelfareOfficerComboBox.getValue()
        );

        System.out.println("Welfare program created successfully.");
    }


    @FXML
    public void handlePublishProgram(ActionEvent actionEvent) {

        System.out.println("Welfare program published.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        programNameTextField.clear();
        descriptionTextField.clear();
        eligibilityCriteriaTextField.clear();
        deadlineDatePicker.setValue(null);
        assignWelfareOfficerComboBox.setValue(null);
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        programNameTextField.clear();
        descriptionTextField.clear();
        eligibilityCriteriaTextField.clear();
        deadlineDatePicker.setValue(null);
        assignWelfareOfficerComboBox.setValue(null);

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}