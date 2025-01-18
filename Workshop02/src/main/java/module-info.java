module com.workshop.workshop02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.workshop.workshop02 to javafx.fxml;
    exports com.workshop.workshop02;
    exports com.workshop.workshop02.controller;
    opens com.workshop.workshop02.controller to javafx.fxml;
}