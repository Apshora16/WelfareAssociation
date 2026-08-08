package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DepartmentCoordinationController {

    @FXML
    private TextField departmentTextField;

    @FXML
    private TextField departmentStatusTextField;

    @FXML
    private TextArea assignTaskTextArea;

    @FXML
    private DatePicker deadlineDatePicker;

    @FXML
    private RadioButton assignTaskRadioButton;

    @FXML
    private RadioButton generateReportRadioButton;


    @FXML
    public void initialize() {
    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        DepartmentCoordination departmentCoordination =
                new DepartmentCoordination();

        departmentCoordination.setDepartment(
                departmentTextField.getText()
        );

        departmentCoordination.setDepartmentStatus(
                departmentStatusTextField.getText()
        );

        departmentCoordination.setAssignedTask(
                assignTaskTextArea.getText()
        );

        departmentCoordination.setDeadline(
                deadlineDatePicker.getValue()
        );

        if (assignTaskRadioButton.isSelected()) {
            departmentCoordination.setTaskProgress("Task Assigned");
        } else if (generateReportRadioButton.isSelected()) {
            departmentCoordination.setTaskProgress("Report Generated");
        } else {
            departmentCoordination.setTaskProgress("Not Started");
        }

        System.out.println("Department coordination saved.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        departmentTextField.clear();
        departmentStatusTextField.clear();
        assignTaskTextArea.clear();
        deadlineDatePicker.setValue(null);

        assignTaskRadioButton.setSelected(false);
        generateReportRadioButton.setSelected(false);
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        departmentTextField.clear();
        departmentStatusTextField.clear();
        assignTaskTextArea.clear();
        deadlineDatePicker.setValue(null);

        assignTaskRadioButton.setSelected(false);
        generateReportRadioButton.setSelected(false);

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}