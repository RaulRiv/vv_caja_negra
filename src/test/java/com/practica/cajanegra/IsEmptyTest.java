package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsEmptyTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    // Lista vacía
    @Test
    public void testListEmpty(){
        assertEquals(true,this.list.isEmpty());
    }

    //Lista de un elemento
    @Test
    public void testListOne(){
        this.list = new SingleLinkedListImpl<>("A");
        assertEquals(false,this.list.isEmpty());
    }

    //Lista de n elementos
    @Test
    public void testListNormal(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(false, this.list.isEmpty());
    }

}

//Variable a probar: la lista sobre la que se ejecuta la funcion
//Clase de equivalencia: lista vacía, lista de uno, lista estandar