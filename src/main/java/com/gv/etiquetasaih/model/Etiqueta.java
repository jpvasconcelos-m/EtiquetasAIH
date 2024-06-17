package com.gv.etiquetasaih.model;


//Exemplo Etiqueta: 26() 24(Ano) 10190148(DigitoCrescente) 7(DigitoCiclico) -----> 262410190148-7

public record Etiqueta(int unitCode, int year, long increasingDigit, int cyclicDigit) {


    boolean verifCyclic(boolean vc) {
        if (cyclicDigit == 0) {
            System.out.println("DIGITE A ULTIMA AIH IMPRESSA");
        }
        return vc = false;
    }
}