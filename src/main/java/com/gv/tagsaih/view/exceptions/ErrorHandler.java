package com.gv.tagsaih.view.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ErrorHandler {
    public static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Uma exceção ocorreu");
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void showTagEndsWithZeroPopup() {
        // Cria um novo TextField para o popup
        TextField newTextField = new TextField();
        newTextField.setPromptText("Informe a última etiqueta impressa");

        // Cria o alerta
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Etiqueta Inválida");
        alert.setHeaderText("A etiqueta termina com zero.");
        alert.setContentText("Por favor, informe a última etiqueta impressa:");

        // Adiciona o TextField ao diálogo
        alert.getDialogPane().setContent(newTextField);

        // Exibe o alerta e espera pela resposta do usuário
        alert.showAndWait();
    }
}
