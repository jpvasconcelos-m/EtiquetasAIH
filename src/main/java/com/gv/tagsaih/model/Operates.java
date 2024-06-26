package com.gv.tagsaih.model;

import java.util.*;
import java.util.function.Predicate;

public class Operates {
    public static void main(String[] args) throws Exception {

        //creation of collections to manipulate the "Tag" object
        Predicate<Tag> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;
        List<Integer> cyclics = Arrays.asList(0,0,1,2,3,4,5,6,7,8,9);
        ArrayList<Long> hgvAihsLong = new ArrayList<>();
        ArrayList<String> hgvAih = new ArrayList<>();
        CircularLinkedList circleList = new CircularLinkedList();

        while(circleList.size() < 11){
            cyclics.forEach(num -> {
                try {
                    circleList.add(num);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }


        Tag init = new Tag(26, 24, 11028345, 9);
        Tag fin = new Tag(26, 24, 11028370, 2);
        int aihInitCod = (init.unitCode());
        String codeYText = aihInitCod + "";
        int aihYear = init.year();
        String yearText = aihYear + "";

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
            //Node currentNode = circleList.getHead();
            Node nodeAtIndex = circleList.getNodeAtIndex(init.cyclicDigit()+1);
            Iterator<String> current = hgvAih.iterator();
            while (current.hasNext()){
                String element = current.next();
                System.out.println(codeYText+yearText+element+"-"+nodeAtIndex.data);
                nodeAtIndex = circleList.getNext(nodeAtIndex);
           }
        } else {
            System.out.println("Digite a ultima  AIH impressa");
            Tag previous = new Tag(26, 24, 11028344, 9);
            if (previous.cyclicDigit() == 9) {
                Node currentNode = circleList.getHead();
                //Node nodeAtIndex = circleList.getNodeAtIndex(init.cyclicDigit()+1);
                Iterator<String> current = hgvAih.iterator();
                while (current.hasNext()) {
                    String element = current.next();
                    System.out.println(codeYText + yearText + element + "-" + currentNode.data);
                    currentNode = circleList.getNext(currentNode);
                }
            } else {
                Node nodeAtIndex = circleList.getNodeAtIndex(init.cyclicDigit()+1);
                Iterator<String> current = hgvAih.iterator();
                while (current.hasNext()){
                    String element = current.next();
                    System.out.println(codeYText+yearText+element+"-"+nodeAtIndex.data);
                    nodeAtIndex = circleList.getNext(nodeAtIndex);
                }

            }

        }

    }

}