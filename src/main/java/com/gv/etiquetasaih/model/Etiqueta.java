package com.gv.etiquetasaih.model;


//Exemplo Etiqueta: 26() 24(Ano) 10190148(DigitoCrescente) 7(DigitoCiclico) -----> 262410190148-7


public record Etiqueta(int unitCode, int year, long increasingDigit, int cyclicDigit) {


}