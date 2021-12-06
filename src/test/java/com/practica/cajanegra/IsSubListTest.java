package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsSubListTest {

    AbstractSingleLinkedListImpl<String> list;
    AbstractSingleLinkedListImpl<String> part;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
        this.part = new SingleLinkedListImpl<>();
    }

    @Test
    public void ListaLongitudCeroSublistaDeLongitudCero(){
        assertEquals(0, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudCero(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(0, this.list.isSubList(part));
    }

    @Test
    public void ListaLongitudCeroSublistaDeLongitudMayorQueLaLista(){
        this.part = new SingleLinkedListImpl<>("A");
        assertEquals(-1, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudMayorQueLaLista(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("A", "B", "C", "D", "E", "F");
        assertEquals(-1, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaMinimaPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("B");
        assertEquals(2, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaMinimaNoPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("F");
        assertEquals(-1, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaMaximaPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(1, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaMaximaNoPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>("B", "C", "D", "E", "A");
        assertEquals(-1, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>( "C", "D", "E");
        assertEquals(3, this.list.isSubList(part));
    }

    @Test
    public void SublistaDeLongitudValidaNoPertence(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        this.part = new SingleLinkedListImpl<>( "C", "E", "D");
        assertEquals(-1, this.list.isSubList(part));
    }
}

//Clases de equivalencia.
//
//Parámetros:
//
//Lista:
//  Lista nula (no se prueba Raul sabe por qué)
//  Lista de longitud = 0
//  Lista de longitud > 0
//
//Sublista:
//  Sublista nula (no se prueba Raul sabe por qué)
//  Sublista de longitud = 0
//  Sublista de longitud > 0 y <= lista.length
//      En este caso ha de probarse para longitud = 1, longitud = lista.length y una longitud intermedia
//  Sublista de longitud > lista.length
//
//Pertenece:
//  La sublista pertenece a la lista
//  La sublista no pertenece a la lista
//    En este caso hay que probar para: (Hacemos un solo caso)
//      Coinciden 0 elementos
//      Coinciden un número entre 1 y sublista.length-2 elementos
//      Coinciden sublista.length-1 elementos
//