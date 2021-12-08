package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoveLastParamTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    // Lista vacía
    @Test
    public void testListEmpty(){
        Exception exception = assertThrows(com.cajanegra.EmptyCollectionException.class, () -> this.list.removeLast("A"));
        assertEquals(com.cajanegra.EmptyCollectionException.class,exception.getClass());
    }

    //El elemento no es valido
    @Test
    public void testElemNotValid() {
        this.list = new SingleLinkedListImpl<>("A");
        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> this.list.removeLast("a"));
        assertEquals(java.util.NoSuchElementException.class, exception.getClass());
    }

    //El elemento sí es válido y no está
    @Test
    public void testElemValidNotIn() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals(java.util.NoSuchElementException.class, this.list.removeLast("B"));
    }

    //El elemento sí es válido y está
    @Test
    public void testElemValidIn() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals("A", this.list.removeLast("A"));
    }

    //Está el elemento buscado
    @Test
    public void testElemValidInAnyPos() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A", "C", "B", "C", "D", "C");
        assertEquals("D", this.list.removeLast("D"));
    }

    //Hay varios elementos buscados
    @Test
    public void testSomeValidElem() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A", "D", "B", "C", "D", "C");
        assertEquals("D", this.list.removeLast("D"));
    }

    //El elemento no está en lista estándar
    @Test
    public void testElemValidNotInStandardList() throws EmptyCollectionException {
        this.list = new SingleLinkedListImpl<>("A", "D", "B", "C", "D", "C");
        assertEquals(java.util.NoSuchElementException.class, this.list.removeLast("H"));
    }

}


//Variables a probar: el elemento que se pasa como parámetro, la lista sobre la que se ejecuta la funcion
//Clase de equivalencia 1: el elemento no válido, el elemento válido y no está, el elemento válido y está, existe elemento buscado, hay varios elemntos bucados, el elemento no está
//Clase de equivalencia 2: lista vacía, lista con un elemento, lista estandar