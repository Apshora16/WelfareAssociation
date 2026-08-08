package com.example.welfareassociation.GeneralSecretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ScheduleMeetingController {

    @FXML
    private TextField meetingTitleTextField;

    @FXML
    private DatePicker meetingDateDatePicker;

    @FXML
    private TextField meetingTimeTextField;

    @FXML
    private ComboBox<String> participantsComboBox;

    @FXML
    private TextArea agendaTextArea;


    @FXML
    public void initialize() {

        participantsComboBox.getItems().addAll(
                "General Secretary",
                "HR Manager",
                "Welfare Officer",
                "Department Head"
        );
    }


    @FXML
    public void handleSchedule(ActionEvent actionEvent) {

        ScheduleMeeting meeting = new ScheduleMeeting();

        meeting.setMeetingTitle(
                meetingTitleTextField.getText()
        );

        meeting.setMeetingDate(
                meetingDateDatePicker.getValue()
        );

        meeting.setMeetingTime(
                meetingTimeTextField.getText()
        );

        meeting.setParticipants(
                participantsComboBox.getValue()
        );

        meeting.setAgenda(
                agendaTextArea.getText()
        );

        System.out.println("Meeting scheduled successfully.");
    }


    @FXML
    public void handleClear(ActionEvent actionEvent) {

        meetingTitleTextField.clear();
        meetingDateDatePicker.setValue(null);
        meetingTimeTextField.clear();
        participantsComboBox.setValue(null);
        agendaTextArea.clear();
    }


    @FXML
    public void handleCancel(ActionEvent actionEvent) {

        meetingTitleTextField.clear();
        meetingDateDatePicker.setValue(null);
        meetingTimeTextField.clear();
        participantsComboBox.setValue(null);
        agendaTextArea.clear();

        System.out.println("Meeting scheduling cancelled.");
    }


    @FXML
    public void handleLogout(ActionEvent actionEvent) {

        System.out.println("Logout clicked.");
    }
}