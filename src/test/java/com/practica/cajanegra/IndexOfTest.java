package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IndexOfTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    //La lista es vacía
    @Test
    public void testListEmpty(){
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.indexOf("A"));
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //La lista es null
    @Test
    public void testListNull(){
        this.list = null;
        Exception exception = assertThrows(java.lang.NullPointerException.class, () -> this.list.indexOf("A"));
        assertEquals(java.lang.NullPointerException.class, exception.getClass());
    }

    //El elemento no es valido
    @Test
    public void testElemNotValid(){
        this.list = new SingleLinkedListImpl<>("A", "B", "c", "D", "E");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.indexOf("0"));
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //Elemento está en primera posición
    @Test
    public void testFirstPos(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(1, this.list.indexOf("A"));
    }

    //Elemento está en posicion estandar
    @Test
    public void testNormalPos(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(3, this.list.indexOf("C"));
    }

    //Elemento está en última posición
    @Test
    public void testLastPos(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(5, this.list.indexOf("E"));
    }

    //No está el elemento
    @Test
    public void testElementNotInList(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.indexOf("P"));
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //El elemento está varias veces
    @Test
    public void testElementDuplicate(){
        this.list = new SingleLinkedListImpl<>("A", "B", "B", "C", "D");
        assertEquals(2, this.list.indexOf("B"));
    }










}
//Variables a probar: el elemento que se pasa, la lista sobre la que se ejecuta la funcion
//Clase de equivalencia 1: elemento no válido, el elemento está en primera posición, el elemento está en el medio, el elemento está en última posición, el elemento no está, el elemento está varias veces
//Clase de equivalencia 2: lista null, lista vacía, lista estandar
