package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveLastTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    // Lista vacía
    @Test
    public void testListEmpty(){
        Exception exception = assertThrows(com.cajanegra.EmptyCollectionException.class, () -> this.list.removeLast());
        assertEquals(com.cajanegra.EmptyCollectionException.class,exception.getClass());
    }

    //El elemento sí es válido
    @Test
    public void testElemValid() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals("A", this.list.removeLast());
    }

    // Lista estándar
    @Test
    public void testStandardList() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals("E", list.removeLast());
    }
}

//Variables a probar: la lista sobre la que se ejecuta la funcion
//Clase de equivalencia 1: el único elemento válido, el último elemento es válido
//Clase de equivalencia 2: lista vacía, lista con un elemento, lista estandar