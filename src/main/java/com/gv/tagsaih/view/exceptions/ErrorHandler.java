package com.gv.tagsaih.view.exceptions;

import javafx.scene.control.Alert;

public class ErrorHandler {
    public static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Um erro ocorreu.");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
