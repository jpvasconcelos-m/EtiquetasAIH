package com.gv.tagsaih.view.exceptions;

public class IncorrectTagSizeException extends RuntimeException {

    public IncorrectTagSizeException(){
        super("Etiqueta não contém a quantidade correta de dígitos!");
    } public IncorrectTagSizeException(String msg){
        super(msg);
    }
}
