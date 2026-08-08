package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Profile;
import com.example.welfareassociation.model.ProfileDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MyProfile
{
    @javafx.fxml.FXML
    private TextField fullNameTF;
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private Label employeeIdLabel;
    @javafx.fxml.FXML
    private ComboBox<String> departmentComboBox;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        departmentComboBox.setItems(
                FXCollections.observableArrayList(
                        "Production",
                        "HR",
                        "Account",
                        "IT",
                        "Marketing"
                )
        );

        statusLabel.setText("");
        loadProfile();
    }

    private void loadProfile() {

        if (ProfileDatabase.getProfileList().isEmpty()) {

            ProfileDatabase.addProfile(

                    new Profile(

                            "0001",
                            "Mike",
                            "HR",
                            "0123457899",
                            "mike@gmail.com"

                    )
            );
        }

        Profile profile =
                ProfileDatabase.getProfileList().get(0);

        employeeIdLabel.setText(
                profile.getEmployeeId());

        fullNameTF.setText(
                profile.getFullName());

        departmentComboBox.setValue(
                profile.getDepartment());

        phoneTF.setText(
                profile.getPhone());

        emailTF.setText(
                profile.getEmail());
    }

    @javafx.fxml.FXML
    public void updateProfileButtonOA(ActionEvent actionEvent) {

        String name = fullNameTF.getText().trim();
        String department = departmentComboBox.getValue();
        String phone = phoneTF.getText().trim();
        String email = emailTF.getText().trim();

        if (name.isEmpty()
                || department == null
                || phone.isEmpty()
                || email.isEmpty()) {

            statusLabel.setText("Please complete all fields.");

            showAlert(Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields.");

            return;
        }

        Profile profile = ProfileDatabase.getProfileList().get(0);

        profile.setFullName(name);
        profile.setDepartment(department);
        profile.setPhone(phone);
        profile.setEmail(email);

        statusLabel.setText("Profile updated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Profile updated successfully.");
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {

        fullNameTF.clear();
        departmentComboBox.setValue(null);
        phoneTF.clear();
        emailTF.clear();

        statusLabel.setText("Form cleared.");
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/com.example.welfareassociation/Employee/EmployeeDashboard.fxml"
        );
    }

    @javafx.fxml.FXML
    public void logoutButtonOA(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().orElse(ButtonType.CANCEL)
                == ButtonType.OK) {

            System.out.println("Logout Successfully.");

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