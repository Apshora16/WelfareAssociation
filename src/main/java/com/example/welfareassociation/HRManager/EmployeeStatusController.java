package com.example.welfareassociation.HRManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeStatusController {

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private ComboBox<String> currentStatusComboBox;

    @FXML
    private TextArea transferHistoryTextArea;

    @FXML
    private TextArea promotionHistoryTextArea;

    @FXML
    private TextArea leaveRecordsTextArea;


    @FXML
    public void initialize() {

        currentStatusComboBox.getItems().addAll(
                "Active",
                "On Leave",
                "Transferred",
                "Promoted",
                "Inactive"
        );
    }


    @FXML
    public void handleUpdateStatus(ActionEvent actionEvent) {

        EmployeeStatus employeeStatus = new EmployeeStatus();

        employeeStatus.setEmployeeID(
                employeeIDTextField.getText()
        );

        employeeStatus.setEmployeeName(
                employeeNameTextField.getText()
        );

        employeeStatus.setCurrentStatus(
                currentStatusComboBox.getValue()
        );

        employeeStatus.setTransferHistory(
                transferHistoryTextArea.getText()
        );

        employeeStatus.setPromotionHistory(
                promotionHistoryTextArea.getText()
        );

        employeeStatus.setLeaveRecords(
                leaveRecordsTextArea.getText()
        );

        System.out.println("Employee status updated.");
    }


    @FXML
    public void handleGenerateReport(ActionEvent actionEvent) {

        System.out.println("Employee status report generated.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        currentStatusComboBox.setValue(null);
        transferHistoryTextArea.clear();
        promotionHistoryTextArea.clear();
        leaveRecordsTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        employeeIDTextField.clear();
        employeeNameTextField.clear();
        currentStatusComboBox.setValue(null);
        transferHistoryTextArea.clear();
        promotionHistoryTextArea.clear();
        leaveRecordsTextArea.clear();

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}