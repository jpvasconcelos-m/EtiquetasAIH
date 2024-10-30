package com.gv.tagsaih.view.Exceptions;

import javafx.scene.control.Alert;

public class ErrorHandler {
    public static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Uma exceção ocorreu");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
