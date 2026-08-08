package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeManagementController {

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField employeeAddressTextField;

    @FXML
    private ComboBox<String> selectDepartmentComboBox;

    @FXML
    private TextArea addressTextArea;


    @FXML
    public void initialize() {

        selectDepartmentComboBox.getItems().addAll(
                "Production",
                "Human Resources",
                "Finance",
                "Administration",
                "Quality Control"
        );
    }


    @FXML
    public void handleAddEmployee(ActionEvent actionEvent) {

        System.out.println("Add Employee selected.");
    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        EmployeeManagement employee =
                new EmployeeManagement();

        employee.setEmployeeID(
                employeeIDTextField.getText()
        );

        employee.setEmployeeName(
                employeeNameTextField.getText()
        );

        employee.setPhoneNumber(
                phoneNumberTextField.getText()
        );

        employee.setEmployeeAddress(
                employeeAddressTextField.getText()
        );

        employee.setDepartment(
                selectDepartmentComboBox.getValue()
        );

        employee.setAddress(
                addressTextArea.getText()
        );

        System.out.println("Employee record saved.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        phoneNumberTextField.clear();
        employeeAddressTextField.clear();
        selectDepartmentComboBox.setValue(null);
        addressTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        phoneNumberTextField.clear();
        employeeAddressTextField.clear();
        selectDepartmentComboBox.setValue(null);
        addressTextArea.clear();

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}