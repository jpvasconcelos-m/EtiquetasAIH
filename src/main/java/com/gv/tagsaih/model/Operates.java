package com.gv.tagsaih.model;

import java.util.*;
import java.util.function.Predicate;

public class Operates {
    public static void main(String[] args) throws Exception {

        // Define um Predicate para verificar se o objeto Tag é cíclico
        Predicate<Tag> isCyclics = cyclic -> cyclic.cyclicDigit() == 0;

        // Cria uma lista de inteiros que será usada para adicionar elementos à lista circular
        List<Integer> cyclics = Arrays.asList(0,0,1,2,3,4,5,6,7,8,9);

        // Cria listas para armazenar números e strings
        ArrayList<Long> hgvAihsLong = new ArrayList<>();
        ArrayList<String> hgvAih = new ArrayList<>();

        // Cria uma lista circular personalizada
        CircularLinkedList circleList = new CircularLinkedList();

        // Adiciona elementos à lista circular até que seu tamanho seja 11
        while(circleList.size() < 11){
            cyclics.forEach(num -> {
                try {
                    circleList.add(num);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Cria dois objetos Tag para manipulação
        Tag init = new Tag(26, 24, 11028345, 9);
        Tag fin = new Tag(26, 24, 11028370, 2);

        // Obtém o código da unidade e o ano do Tag inicial
        int aihInitCod = (init.unitCode());
        String codeYText = aihInitCod + "";
        int aihYear = init.year();
        String yearText = aihYear + "";

        // Verifica se o Tag inicial é cíclico
        boolean c1 = isCyclics.test(init);

        // Manipula dados recebidos, armazenando números em uma lista
        long contador = init.increasingDigit();
        long contador2 = fin.increasingDigit();

        // Adiciona números à lista e converte para string
        while (contador <= contador2){
            hgvAihsLong.add(contador);
            String strCont = Long.toString(contador);
            hgvAih.add(strCont);
            contador++;
        }

        // Se o Tag inicial não for cíclico
        if (!c1) {
            // Obtém o nó na lista circular na posição do dígito cíclico do Tag inicial + 1
            Node nodeAtIndex = circleList.getNodeAtIndex(init.cyclicDigit() + 1);

            // Itera sobre a lista de strings e imprime o resultado
            Iterator<String> current = hgvAih.iterator();
            while (current.hasNext()){
                String element = current.next();
                System.out.println(codeYText + yearText + element + "-" + nodeAtIndex.data);
                nodeAtIndex = circleList.getNext(nodeAtIndex);
            }
        } else {
            // Se o Tag inicial for cíclico
            System.out.println("Digite a ultima AIH impressa");

            // Cria um Tag anterior para comparação
            Tag previous = new Tag(26, 24, 11028344, 9);

            // Se o dígito cíclico do Tag anterior for 9
            if (previous.cyclicDigit() == 9) {
                // Obtém o nó cabeça da lista circular
                Node currentNode = circleList.getHead();

                // Itera sobre a lista de strings e imprime o resultado usando o nó cabeça
                Iterator<String> current = hgvAih.iterator();
                while (current.hasNext()) {
                    String element = current.next();
                    System.out.println(codeYText + yearText + element + "-" + currentNode.data);
                    currentNode = circleList.getNext(currentNode);
                }
            } else {
                // Se o dígito cíclico do Tag anterior não for 9
                Node nodeAtIndex = circleList.getNodeAtIndex(init.cyclicDigit() + 1);
                Iterator<String> current = hgvAih.iterator();
                while (current.hasNext()){
                    String element = current.next();
                    System.out.println(codeYText + yearText + element + "-" + nodeAtIndex.data);
                    nodeAtIndex = circleList.getNext(nodeAtIndex);
                }
            }
        }
    }
}
