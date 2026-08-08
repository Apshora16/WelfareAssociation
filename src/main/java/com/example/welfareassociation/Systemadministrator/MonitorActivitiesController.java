package com.example.welfareassociation.Systemadministrator;

import com.example.welfareassociation.Utility.SceneSwitcher;
import com.example.welfareassociation.model.ActivityDatabase;
import com.example.welfareassociation.model.ActivityLog;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MonitorActivitiesController
{
    @javafx.fxml.FXML
    private ListView<String> transactionListView;
    @javafx.fxml.FXML
    private ListView<String> activityLogsListView;
    @javafx.fxml.FXML
    private Label completeLabel;
    @javafx.fxml.FXML
    private ListView<String> abnormalActivitiesListView;
    @javafx.fxml.FXML
    private TextArea monitoringTextArea;


    @javafx.fxml.FXML
    public void initialize() {
        completeLabel.setText("");
        loadMonitoringData();
    }

    private void loadMonitoringData(){
        if (ActivityDatabase.getActivityList().isEmpty()){

            ActivityDatabase.addActivity(new ActivityLog("Employee Account Created.",
                    "Create Employee.","No Abnormal Activity."));

            ActivityDatabase.addActivity(new ActivityLog("Employee Information Updated",
                    "Maintain Employee Database","Invalid Login Attempt."));

            ActivityDatabase.addActivity(new ActivityLog("Role Updated",
                    "Manage User Roles","No Abnormal Activity."));

            ActivityDatabase.addActivity(new ActivityLog("Backup Completed",
                    "Backup Database","Unauthorized Access."));
        }

        activityLogsListView.getItems().clear();
        transactionListView.getItems().clear();
        abnormalActivitiesListView.getItems().clear();

        monitoringTextArea.clear();

        for (ActivityLog activity : ActivityDatabase.getActivityList()) {

            activityLogsListView.getItems().add(activity.getActivity());

            transactionListView.getItems().add(activity.getTransaction());

            abnormalActivitiesListView.getItems().add(activity.getAbnormalActivity());

            monitoringTextArea.appendText(
                    "Activity : " + activity.getActivity()
                            + "\nTransaction : " + activity.getTransaction()
                            + "\nAbnormal Activity : " + activity.getAbnormalActivity()
                            + "\n-----------------------------------------\n"
            );

        }
    }


    @javafx.fxml.FXML
    public void startMonitoringButtonOA(ActionEvent actionEvent) {
        loadMonitoringData();

        completeLabel.setText("Monitoring Started Successfully.");

        monitoringTextArea.setEditable(false);

        showAlert(Alert.AlertType.INFORMATION,
                "Monitoring",
                "System monitoring has started successfully.");
    }


    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {

        loadMonitoringData();

        completeLabel.setText("Monitoring data refreshed.");

        showAlert(Alert.AlertType.INFORMATION,
                "Refresh",
                "Monitoring data has been refreshed.");
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
    public void exportReportButtonOA(ActionEvent actionEvent) {

        StringBuilder report = new StringBuilder();
        report.append("=====SYSTEM MONITORING REPORT====\n\n");

        for(ActivityLog activity: ActivityDatabase.getActivityList()) {

            report.append("Activity:").append(activity.getActivity())
                    .append("\n");

            report.append("Abnormal Activity: ")
                    .append(activity.getAbnormalActivity())
                    .append("\n");

            report.append("Transaction: ")
                    .append(activity.getTransaction())
                    .append("\n");

            report.append("-------------------------\n");
        }

            monitoringTextArea.setText(report.toString());
            completeLabel.setText("Report Generated.");

            showAlert(Alert.AlertType.INFORMATION,
                    "Export Report",
                    "Monitoring report generated successfully.");






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