package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsEmptyTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    // Lista inicializada a null
    @Test
    public void testListNull(){
        this.list = null;
        Exception exception = assertThrows(java.lang.NullPointerException.class, () -> this.list.isEmpty());
        assertEquals(java.lang.NullPointerException.class, exception.getClass());
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
//Clase de equivalencia: lista null, lista vacía, lista de uno, lista estandar