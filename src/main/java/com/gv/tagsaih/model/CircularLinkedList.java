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

    public Node getNext(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        return currentNode.next;
    }

    public Node getHead() {
        return head;
    }
}
