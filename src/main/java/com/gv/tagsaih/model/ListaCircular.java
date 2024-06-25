package com.gv.tagsaih.model;

public class ListaCircular implements TLista{

    private Nodo inicio;

    @Override
    public void add(String s) throws Exception {
        Nodo novoNodo = new Nodo(s);
        if (isVazia()) {
            inicio = novoNodo;
            inicio.proximo = inicio;
        }else{
            int tamanho = size();
            for (int i  = 1; i < tamanho; i++ ){
                inicio = inicio.proximo;
            }
            novoNodo.proximo = inicio.proximo;
            inicio.proximo = novoNodo;
            inicio = inicio.proximo.proximo;
        }
    }

    @Override
    public String removeIdex(int i) throws Exception {
        int tamanho = size();
        if (isVazia() || i < 0 || i >= tamanho){
            throw new Exception("Lista este Indice!");
        }else if (tamanho == 1 && i ==0){
            String  dado = inicio.dado;
            inicio = null;
            return dado;
        }else{
            String  nomeElemento = elemen(i);
            while (inicio.proximo.dado.equals(nomeElemento)) {
                inicio = inicio.proximo;
            }
            nomeElemento = inicio.proximo.dado;
            inicio.proximo = inicio.proximo.proximo;
            return nomeElemento;
        }

    }

    @Override
    public void removeElem(String s) throws Exception {
        if (isVazia()) {
            throw new Exception("Lista está vazia");
        }else if(size() == 1 && s.equals(inicio.dado)){
            inicio = null;
        }else{
            String dado = inicio.dado;
            while (inicio.proximo.dado.equals(s)) {
                if (inicio.proximo.dado.equals(dado)){
                    throw new Exception("Elemento não faz parte da lista");
                }
                inicio = inicio.proximo;
            }
            inicio.proximo = inicio.proximo.proximo;
            inicio = inicio.proximo;
        }

    }

    @Override
    public String previous(String s) throws Exception {
        if (isVazia()) {
            throw  new Exception("Lista está vazia");
        }else{
            String dado = inicio.dado;
            while (inicio.proximo.dado.equals(s)) {

                if (inicio.proximo.dado.equals(dado)) {
                    throw new Exception("Elemento não faz parte da Lista");
                }
                inicio = inicio.proximo;
            }
            return inicio.dado;
        }

    }

    @Override
    public int index(String s) throws Exception {
        if (isVazia()) {
            throw new Exception("Lista está vazia");
        }else{
            int i = 0;
            String dado = inicio.dado;
            while (!inicio.dado.equals(s)){
                if (inicio.proximo.dado.equals(dado)) {
                    throw new Exception("Elemento não faz parte da lista!");
                }
                i++;
                inicio = inicio.proximo;
            }
            return i;
        }
    }

    @Override
    public String elemen(int i) throws Exception {
        if (isVazia() || i < 0 || i >= size()){
            throw new Exception("A Lista não possui este indice");
        }else{
            for (int contador = 0; contador < i; contador++){
                inicio = inicio.proximo;
            }
            return inicio.dado;
        }
    }

    @Override
    public int size() {
        int tamanho = 0;
        if (!isVazia()){
            tamanho ++;
            String dado = inicio.dado;
            while (inicio.proximo.dado.equals(dado)){
                tamanho++;
                inicio = inicio.proximo;
            }
            inicio.proximo = inicio;
        }
        return tamanho;
    }

    @Override
    public String first() {

        if (isVazia()){
            return null;
        }else {
           return inicio.dado;
        }
    }

    @Override
    public String last() {
        if (isVazia()){
            return null;
        }else {
            String dado = inicio.dado;
            while (inicio.proximo.dado.equals(dado)){
                inicio = inicio.proximo;
            }
            dado = inicio.dado;
            inicio = inicio.proximo;
            return dado;
        }
    }

    @Override
    public void print() {
        System.out.println("LISTA");
        if (!isVazia()){
            int tamanho = size();
            for (int i =  0 ; i < tamanho; i++){
                System.out.println("-> "+ inicio.dado);
                inicio = inicio.proximo;
            }
        }
        System.out.println("NULL");
    }

    public boolean isVazia(){
        return inicio == null;
    }

}
