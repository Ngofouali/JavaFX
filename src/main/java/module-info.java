module com.icodi.tpjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.icodi.tpjavafx to javafx.fxml;
    exports com.icodi.tpjavafx;
    exports com.icodi.tpjavafx.model;
    exports com.icodi.tpjavafx.controller;
    opens com.icodi.tpjavafx.model to javafx.fxml;
    opens com.icodi.tpjavafx.controller;
}