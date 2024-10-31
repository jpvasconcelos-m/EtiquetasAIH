package com.gv.tagsaih.model;

import java.util.*;
import java.util.function.Predicate;

public class Operates {

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
    // Cria uma lista para armazenar as tags formatadas
    List<String> formattedTags = new ArrayList<>();
    public List<String> operate(Tag initalTag, Tag finalTag) throws Exception {

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
    public List<String> operatesWithTagQuantity(Tag initialTag, int tagQuantity) throws Exception {
        List<String> tags = new ArrayList<>();

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

        int aihInitCod = initialTag.unitCode();
        String codeYText = Integer.toString(aihInitCod);
        int aihYear = initialTag.year();
        String yearText = Integer.toString(aihYear);
        boolean isCyclic = isCyclics.test(initialTag);

        Node nodeAtIndex = circleList.getNodeAtIndex(initialTag.cyclicDigit() + 1);

        for (int i = 0; i < tagQuantity; i++) {
            String formattedTag = codeYText + yearText + (initialTag.increasingDigit() + i) + "-" + nodeAtIndex.data;
            tags.add(formattedTag);
            nodeAtIndex = circleList.getNext(nodeAtIndex);
        }

        return tags;
    }
    public List<String> operatesWithTagQuantity(Tag previousTag, Tag initialTag, int tagQuantity) throws Exception {
        List<String> tags = new ArrayList<>();

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

        int aihInitCod = initialTag.unitCode();
        String codeYText = Integer.toString(aihInitCod);
        int aihYear = initialTag.year();
        String yearText = Integer.toString(aihYear);
        boolean isCyclic = isCyclics.test(initialTag);

        // Determine o nó de início com base na condição cíclica
        Node nodeAtIndex;
        if (!isCyclic) {
            nodeAtIndex = circleList.getNodeAtIndex(initialTag.cyclicDigit() + 1);
        } else {
            // Se o Tag anterior é cíclico, inicie do início da lista
            if (previousTag.cyclicDigit() == 9) {
                nodeAtIndex = circleList.getHead();
            } else {
                nodeAtIndex = circleList.getNodeAtIndex(initialTag.cyclicDigit() + 1);
            }
        }

        // Gera as tags formatadas
        for (int i = 0; i < tagQuantity; i++) {
            String formattedTag = codeYText + yearText + (initialTag.increasingDigit() + i) + "-" + nodeAtIndex.data;
            tags.add(formattedTag);
            nodeAtIndex = circleList.getNext(nodeAtIndex);
        }

        return tags;
    }

    public List<String> operate(Tag previousTag,Tag initalTag, Tag finalTag) throws Exception {

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



        // Se o Tag inicial não for cíclico
        if (!c1) {
            Node nodeAtIndex = circleList.getNodeAtIndex(initalTag.cyclicDigit() + 1);
            for (String element : hgvAih) {
                String formattedTag = codeYText + yearText + element + "-" + nodeAtIndex.data;
                formattedTags.add(formattedTag);
                nodeAtIndex = circleList.getNext(nodeAtIndex);
            }
        } else {

            if (previousTag.cyclicDigit() == 9) {
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

