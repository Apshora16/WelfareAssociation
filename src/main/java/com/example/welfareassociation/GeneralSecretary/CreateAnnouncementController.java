package com.example.welfareassociation.GeneralSecretary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateAnnouncementController {

    @FXML
    private TextField announcementTitleTextField;

    @FXML
    private TextArea announcementDetailsTextArea;

    @FXML
    private ComboBox<String> targetAudienceComboBox;

    @FXML
    private TextField attachmentTextField;

    @FXML
    private TextArea announcementPreviewTextArea;

    @FXML
    private Button handlePreview;

    @FXML
    private Button handlePublish;

    @FXML
    private Button handleClear;

    @FXML
    private Button handleCancel;

    @FXML
    private Button handleLogout;

    @FXML
    private Button browseButton;


    @FXML
    public void initialize() {

        targetAudienceComboBox.getItems().addAll(
                "All Employees",
                "General Secretary",
                "HR Manager",
                "Welfare Officer"
        );

        handlePreview.setOnAction(event -> previewAnnouncement());

        handlePublish.setOnAction(event -> publishAnnouncement());

        handleClear.setOnAction(event -> clearFields());

        handleCancel.setOnAction(event -> cancel());

        handleLogout.setOnAction(event -> logout());

        browseButton.setOnAction(event -> browseAttachment());
    }


    private void previewAnnouncement() {

        String title = announcementTitleTextField.getText();
        String details = announcementDetailsTextArea.getText();
        String audience = targetAudienceComboBox.getValue();
        String attachment = attachmentTextField.getText();

        announcementPreviewTextArea.setText(
                "Title: " + title +
                        "\n\nDetails: " + details +
                        "\n\nTarget Audience: " + audience +
                        "\nAttachment: " + attachment
        );
    }


    private void publishAnnouncement() {

        Announcement announcement = new Announcement();

        announcement.setAnnouncementId("ANN-001");

        announcement.setTitle(
                announcementTitleTextField.getText()
        );

        announcement.setDetails(
                announcementDetailsTextArea.getText()
        );

        announcement.setTargetAudience(
                targetAudienceComboBox.getValue()
        );

        announcement.setAttachment(
                attachmentTextField.getText()
        );

        announcement.setPublishDate("Today");

        announcement.setStatus("Published");

        System.out.println("Announcement published successfully.");
    }


    private void clearFields() {

        announcementTitleTextField.clear();
        announcementDetailsTextArea.clear();
        attachmentTextField.clear();
        announcementPreviewTextArea.clear();
        targetAudienceComboBox.setValue(null);
    }


    private void cancel() {

        clearFields();

        System.out.println("Announcement creation cancelled.");
    }


    private void logout() {

        System.out.println("Logout clicked.");
    }


    private void browseAttachment() {

        System.out.println("Browse attachment clicked.");
    }
}