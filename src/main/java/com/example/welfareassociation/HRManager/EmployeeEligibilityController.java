package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeEigibilityController {

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private ComboBox<String> employeeStatusComboBox;

    @FXML
    private TextField attendanceTextField;

    @FXML
    private TextField serviceDurationTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextArea documentsTextArea;

    @FXML
    private RadioButton eligibilityRadioButton;

    @FXML
    private RadioButton notEligibleRadioButton;


    @FXML
    public void initialize() {

        employeeStatusComboBox.getItems().addAll(
                "Active",
                "Inactive",
                "On Leave",
                "Probation"
        );
    }


    @FXML
    public void handleVerify(ActionEvent actionEvent) {

        if (eligibilityRadioButton.isSelected()) {
            System.out.println("Employee is eligible.");
        }
        else if (notEligibleRadioButton.isSelected()) {
            System.out.println("Employee is not eligible.");
        }
        else {
            System.out.println("Please select eligibility status.");
        }
    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        EmployeeEigibility employee = new EmployeeEigibility();

        employee.setEmployeeID(
                employeeIDTextField.getText()
        );

        employee.setEmployeeName(
                employeeNameTextField.getText()
        );

        employee.setEmployeeStatus(
                employeeStatusComboBox.getValue()
        );

        employee.setAttendance(
                attendanceTextField.getText()
        );

        employee.setServiceDuration(
                serviceDurationTextField.getText()
        );

        employee.setSalary(
                salaryTextField.getText()
        );

        employee.setDocuments(
                documentsTextArea.getText()
        );

        if (eligibilityRadioButton.isSelected()) {
            employee.setEligibility("Eligible");
        }
        else if (notEligibleRadioButton.isSelected()) {
            employee.setEligibility("Not Eligible");
        }
        else {
            employee.setEligibility("Not Decided");
        }

        System.out.println("Eligibility record saved.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        employeeStatusComboBox.setValue(null);
        attendanceTextField.clear();
        serviceDurationTextField.clear();
        salaryTextField.clear();
        documentsTextArea.clear();

        eligibilityRadioButton.setSelected(false);
        notEligibleRadioButton.setSelected(false);
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        employeeStatusComboBox.setValue(null);
        attendanceTextField.clear();
        serviceDurationTextField.clear();
        salaryTextField.clear();
        documentsTextArea.clear();

        eligibilityRadioButton.setSelected(false);
        notEligibleRadioButton.setSelected(false);

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}