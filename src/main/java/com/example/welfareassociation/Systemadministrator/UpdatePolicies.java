package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Policy;
import com.example.welfareassociation.model.PolicyDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class UpdatePolicies
{
    @javafx.fxml.FXML
    private ComboBox<String> policyStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker effectiveDatePicker;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextArea policyDocumentTextArea;

    @javafx.fxml.FXML
    public void initialize() {

        policyStatusComboBox.setItems(
                FXCollections.observableArrayList(
                        "Draft",
                        "Pending",
                        "Approved",
                        "Rejected"
                ));

        statusLabel.setText("");

        policyDocumentTextArea.setText("");

        loadPolicy();
    }

    private void loadPolicy() {

        if (PolicyDatabase.getPolicyList().isEmpty()) {

            PolicyDatabase.addPolicy(
                    new Policy(
                            "Employee Welfare Policy Version 1.0",
                            "Approved",
                            "2026-08-01"
                    )
            );
        }

        Policy policy = PolicyDatabase
                .getPolicyList()
                .get(0);

        policyDocumentTextArea.setText(
                policy.getDocument());

        policyStatusComboBox.setValue(
                policy.getStatus());

        effectiveDatePicker.setValue(
                java.time.LocalDate.parse(
                        policy.getEffectiveData()));
    }



    @javafx.fxml.FXML
    public void generateButtonOA(ActionEvent actionEvent) {

        if (policyDocumentTextArea.getText().trim().isEmpty()) {

            showAlert(Alert.AlertType.WARNING,
                    "Generate Report",
                    "No policy available.");

            return;
        }

        String report =
                "===== POLICY REPORT =====\n\n"
                        + "Status : "
                        + policyStatusComboBox.getValue()
                        + "\n\nEffective Date : "
                        + effectiveDatePicker.getValue()
                        + "\n\nPolicy Document\n\n"
                        + policyDocumentTextArea.getText();

        policyDocumentTextArea.setText(report);

        statusLabel.setText("Policy report generated.");

        showAlert(Alert.AlertType.INFORMATION,
                "Report",
                "Policy report generated successfully.");
    }



    @javafx.fxml.FXML
    public void rejectedButtonOA(ActionEvent actionEvent) {

        policyStatusComboBox.setValue("Rejected");

        statusLabel.setText("Policy marked as Rejected.");

        showAlert(Alert.AlertType.INFORMATION,
                "Policy",
                "Policy status changed to Rejected.");
    }



    @javafx.fxml.FXML
    public void backToDashboardButtonOA(ActionEvent actionEvent) {

        SceneSwitcher.switchScene(
                actionEvent,
                "/com.example.welfareassociation/Systemadministrator/SystemAdministratorDashboard.fxml"
        );
    }



    @javafx.fxml.FXML
    public void applyChangesButtonOA(ActionEvent actionEvent) {


        String document = policyDocumentTextArea.getText().trim();
        String status = policyStatusComboBox.getValue();

        if (document.isEmpty()
                || status == null
                || effectiveDatePicker.getValue() == null) {

            statusLabel.setText("Please complete all fields.");

            showAlert(Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please complete all fields.");

            return;
        }

        Policy policy = PolicyDatabase.getPolicyList().get(0);

        policy.setDocument(document);
        policy.setStatus(status);
        policy.setEffectiveData(
                effectiveDatePicker.getValue().toString());

        statusLabel.setText("Policy updated successfully.");

        showAlert(Alert.AlertType.INFORMATION,
                "Success",
                "Policy updated successfully.");
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