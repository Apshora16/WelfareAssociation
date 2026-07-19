module com.example.welfareassociation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.welfareassociation to javafx.fxml;
    exports com.example.welfareassociation;
}