package com.gv.tagsaih.model;

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    // Adicionar um novo nó ao final da lista
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Exibir os elementos da lista
    public void display() {
        Node current = head;
        if (head != null) {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
        }
        System.out.println();
    }

    // Verificar se a lista está vazia
    public boolean isEmpty() {
        return head == null;
    }

    // Obter o tamanho da lista
    public int size() {
        if (head == null) return 0;

        Node current = head;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    // Remover um nó pelo valor
    public boolean remove(int data) {
        if (head == null) return false;

        Node current = head;
        Node previous = tail;

        do {
            if (current.data == data) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        return false;
     }
     //Retorna o próximo nó da lista
    public Node getNext(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        return currentNode.next;
    }
    //Retoorna o primeiro nó da lista
    public Node getHead() {
        return head;
    }

    // Método para encontrar o índice de um valor na lista circular
    public int findIndex(int value) {
        if (head == null) {
            return -1; // Lista vazia
        }

        Node currentNode = head;
        int index = 0;

        do {
            if (currentNode.data == value) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        } while (currentNode != head);

        return -1; // Valor não encontrado na lista
    }

    // Método para obter o nó em um índice específico na lista circular
    public Node getNodeAtIndex(int index) {
        if (head == null || index < 0) {
            return null; // Lista vazia ou índice inválido
        }

        Node currentNode = head;
        int currentIndex = 0;

        do {
            if (currentIndex == index) {
                return currentNode;
            }
            currentIndex++;
            currentNode = currentNode.next;
        } while (currentNode != head);

        return null; // Índice fora do alcance da lista
    }
}
