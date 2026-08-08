package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Employee;
import com.example.welfareassociation.model.EmployeeDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ManageRoles
{
    @javafx.fxml.FXML
    private ListView<Employee> employeesListView;
    @javafx.fxml.FXML
    private ComboBox<String> newRoleComboBox;
    @javafx.fxml.FXML
    private Label statusMessageLabel;
    @javafx.fxml.FXML
    private TextField selectedEmployeeTF;
    @javafx.fxml.FXML
    private TextField currentRoleTF;

    @javafx.fxml.FXML
    public void initialize() {

        newRoleComboBox.setItems(FXCollections.observableArrayList(
                "Employee",
                "Supervisor",
                "HR Manager",
                "Welfare Officer",
                "System Administrator"
        ));

        refreshEmployeeList();

        employeesListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, employee) -> {

                    if (employee != null) {

                        selectedEmployeeTF.setText(employee.getEmployeeName());
                        currentRoleTF.setText(employee.getRole());

                    }

                }
        );

        statusMessageLabel.setText("");
    }

    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {

        refreshEmployeeList();

        selectedEmployeeTF.clear();
        currentRoleTF.clear();

        newRoleComboBox.getSelectionModel().clearSelection();

        statusMessageLabel.setText("Employee list refreshed.");
    }

    private void refreshEmployeeList() {

        employeesListView.setItems(EmployeeDatabase.getEmployeeList());
    }

    @javafx.fxml.FXML
    public void updateRoleButtonOA(ActionEvent actionEvent) {

        Employee employee = employeesListView.getSelectionModel().getSelectedItem();

        if (employee == null) {

            showAlert(Alert.AlertType.WARNING,
                    "No Employee",
                    "Please select an employee.");

            return;
        }

        String newRole = newRoleComboBox.getValue();

        if (newRole == null) {

            showAlert(Alert.AlertType.WARNING,
                    "No Role",
                    "Please select a role.");

            return;
        }

        employee.setRole(newRole);

        currentRoleTF.setText(newRole);

        employeesListView.refresh();

        statusMessageLabel.setText("Role updated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Employee role updated successfully.");
    }


    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,"/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml");
    }


    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {

            System.out.println("Logout Successful.");

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