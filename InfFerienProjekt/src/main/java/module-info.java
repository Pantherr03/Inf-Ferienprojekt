module com.mycompany.infferienprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.infferienprojekt to javafx.fxml;
    exports com.mycompany.infferienprojekt;
}
