package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WorkforceDatabaseController {

    @FXML
    private TextField searchEmployeeIDTextField;

    @FXML
    private ComboBox<String> selectDepartmentComboBox;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private TextField designationTextField;

    @FXML
    private ComboBox<String> SelectStatusComboBox;

    @FXML
    private TextArea employeeInformationTextArea;


    @FXML
    public void initialize() {

        selectDepartmentComboBox.getItems().addAll(
                "Production",
                "HR",
                "Finance",
                "Administration",
                "Marketing",
                "Quality Control"
        );

        SelectStatusComboBox.getItems().addAll(
                "Active",
                "Inactive",
                "On Leave",
                "Resigned",
                "Terminated"
        );
    }


    @FXML
    public void handleUpdateInformation(ActionEvent event) {

        System.out.println("Employee information updated.");

    }


    @FXML
    public void handleSave(ActionEvent event) {

        WorkforceDatabase employee = new WorkforceDatabase(
                searchEmployeeIDTextField.getText(),
                selectDepartmentComboBox.getValue(),
                employeeNameTextField.getText(),
                designationTextField.getText(),
                SelectStatusComboBox.getValue(),
                employeeInformationTextArea.getText()
        );

        System.out.println("Employee record saved.");
        System.out.println(employee);
    }


    @FXML
    public void handleBackup(ActionEvent event) {

        System.out.println("Workforce database backup created.");

    }


    @FXML
    public void handleGenerateSummary(ActionEvent event) {

        System.out.println("Workforce summary generated.");

    }


    @FXML
    public void handleRefresh(ActionEvent event) {

        System.out.println("Workforce database refreshed.");

    }


    @FXML
    public void handleClear(ActionEvent event) {

        searchEmployeeIDTextField.clear();
        selectDepartmentComboBox.setValue(null);
        employeeNameTextField.clear();
        designationTextField.clear();
        SelectStatusComboBox.setValue(null);
        employeeInformationTextArea.clear();

    }


    @FXML
    public void handleCancel(ActionEvent event) {

        handleClear(event);

        System.out.println("Operation cancelled.");

    }


    @FXML
    public void handleLogout(ActionEvent event) {

        System.out.println("Logout clicked.");

    }
}