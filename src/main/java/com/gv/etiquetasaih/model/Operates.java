package com.gv.etiquetasaih.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Operates {
    public static void main(String[] args) throws Exception {

        //creation of collections to manipulate the "Etiqueta" object
        Predicate<Etiqueta> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;
        List<Integer> cyclics = Arrays.asList(0,0,1,2,3,4,5,6,7,8,9);
        ArrayList<Long> hgvAihsLong = new ArrayList<>();
        ArrayList<String> hgvAih = new ArrayList<>();
        LinkedList<Integer> circleList = new LinkedList<>();

        while(circleList.size() < 11){
            cyclics.forEach(num -> {
                try {
                    circleList.add(num);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println(circleList.toString());

        Etiqueta init = new Etiqueta(26, 24, 11028345, 1);
        Etiqueta fin = new Etiqueta(26, 24, 11028350, 6);
        int aihInitCod = (init.unitCode());
        String codeYText = aihInitCod + "";
        int aihYea = init.year();
        String yeaText = aihYea + "";

        boolean c1 = isCyclics.test(init);

        //Manipulation of data received by the user
        long contador = init.increasingDigit();
        long contador2 = fin.increasingDigit();

        while (contador <= contador2){
                 hgvAihsLong.add(contador);
                 String strCont = Long.toString(contador);
                 hgvAih.add(strCont);
                 contador ++;
        }


        if (!c1) {
            hgvAih.forEach(System.out::println);


        } else {
            System.out.println("Digite a ultima  AIH impressa");
        }






    }

}