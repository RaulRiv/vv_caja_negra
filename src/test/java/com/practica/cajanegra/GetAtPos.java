package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetAtPos {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    @Test
    public void InvalidIndexNullList(){
        this.list = null;
        int index = -1;
        this.list.getAtPos(index);
    }

    @Test
    public void ValidIndexNullList(){
        this.list = null;
        int index = 0;
        this.list.getAtPos(index);

    }

    @Test
    public void InvalidIndexZeroLengthList(){
        int index = -1;
        this.list.getAtPos(index);
    }

    @Test
    public void IndexOutOfBoundsZeroLengthList(){
        int index = 0;
        this.list.getAtPos(index);

    }

    @Test
    public void InvalidIndexList(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = -1;
        this.list.getAtPos(index);
    }

    @Test
    public void IndexOutOfBounds(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 5;
        this.list.getAtPos(index);

    }

    @Test
    public void FirstValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 0;
        this.list.getAtPos(index);

    }

    @Test
    public void LastValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 4;
        this.list.getAtPos(index);

    }

    @Test
    public void MiddleValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 2;
        this.list.getAtPos(index);

    }


}

//Clases de equivalencia.
//
//Parámetros:
//
//Indice.
//  Indice,type != int (no compila)
//  Indice < 0
//  Indice > lista.length
//  0 <= Indice < lista.length
//      En este caso se prueba para Indice = 0, Indice = lista.length -1 y 1 <= Indice < lista.length-1
//
//Lista.
//  Lista no iniciada (no compila)
//  Lista nula
//  Lista de longituz = 0
//  Lista de longituz > 0
//
//Elemento retornado:
//