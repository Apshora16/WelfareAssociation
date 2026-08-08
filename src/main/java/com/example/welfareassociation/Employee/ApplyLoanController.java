package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Loan;
import com.example.welfareassociation.model.LoanDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ApplyLoanController
{
    @javafx.fxml.FXML
    private TextField loanAmountTF;
    @javafx.fxml.FXML
    private ComboBox<String> repaymentPeriodComboBox;
    @javafx.fxml.FXML
    private TextField documentsTF;
    @javafx.fxml.FXML
    private TextArea purposeTA;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        repaymentPeriodComboBox.setItems(
                FXCollections.observableArrayList(
                        "6 Months",
                        "12 Months",
                        "18 Months",
                        "24 Months",
                        "36 Months"
                )
        );

        repaymentPeriodComboBox.setValue(null);
        loanAmountTF.clear();
        purposeTA.clear();
        documentsTF.clear();

        statusLabel.setText("");
    }



    @javafx.fxml.FXML
    public void submitApplicationButtonOA(ActionEvent actionEvent) {

        String amount = loanAmountTF.getText().trim();
        String purpose = purposeTA.getText().trim();
        String period = repaymentPeriodComboBox.getValue();
        String document = documentsTF.getText().trim();

        if (amount.isEmpty()
                || purpose.isEmpty()
                || period == null
                || document.isEmpty()) {

            statusLabel.setText("Please complete all fields.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields."
            );

            return;
        }

        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {

            statusLabel.setText("Invalid loan amount.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Invalid Amount",
                    "Please enter a valid loan amount."
            );

            return;
        }

        Loan loan = new Loan(
                amount,
                purpose,
                period,
                document,
                "Pending"
        );

        LoanDatabase.addLoan(loan);

        statusLabel.setText("Loan application submitted.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Loan application submitted successfully."
        );

        loanAmountTF.clear();
        purposeTA.clear();
        repaymentPeriodComboBox.setValue(null);
        documentsTF.clear();
    }



    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {

        loanAmountTF.clear();
        purposeTA.clear();
        repaymentPeriodComboBox.setValue(null);
        documentsTF.clear();

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

    @javafx.fxml.FXML
    public void browseButtonOA(ActionEvent actionEvent) {

        documentsTF.setText("C:\\Documents\\LoanDocument.pdf");

        statusLabel.setText("Document selected.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Browse",
                "Document selected successfully."
        );
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