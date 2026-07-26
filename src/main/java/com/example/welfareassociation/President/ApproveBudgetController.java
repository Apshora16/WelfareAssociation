package com.example.welfareassociation.President;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ApproveBudgetController
{
    @javafx.fxml.FXML
    private Text approvalStatusText;
    @javafx.fxml.FXML
    private TableView<BudgetProposal,String> budgetProposalListTableView;
    @javafx.fxml.FXML
    private TextArea budgetDetailsTextArea;
    @javafx.fxml.FXML
    private CheckBox noCheckBox;
    @javafx.fxml.FXML
    private CheckBox yesCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRejectButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApproveButton(ActionEvent actionEvent) {
    }
}