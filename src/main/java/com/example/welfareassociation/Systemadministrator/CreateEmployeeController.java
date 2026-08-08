package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Employee;
import com.example.welfareassociation.model.EmployeeDatabase;
import com.example.welfareassociation.Utility.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreateEmployeeController
{
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField idNumberTF;

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
        statusComboBox.setItems(FXCollections.observableArrayList( "Active",
                "Inactive"
        ));
        statusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void clearFormButtonOA(ActionEvent actionEvent) {
        clearFields();

        statusLabel.setText("Form cleared.");


    }

    private void clearFields(){
        nameTF.clear();
        idNumberTF.clear();
        phoneTF.clear();
        emailTF.clear();

        departmentComboBox.getSelectionModel().clearSelection();
        statusComboBox.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void createAccountButtonOA(ActionEvent actionEvent) {
        String name= nameTF.getText().trim();
        String id= idNumberTF.getText().trim();
        String department= departmentComboBox.getValue();
        String phone=phoneTF.getText().trim();
        String email=emailTF.getText().trim();
        String status= statusComboBox.getValue();
        if(name.isEmpty() ||
                id.isEmpty() ||
                department==null ||
                phone.isEmpty() ||
                email.isEmpty() ||
                status == null) {

            statusLabel.setText("Please fill up all fields");
            showAlert(Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please fill up all required fields");

            return;
        }

        if(!id.matches("\\d+")){
            statusLabel.setText("Invalid ID");

            showAlert(Alert.AlertType.ERROR,
                    "Invalid ID",
                    "ID Number must contain only digits.");
            return;
        }

        if(!phone.matches("\\d{11}")){
            statusLabel.setText("Invalid phone number");
            showAlert(Alert.AlertType.ERROR,
                    "Invalid phone number",
                    "Phone number must contain exactly 11 digits.");
            return;
        }

        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            statusLabel.setText("Invalid email address.");
            showAlert(Alert.AlertType.ERROR,
                    "Invalid Email",
                    "Please enter a valid email address");
            return;

        }

        if (EmployeeDatabase.findEmployeeByID(id) != null) {

            statusLabel.setText("Employee ID already exists.");

            showAlert(Alert.AlertType.ERROR,
                    "Duplicate Employee ID",
                    "An employee with this ID already exists.");

            return;
        }

        Employee employee = new Employee(
                id,name,
                department,phone,
                email,status,"Employee"
        );


        EmployeeDatabase.addEmployee(employee);
        System.out.println(EmployeeDatabase.getEmployeeList());


        statusLabel.setText("Employee account created successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Employee account has been created successfully.");
        clearFields();
        statusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(
                actionEvent,"/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml");

    }

    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");

        if(alert.showAndWait().orElse(ButtonType.CANCEL)==ButtonType.OK){
            // TODO:
            // Load login.fxml
            System.out.println("Logout Successfully.");

        }

    }

    private void showAlert(Alert.AlertType type,
                           String title,
                           String message){
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}