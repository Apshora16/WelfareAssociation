package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OrganizationRecordController {

    @FXML
    private ComboBox<String> recordTitleComboBox;

    @FXML
    private ComboBox<String> recordCategoryComboBox;

    @FXML
    private TextArea recordInformationTextArea;

    @FXML
    private TextField uploadDocumentTextField;


    @FXML
    public void initialize() {

        recordTitleComboBox.getItems().addAll(
                "Meeting Record",
                "Welfare Program Record",
                "Employee Record",
                "Official Record"
        );

        recordCategoryComboBox.getItems().addAll(
                "Administrative",
                "Financial",
                "Welfare",
                "Employee"
        );
    }


    @FXML
    public void handleAddRecord(ActionEvent actionEvent) {

        System.out.println("Add Record selected.");
    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        OrganizationRecord record = new OrganizationRecord();

        record.setRecordTitle(
                recordTitleComboBox.getValue()
        );

        record.setRecordCategory(
                recordCategoryComboBox.getValue()
        );

        record.setRecordInformation(
                recordInformationTextArea.getText()
        );

        record.setUploadDocument(
                uploadDocumentTextField.getText()
        );

        System.out.println("Record saved successfully.");
    }


    @FXML
    public void handleBrowse(ActionEvent actionEvent) {

        System.out.println("Browse document selected.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        recordTitleComboBox.setValue(null);
        recordCategoryComboBox.setValue(null);
        recordInformationTextArea.clear();
        uploadDocumentTextField.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        recordTitleComboBox.setValue(null);
        recordCategoryComboBox.setValue(null);
        recordInformationTextArea.clear();
        uploadDocumentTextField.clear();

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}