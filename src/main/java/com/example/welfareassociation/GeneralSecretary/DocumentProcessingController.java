package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DocumentProcessingController {

    @FXML
    private ComboBox<String> documentComboBox;

    @FXML
    private TextField documentOwnerTextField;

    @FXML
    private TextArea documentDetailsTextArea;

    @FXML
    private RadioButton approveRadioButton;

    @FXML
    private RadioButton rejectRadioButton;

    @FXML
    private TextArea remarksTextArea;


    @FXML
    public void initialize() {

        documentComboBox.getItems().addAll(
                "Welfare Application",
                "Employee Record",
                "Official Notice",
                "Meeting Document"
        );
    }


    @FXML
    public void handleProcess(ActionEvent actionEvent) {

        String document = documentComboBox.getValue();

        if (document == null) {
            System.out.println("Please select a document.");
            return;
        }

        if (approveRadioButton.isSelected()) {
            remarksTextArea.setText("Document approved.");
        }
        else if (rejectRadioButton.isSelected()) {
            remarksTextArea.setText("Document rejected.");
        }
        else {
            remarksTextArea.setText("Please select Approve or Reject.");
        }
    }


    @FXML
    public void handleSave(ActionEvent actionEvent) {

        DocumentProcessing documentProcessing =
                new DocumentProcessing();

        documentProcessing.setDocument(
                documentComboBox.getValue()
        );

        documentProcessing.setDocumentOwner(
                documentOwnerTextField.getText()
        );

        documentProcessing.setDocumentDetails(
                documentDetailsTextArea.getText()
        );

        if (approveRadioButton.isSelected()) {
            documentProcessing.setDecision("Approved");
        }
        else if (rejectRadioButton.isSelected()) {
            documentProcessing.setDecision("Rejected");
        }
        else {
            documentProcessing.setDecision("Not Decided");
        }

        documentProcessing.setRemarks(
                remarksTextArea.getText()
        );

        System.out.println("Document processing record saved.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        documentComboBox.setValue(null);
        documentOwnerTextField.clear();
        documentDetailsTextArea.clear();
        remarksTextArea.clear();

        approveRadioButton.setSelected(false);
        rejectRadioButton.setSelected(false);
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        documentComboBox.setValue(null);
        documentOwnerTextField.clear();
        documentDetailsTextArea.clear();
        remarksTextArea.clear();

        approveRadioButton.setSelected(false);
        rejectRadioButton.setSelected(false);

        System.out.println("Operation cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}