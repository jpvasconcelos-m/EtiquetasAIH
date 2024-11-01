package com.gv.tagsaih.view.elements;

import com.gv.tagsaih.model.PdfGenerator;
import com.gv.tagsaih.model.utils.Logger;
import com.gv.tagsaih.model.utils.StringFormatter;
import com.gv.tagsaih.view.button.ButtonAnimator;
import com.gv.tagsaih.view.exceptions.ErrorHandler;
import com.gv.tagsaih.view.exceptions.TagEndsWithZeroException;
import com.gv.tagsaih.view.exceptions.IncorrectTagSizeException;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.util.function.UnaryOperator;

import static com.gv.tagsaih.view.button.ButtonAnimator.addButtonAnimations;

public class InputArea {

    static StringFormatter stringFormatter = new StringFormatter();


    public AnchorPane createInputArea() {
        AnchorPane bottomPane = new AnchorPane();
        bottomPane.setPrefSize(600, 200);

        TextField field1 = createNumericTextField("Etiqueta Inicial", 6);
        TextField field2 = createNumericTextField("Etiqueta Final", 52);
        TextField field3 = createNumericTextField("Última Etiqueta Impressa", 20, 26);
        TextField campoNumero = createNumericTextField("Quantidade de Etiquetas", 52);
        campoNumero.setVisible(false); // Inicialmente invisível




        ImageView imageView1 = createImageView("images.png", 220, 6);
        ImageView imageView2 = createImageView("images.png", 220, 50);
        ImageView imageView3 = createImageView("clock.png", 95, -15);

        CheckBox checkBox = new CheckBox("Gerar usando Etq. inicial e Quantidade de etiquetas");
        checkBox.setLayoutX(210);
        checkBox.setLayoutY(100);
        configureCheckBox(checkBox, field2, campoNumero, imageView2);

        HBox footer = Footer.createFooter();
        AnchorPane.setBottomAnchor(footer, 0.0);
        AnchorPane.setLeftAnchor(footer, 0.0);
        AnchorPane.setRightAnchor(footer, 0.0);
        bottomPane.getChildren().add(footer);

        Button gerarButton = new Button("GERAR");
        configureGenerateButton(gerarButton, field1, field2, field3,campoNumero);

        bottomPane.getChildren().addAll(field1, field2,field3, campoNumero, gerarButton, imageView1, imageView2,imageView3, checkBox);
        return bottomPane;
    }

    private TextField createTextField(String promptText, double layoutY) {
        TextField textField = new TextField();
        textField.setPrefHeight(37);
        textField.setPrefWidth(176);
        textField.setLayoutX(250);
        textField.setLayoutY(layoutY-10);
        textField.setPromptText(promptText);
        textField.getStyleClass().add("no-border");
        return textField;
    }  private TextField createTextField(String promptText,double layoutX, double layoutY) {
        TextField textField = new TextField();
        textField.setPrefHeight(37);
        textField.setPrefWidth(176);
        textField.setLayoutX(20);
        textField.setLayoutY(layoutY-10);
        textField.setPromptText(promptText);
        textField.getStyleClass().add("no-border");
        return textField;
    }

    private ImageView createImageView(String imagePath, double layoutX, double layoutY) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitHeight(25);
        imageView.setFitWidth(22);
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        return imageView;
    }

    private void configureCheckBox(CheckBox checkBox, TextField campo2, TextField campoNumero, ImageView imageView) {
        checkBox.setOnAction(event -> {
            boolean isChecked = checkBox.isSelected();
            campo2.setVisible(!isChecked);
            campoNumero.setVisible(isChecked);
            if (isChecked) {
                imageView.setImage(new Image(getClass().getResourceAsStream("/8631648.png")));
                campoNumero.setPromptText("Quantidade de Etiquetas");
            } else {
                imageView.setImage(new Image(getClass().getResourceAsStream("/images.png")));
                campo2.clear();
            }
        });
    }

    private void configureGenerateButton(Button button, TextField field1, TextField field2,TextField field3, TextField numberField) {
        Logger logger = new Logger();
        button.setLayoutX(280);
        button.setLayoutY(130);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-background-color: #2ecd70; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        field3.setText(logger.getLastEntry());
        addButtonAnimations(button);

        button.setOnAction(event -> {


            String field1Text = field1.getText().replace("-","").replace(" ", "");
            String field2Text = field2.isVisible() ? field2.getText().replace("-","").replace(" ","") : numberField.getText();
            String field3Text = field3.getText().replace("-","");



            boolean isField2Incorrect = field2Text.length()!=13 && !numberField.isVisible();
            boolean isField3Incorrect = field3Text.length()!=13  || field3Text.isBlank();


            System.out.println("Campo 1: " + field1Text);
            System.out.println("Campo 2: " + field2Text);
            try {

                //Para Campo 2 Com Etiqueta Final:
                if(field1Text.length()!=13||isField2Incorrect){
                    System.out.println("oi");
                    throw new IncorrectTagSizeException();
                }
                if (field1Text.endsWith("0") && isField3Incorrect) {
                    throw new TagEndsWithZeroException();
                }
                //Para campo 2 com quantidade de etiquetas:
                else if (numberField.isVisible()){
                    //--Campo 3 em branco e campo 1 termina em 0 --> Joga exceção
                    if(field3Text.isBlank()&&field1Text.endsWith("0")){
                        field1Text.replace("-","");
                        throw new TagEndsWithZeroException();
                    //--Campo 3 no tamanho incoreto e campo 1 termina em zero     --> Joga exceção
                    }  if(field3Text.length()!=13&&field1Text.endsWith("0")){
                        field1Text.replace("-","");
                        throw new IncorrectTagSizeException();
                    }
                        //--Campo 3 no tamanho certo e campo 1 termina em zero --> Procede
                    else if (field3Text.length()==13 && field1Text.endsWith("0")) {
                        field1Text.replace("-","");
                        field3Text.replace("-","");
                        PdfGenerator.generatePdfFile(stringFormatter.formatString(field3Text),stringFormatter.formatString(field1Text),Integer.parseInt(field2Text));
                    } else {
                        field1Text.replace("-","");
                        PdfGenerator.generatePdfFile(stringFormatter.formatString(field1Text), Integer.parseInt(field2Text));

                    }
                }
                else if(field1Text.endsWith("0")&&!isField3Incorrect){
                    try {
                        PdfGenerator.generatePdfFile(stringFormatter.formatString(field3Text),stringFormatter.formatString(field1Text),stringFormatter.formatString(field2Text));
                    } catch (Exception e) {
                        ErrorHandler.showMessageDialog("Erro",e.getMessage());
                    }
                }
                else {
                    try {
                        PdfGenerator.generatePdfFile(stringFormatter.formatString(field1Text), stringFormatter.formatString(field2Text));

                    } catch (Exception e) {
                        ErrorHandler.showMessageDialog("Erro", e.getMessage());
                    }
                }
            }
            catch (IncorrectTagSizeException e){
                ErrorHandler.showMessageDialog("Erro",e.getMessage());
            }


            catch (TagEndsWithZeroException e) {
                // Aqui chamamos o showInputDialog se a exceção for de TagEndsWithZeroException
                ErrorHandler.showMessageDialog("Informações insuficientes.", "Informe a última AIH impressa");
            }

            field3.setText(logger.getLastEntry());
        });

        PauseTransition pause = new PauseTransition(Duration.millis(1));
        pause.setOnFinished(event -> button.requestFocus());
        pause.play();
    }
    private TextField createNumericTextField(String promptText, double layoutX, double layoutY) {
        TextField textField = createTextField(promptText, layoutX, layoutY);
        setNumericTextFormatter(textField);
        return textField;
    }
    private void setNumericTextFormatter(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (change.getControlNewText().isEmpty() || change.getControlText().isEmpty()) {
                return change; // Permite a remoção ou colagem
            }

            // Permite apenas números e hífens
            String newText = change.getControlNewText();
            if (newText.matches("[\\d-]*")) {
                return change; // Permite a mudança
            }

            return null; // Ignora a mudança se não for numérico ou hífen
        };

        textField.setTextFormatter(new TextFormatter<>(filter));

        // Adiciona listener para impedir entrada de letras
        textField.setOnKeyTyped(event -> {
            if (!Character.isDigit(event.getCharacter().charAt(0)) && !event.getCharacter().equals("-")) {
                event.consume(); // Impede a entrada de caracteres não numéricos
            }
        });
    }
    private TextField createNumericTextField(String promptText, double layoutY) {
        TextField textField = createTextField(promptText, layoutY);
        setNumericTextFormatter(textField);
        return textField;
    }


}
