package com.gv.tagsaih.view.exceptions;

public class TagEndsWithZeroException extends RuntimeException {

    public TagEndsWithZeroException(){
        super("A Etiqueta termina em zero, informe a ultima AIH impressa.");
    }
    public TagEndsWithZeroException(String message){
        super(message);
    }


}
