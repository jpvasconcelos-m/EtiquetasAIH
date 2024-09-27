package com.gv.tagsaih.model;

import java.util.*;
import java.util.function.Predicate;

public class Operates {
    public static List<String> Operate(Tag initalTag, Tag finalTag) throws Exception {

        // Define um Predicate para verificar se o objeto Tag é cíclico
        Predicate<Tag> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;

        // Cria uma lista de inteiros que será usada para adicionar elementos à lista circular
        List<Integer> cyclics = Arrays.asList(0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Cria listas para armazenar números e strings
        ArrayList<Long> hgvAihsLong = new ArrayList<>();
        ArrayList<String> hgvAih = new ArrayList<>();

        // Cria uma lista circular personalizada
        CircularLinkedList circleList = new CircularLinkedList();

        // Lista final de Tags.
        List<Tag> listaTags = new ArrayList<>();

        // Adiciona elementos à lista circular até que seu tamanho seja 11
        while (circleList.size() < 11) {
            cyclics.forEach(num -> {
                try {
                    circleList.add(num);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Obtém o código da unidade e o ano do Tag inicial
        int aihInitCod = initalTag.unitCode();
        String codeYText = Integer.toString(aihInitCod);
        int aihYear = initalTag.year();
        String yearText = Integer.toString(aihYear);

        // Verifica se o Tag inicial é cíclico
        boolean c1 = isCyclics.test(initalTag);

        // Manipula dados recebidos, armazenando números em uma lista
        long contador = initalTag.increasingDigit();
        long contador2 = finalTag.increasingDigit();

        // Adiciona números à lista e converte para string
        while (contador <= contador2) {
            hgvAihsLong.add(contador);
            String strCont = Long.toString(contador);
            hgvAih.add(strCont);
            contador++;
        }

        // Cria uma lista para armazenar as tags formatadas
        List<String> formattedTags = new ArrayList<>();

        // Se o Tag inicial não for cíclico
        if (!c1) {
            Node nodeAtIndex = circleList.getNodeAtIndex(initalTag.cyclicDigit() + 1);
            for (String element : hgvAih) {
                String formattedTag = codeYText + yearText + element + "-" + nodeAtIndex.data;
                formattedTags.add(formattedTag);
                nodeAtIndex = circleList.getNext(nodeAtIndex);
            }
        } else {
            System.out.println("Digite a ultima AIH impressa");

            Tag previous = new Tag(26, 24, 11028344, 9);
            if (previous.cyclicDigit() == 9) {
                Node currentNode = circleList.getHead();
                for (String element : hgvAih) {
                    String formattedTag = codeYText + yearText + element + "-" + currentNode.data;
                    formattedTags.add(formattedTag);
                    currentNode = circleList.getNext(currentNode);
                }
            } else {
                Node nodeAtIndex = circleList.getNodeAtIndex(initalTag.cyclicDigit() + 1);
                for (String element : hgvAih) {
                    String formattedTag = codeYText + yearText + element + "-" + nodeAtIndex.data;
                    formattedTags.add(formattedTag);
                    nodeAtIndex = circleList.getNext(nodeAtIndex);
                }
            }
        }

        // Retorna a lista de tags formatadas
        return formattedTags;
    }
}
