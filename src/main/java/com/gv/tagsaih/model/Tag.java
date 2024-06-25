package com.gv.tagsaih.model;


//Exemplo Etiqueta: 26() 24(Ano) 10190148(DigitoCrescente) 7(DigitoCiclico) -----> 262410190148-7


public record Tag(int unitCode, int year, long increasingDigit, int cyclicDigit) {


}