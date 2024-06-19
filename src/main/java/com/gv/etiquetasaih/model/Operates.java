package com.gv.etiquetasaih.model;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Operates {
    public static void main(String[] args) {

        Predicate<Etiqueta> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;
        List<Integer> cyclics = Arrays.asList(0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ArrayList<Long> hgvAihs = new ArrayList<>();

        Etiqueta init = new Etiqueta(26, 24, 11028345, 1);
        Etiqueta fin = new Etiqueta(26, 24, 11028350, 6);


        long contador = init.increasingDigit();
        long contador2 = fin.increasingDigit();


             while (contador <= contador2){
                    hgvAihs.add(contador);
                    contador ++;
             }

        boolean c1 = isCyclics.test(init);

       int aihInitCod = (init.unitCode());
        String codeYText = aihInitCod + "";
        int aihYea = init.year();
        String yeaText = aihYea + "";
        /*long aih = init.increasingDigit();
        long aih2 = fin.increasingDigit() ;
        String aihText = aih + "";*/
        int aihCiclic = init.cyclicDigit();
        String cyclicText = aihCiclic + "";
        String aihComp = codeYText + yeaText + aihCiclic;
        System.out.println(aihComp);

        if (c1 == false) {
            hgvAihs.forEach(num -> System.out.println(num));


        } else {
            System.out.println("Digite a ultima  AIH impressa");
        }







    }

}