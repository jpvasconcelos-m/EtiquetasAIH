package com.gv.tagsaih.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Operates {

    private static Predicate<Tag> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;
    private static List<Integer> cyclics = Arrays.asList(0,0,1,2,3,4,5,6,7,8,9);
    private static ArrayList<Long> hgvAihsLong = new ArrayList<>();
    private static ArrayList<String> hgvAih = new ArrayList<>();
    private static LinkedList<Integer> circleList = new LinkedList<>();

    static{

        //Cyclic array initial configuration.
        while(circleList.size() < 11){
            cyclics.forEach(num -> {
                try {
                    circleList.add(num);
                    System.out.println(circleList);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

    }




    public static void main(String[] args) throws Exception {

        //creation of collections to manipulate the "Tag" object



        System.out.println(circleList.toString());

        /* Will Recieved by Front End in future:--------------------------------------------------*/
        Tag init = new Tag(26, 24, 11028345, 1);
        Tag fin = new Tag(26, 24, 11028350, 6);
        /* ------------------------------------------------------------------------*/
        int aihInitCod = (init.unitCode());
        String codeYText = aihInitCod + "";
        int aihYear = init.year();
        String yearText = aihYear + "";

        boolean c1 = isCyclics.test(init);

        //Manipulation of data received by the user
        long contador1 = init.increasingDigit();
        long contador2 = fin.increasingDigit();

        while (contador1 <= contador2){
                 hgvAihsLong.add(contador1);
                 String strCont = Long.toString(contador1);
                 hgvAih.add(strCont);
                 contador1 ++;
        }


        if (!c1) {
            hgvAih.forEach(System.out::println);


        } else {
            System.out.println("Digite a ultima  AIH impressa");
        }






    }




}