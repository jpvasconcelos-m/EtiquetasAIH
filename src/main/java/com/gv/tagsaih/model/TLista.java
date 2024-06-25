package com.gv.tagsaih.model;

public interface TLista {

    default void add(String s) throws  Exception{

    }

    default String removeIdex(int i) throws Exception{
        return null;
    }

    default void removeElem(String s) throws Exception{

    }

     default String previous(String s) throws Exception{
        return null;
    }

     default int index(String s) throws Exception{
        return 0;
    }

     default   String elemen(int i) throws Exception{
        return null;
    }

     default int size(){
        return 0;
    }

     default String first(){
        return null;
    }

     default String last(){
        return null;
    }
     default void print(){

    }

}
