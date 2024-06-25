module com.gv.etiquetasaih {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;





    requires org.controlsfx.controls;
    requires java.desktop;


    exports com.gv.tagsaih.view;
    opens com.gv.tagsaih.view to javafx.fxml;


}