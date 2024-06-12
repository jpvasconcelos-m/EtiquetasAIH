module com.gv.etiquetasaih {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;





    requires org.controlsfx.controls;
    requires java.desktop;


    exports com.gv.etiquetasaih.view;
    opens com.gv.etiquetasaih.view to javafx.fxml;


}