package com.example.welfareassociation.Employee;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.Attendance;
import com.example.welfareassociation.model.AttendanceDatabase;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class AttendanceRecord
{
    @javafx.fxml.FXML
    private TableView<Attendance> attendanceTableView;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private Label summaryLabel;
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> statusColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> hoursColumn;
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> checkInColumn;
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<Attendance,String> checkOutColumn;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {

        dateColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDate()));

        checkInColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCheckIn()));

        checkOutColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCheckOut()));

        statusColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStatus()));

        hoursColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getHours()));

        if (AttendanceDatabase.getAttendanceList().isEmpty()) {

            AttendanceDatabase.addAttendance(
                    new Attendance(
                            "01-08-2026",
                            "09:00 AM",
                            "05:00 PM",
                            "Present",
                            "8"
                    )
            );

            AttendanceDatabase.addAttendance(
                    new Attendance(
                            "02-08-2026",
                            "09:10 AM",
                            "05:00 PM",
                            "Late",
                            "7.8"
                    )
            );

            AttendanceDatabase.addAttendance(
                    new Attendance(
                            "03-08-2026",
                            "-",
                            "-",
                            "Absent",
                            "0"
                    )
            );
        }

        attendanceTableView.setItems(
                AttendanceDatabase.getAttendanceList()
        );

        summaryLabel.setText("Total Hours This Month : 15.8");
        statusLabel.setText("");
    }


    @javafx.fxml.FXML
    public void correctionButtonOA(ActionEvent actionEvent) {

        statusLabel.setText("Correction request submitted.");

        showAlert(
                Alert.AlertType.INFORMATION,
                "Success",
                "Attendance correction request submitted."
        );
    }

    @javafx.fxml.FXML
    public void viewButtonOA(ActionEvent actionEvent) {

        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();

        if (from == null || to == null) {

            statusLabel.setText("Please select both dates.");

            showAlert(
                    Alert.AlertType.WARNING,
                    "Missing Information",
                    "Please select both From and To dates."
            );
            return;
        }

        attendanceTableView.refresh();

        statusLabel.setText("Attendance loaded.");
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