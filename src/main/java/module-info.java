module com.gv.etiquetasaih {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;





    requires org.controlsfx.controls;


    exports com.gv.etiquetasaih.view;
    opens com.gv.etiquetasaih.view to javafx.fxml;


}