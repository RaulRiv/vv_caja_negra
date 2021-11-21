package com.practica.cajanegra;


import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SizeTest {

    AbstractSingleLinkedListImpl<String> list;

    //No funciona pero deberia
    @BeforeEach()
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }


    //List is empty
    @Test
    public void testEmpty(){
        list = new SingleLinkedListImpl<>();
        assertEquals(0, list.size());
    }

    //List is null
    @Test
    public void testNull(){
        list = null;
        assertEquals(0, list.size());
        //Conseguir recoger la excepcion
        //assertThrows(NullPointerException, list.size())
    }

    //List has values
    @Test
    public void testNormal(){
        list = new SingleLinkedListImpl<>();
        list.addNTimes("a", 5);
        assertEquals(5, list.size());
    }

}