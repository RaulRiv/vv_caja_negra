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

    // Lista inicializada a null
    @Test
    public void testListNull() {
        this.list = null;
        Exception exception = assertThrows(java.lang.NullPointerException.class, () -> this.list.removeLast());
        assertEquals(java.lang.NullPointerException.class, exception.getClass());
    }

    // Lista vacía
    @Test
    public void testListEmpty(){
        Exception exception = assertThrows(com.cajanegra.EmptyCollectionException, () -> this.list.removeLast());
        assertEquals(com.cajanegra.EmptyCollectionException,exception.getClass());
    }

    //El elemento no es valido
    @Test
    public void testElemNotValid() {
        this.list = new SingleLinkedListImpl<>("c");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.removeLast());
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //El elemento sí es válido
    @Test
    public void testElemValid() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals("A", this.list.removeLast());
    }

    // Hay un elemento no válido
    @Test
    public void testAnyElemNotValid() {
        this.list = new SingleLinkedListImpl<>("A", "B", "c", "D", "E");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.removeLast());
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //El último elemento no es valido
    @Test
    public void testLastElemNotValid() {
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "e");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.removeLast());
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    // Lista estándar
    @Test
    public void testStandardList() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals("E", list.removeLast());
    }
}

//Variables a probar: el elemento que se pasa, la lista sobre la que se ejecuta la funcion
//Clase de equivalencia 1: el único elemento no válido, el único elemento válido, existe un elemento no válido, el último elemento es no válido
//Clase de equivalencia 2: lista null, lista vacía, lista con un elemento, lista estandar