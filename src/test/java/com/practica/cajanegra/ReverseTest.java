package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReverseTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    //Lista vacía
    @Test
    public void testListEmpty(){
        assertEquals("[]", this.list.reverse().toString());
    }

    //Lista de un elemento
    @Test
    public void testListOne(){
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals("[A]", this.list.reverse().toString());
    }

    //lista de n elementos
    @Test
    public void testListNormal(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals("[E, D, C, B, A]", this.list.reverse().toString());
    }
}

//Variable a probar: la lista sobre la que se ejecuta la funcion
//Clase de equivalencia: lista null, lista vacía, lista de uno, lista estandar
