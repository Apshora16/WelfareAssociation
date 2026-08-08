package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoanDatabase {

    private static final ObservableList<Loan> loanList =
            FXCollections.observableArrayList();

    public static ObservableList<Loan> getLoanList() {
        return loanList;
    }

    public static void addLoan(Loan loan) {
        loanList.add(loan);
    }
}
