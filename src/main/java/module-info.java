module com.example.test4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.test4 to javafx.fxml;
    exports com.example.test4;
}