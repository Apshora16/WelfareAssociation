package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Benefit;
import com.example.welfareassociation.model.BenefitDatabase;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class WelfareBenefits
{
    @javafx.fxml.FXML
    private ListView<Benefit> welfareBenefitsListView;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Label eligibilityLabel;
    @javafx.fxml.FXML
    private Label totalBenefitsLabel;


    @javafx.fxml.FXML
    public void initialize() {

        if (BenefitDatabase.getBenefitList().isEmpty()) {

            BenefitDatabase.addBenefit(
                    new Benefit("Medical Insurance", "Eligible", "Available"));

            BenefitDatabase.addBenefit(
                    new Benefit("Housing Loan", "Eligible", "Available"));

            BenefitDatabase.addBenefit(
                    new Benefit("Education Assistance", "Eligible", "Available"));

            BenefitDatabase.addBenefit(
                    new Benefit("Transport Allowance", "Not Eligible", "Unavailable"));

            BenefitDatabase.addBenefit(
                    new Benefit("Child Care Support", "Eligible", "Available"));
        }

        welfareBenefitsListView.setItems(
                BenefitDatabase.getBenefitList()
        );

        eligibilityLabel.setText("Eligible");

        totalBenefitsLabel.setText(
                String.valueOf(BenefitDatabase.getBenefitList().size())
        );

        statusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void requestBenefitButtonOA(ActionEvent actionEvent) {

        Benefit benefit =
                welfareBenefitsListView.getSelectionModel().getSelectedItem();

        if (benefit == null) {

            statusLabel.setText("Please select a benefit.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "No Selection",
                    "Please select a benefit first."
            );

            return;
        }

        statusLabel.setText("Benefit request submitted.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Request submitted for " + benefit.getBenefitName()
        );
    }


    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {


        welfareBenefitsListView.refresh();

        statusLabel.setText("Benefit list refreshed.");
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