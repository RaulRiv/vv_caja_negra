package com.practica.cajanegra;


import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SizeTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    //List is empty
    @Test
    public void testListEmpty(){
        assertEquals(0, this.list.size());
    }

    //List is null
    @Test
    public void testListNull(){
        this.list = null;
        Exception exception = assertThrows(java.lang.NullPointerException.class, () -> this.list.size());
        assertEquals(java.lang.NullPointerException.class, exception.getClass());
    }

    //List has values
    @Test
    public void testListNormal(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        assertEquals(5, this.list.size());
    }

}

//Variable a probar: la lista sobre la que se ejecuta la funcion
//Clase de equivalencia: lista null, lista vacía, lista estandar