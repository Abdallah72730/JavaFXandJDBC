module org.example.javafxandjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens org.example.javafxandjdbc to javafx.fxml;
    exports org.example.javafxandjdbc;
}