package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Employee;
import com.example.welfareassociation.model.EmployeeDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;


public class EmployeeDatabaseController
{
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TableView<Employee> employeeTableView;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> phoneCol;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> departmentCol;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Employee,String> emailCol;

    private  Employee selectedEmployee;


    @javafx.fxml.FXML
    public void initialize() {
        departmentComboBox.setItems(FXCollections.observableArrayList("Production",
                "HR",
                "Accounts",
                "Finance",
                "Marketing",
                "Quality Control",
                "Maintenance"
        ));

        statusComboBox.setItems(FXCollections.observableArrayList(
                "Active",
                "Inactive"
        ));

        idCol.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        refreshTable();

        employeeTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, employee) -> {

                    if (employee != null) {

                        selectedEmployee = employee;

                        nameTF.setText(employee.getEmployeeName());
                        phoneTF.setText(employee.getPhoneNumber());
                        emailTF.setText(employee.getEmail());

                        departmentComboBox.setValue(employee.getDepartment());
                        statusComboBox.setValue(employee.getEmploymentStatus());
                    }
                });
        statusLabel.setText("");

    }

    private void refreshTable(){
        employeeTableView.setItems(EmployeeDatabase.getEmployeeList());
    }



    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        String keyword=searchTF.getText().trim();

        if(keyword.isEmpty()){
            statusLabel.setText("Enter Employee ID or Name to search.");
            showAlert(Alert.AlertType.WARNING,
                    "Search",
                    "Please enter an employee ID or Name.");
            return;
        }

        employeeTableView.setItems(EmployeeDatabase.searchEmployee(keyword));
        statusLabel.setText("Search completed.");
    }



    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
        refreshTable();
        searchTF.clear();
        clearFields();

        employeeTableView.getSelectionModel().clearSelection();
        selectedEmployee=null;

        statusLabel.setText("Employee list refreshed.");
    }



    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {
        clearFields();

        employeeTableView.getSelectionModel().clearSelection();

        selectedEmployee = null;

        statusLabel.setText("Form cleared.");
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

            System.out.println("Logout Successfully.");

            SceneSwitcher.switchScene(
                    actionEvent,
                    "/com.example.welfareassociation/hello-view.fxml"
            );

        }
    }

    @javafx.fxml.FXML
    public void updateButtonOA(ActionEvent actionEvent) {
        if (selectedEmployee == null) {

            statusLabel.setText("No employee selected.");

            showAlert(Alert.AlertType.WARNING,
                    "Update",
                    "Please select an employee from the table.");

            return;
        }

        String name = nameTF.getText().trim();
        String department = departmentComboBox.getValue();
        String phone = phoneTF.getText().trim();
        String email = emailTF.getText().trim();
        String status = statusComboBox.getValue();

        if (name.isEmpty()
                || department == null
                || phone.isEmpty()
                || email.isEmpty()
                || status == null) {

            statusLabel.setText("Please fill up all fields.");

            showAlert(Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please fill up all required fields.");

            return;
        }

        if (!phone.matches("\\d{11}")) {

            showAlert(Alert.AlertType.ERROR,
                    "Invalid Phone",
                    "Phone number must contain exactly 11 digits.");

            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

            showAlert(Alert.AlertType.ERROR,
                    "Invalid Email",
                    "Please enter a valid email address.");

            return;
        }

        EmployeeDatabase.updateEmployee(
                selectedEmployee,
                name,
                department,
                phone,
                email,
                status
        );

        employeeTableView.refresh();

        clearFields();
        employeeTableView.getSelectionModel().clearSelection();
        selectedEmployee=null;

        statusLabel.setText("Employee information updated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Employee information updated successfully.");
    }



    private void clearFields() {

        nameTF.clear();
        phoneTF.clear();
        emailTF.clear();
        searchTF.clear();

        departmentComboBox.getSelectionModel().clearSelection();
        statusComboBox.getSelectionModel().clearSelection();

        statusLabel.setText("");
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