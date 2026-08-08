package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WelfareVerificationController {

    @FXML
    private TextField applicantIDTextField;

    @FXML
    private TextField applicantNameTextField;

    @FXML
    private ComboBox<String> employeeStatusComboBox;

    @FXML
    private TextField attendanceTextField;

    @FXML
    private TextArea serviceHistoryTextArea;

    @FXML
    private TextArea documentsTextArea;

    @FXML
    private RadioButton verificationStatusApprovedRadioButton;

    @FXML
    private RadioButton verificationStatusRejectedRadioButton;

    @FXML
    private TextArea remarksTextArea;


    @FXML
    public void initialize() {

        employeeStatusComboBox.getItems().addAll(
                "Active",
                "Inactive",
                "On Leave",
                "Terminated"
        );
    }


    @FXML
    public void handleVerify(ActionEvent event) {

        if (applicantIDTextField.getText().isEmpty()
                || applicantNameTextField.getText().isEmpty()) {

            System.out.println("Please enter applicant information.");
            return;
        }

        if (verificationStatusApprovedRadioButton.isSelected()) {
            System.out.println("Applicant verification: Approved");
        }
        else if (verificationStatusRejectedRadioButton.isSelected()) {
            System.out.println("Applicant verification: Rejected");
        }
        else {
            System.out.println("Please select verification status.");
        }
    }


    @FXML
    public void handleGenerateReport(ActionEvent event) {

        System.out.println("Verification report generated.");
    }


    @FXML
    public void handleSave(ActionEvent event) {

        String verificationStatus = "";

        if (verificationStatusApprovedRadioButton.isSelected()) {
            verificationStatus = "Approved";
        }
        else if (verificationStatusRejectedRadioButton.isSelected()) {
            verificationStatus = "Rejected";
        }

        WelfareVerification verification = new WelfareVerification(
                applicantIDTextField.getText(),
                applicantNameTextField.getText(),
                employeeStatusComboBox.getValue(),
                attendanceTextField.getText(),
                serviceHistoryTextArea.getText(),
                documentsTextArea.getText(),
                verificationStatus,
                remarksTextArea.getText()
        );

        System.out.println("Verification saved:");
        System.out.println(verification);
    }


    @FXML
    public void handleClear(ActionEvent event) {

        applicantIDTextField.clear();
        applicantNameTextField.clear();
        employeeStatusComboBox.setValue(null);
        attendanceTextField.clear();
        serviceHistoryTextArea.clear();
        documentsTextArea.clear();
        verificationStatusApprovedRadioButton.setSelected(false);
        verificationStatusRejectedRadioButton.setSelected(false);
        remarksTextArea.clear();
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