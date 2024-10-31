package com.gv.tagsaih.view.exceptions;

import com.gv.tagsaih.view.button.ButtonAnimator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ErrorHandler {
    public static void showError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Um erro ocorreu.");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void showMessageDialog(String title, String message) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(null);

        // Configurando o layout do dialog
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 20));

        // Adicionando um label com a mensagem
        Label messageLabel = new Label(message);
        messageLabel.setWrapText(true); // Permite que a mensagem quebre a linha
        grid.add(messageLabel, 0, 0);

        // Estilizando o botão OK
        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(okButtonType);

        // Adicionando uma estilização ao botão
        Button okButton = (Button) dialog.getDialogPane().lookupButton(okButtonType);
        okButton.setStyle("-fx-background-color: #2ecd70; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        ButtonAnimator.addButtonAnimations(okButton);

        dialog.getDialogPane().setContent(grid);

        // Mostrando o diálogo
        dialog.showAndWait();
    }
}
