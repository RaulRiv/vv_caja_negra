package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IsSubListTest {

    AbstractSingleLinkedListImpl<String> list;
    AbstractSingleLinkedListImpl<String> part;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
        this.part = new SingleLinkedListImpl<>();
    }

    //set
    @Test
    public void ListaNulaSublistaNula(){
        this.list = null;
        this.part = null;
    }

    @Test
    public void ListaLongitudCeroSublistaNula(){
        this.part = null;
    }

    @Test
    public void ListaSublistaNula(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = null;
    }

    //set
    @Test
    public void ListaNulaSublistaDeLongitudCero(){
        this.list = null;
    }

    @Test
    public void ListaLongitudCeroSublistaDeLongitudCero(){

    }

    @Test
    public void ListaSublistaDeLongitudCero(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
    }

    //set

    @Test
    public void ListaNulaSublistaDeLongitudMayorQueLaLista(){ //elimiar?
        this.list = null;
        this.part = new SingleLinkedListImpl<>("A");
    }

    @Test
    public void ListaLongitudCeroSublistaDeLongitudMayorQueLaLista(){
        this.part = new SingleLinkedListImpl<>("A");
    }

    @Test
    public void ListaSublistaDeLongitudMayorQueLaLista(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F");
    }

    //set
    @Test
    public void ListaSublistaDeLongitudMayorQueLaLista() {
    }
}

//Clases de equivalencia.
//
//Parámetros:
//
//Lista:
//  Lista nula
//  Lista de longitud = 0
//  Lista de longitud > 0
//
//Sublista:
//  Sublista nula
//  Sublista de longitud = 0
//  Sublista de longitud > 0 y <= lista.length
//      En este caso ha de probarse para longitud = 1, longitud = lista.length y una longitud intermedia
//  Sublista de longitud > lista.length
//
//Pertenece:
//  La sublista pertenece a la lista
//  La sublista no pertenece a la lista
//    En este caso hay que probar para:
//      Coinciden 0 elementos
//      Coinciden un número entre 1 y sublista.length-2 elementos (ambos incluidos)
//      Coinciden sublista.length-1 elementos
//