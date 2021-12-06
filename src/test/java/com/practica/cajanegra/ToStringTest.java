package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Convierte la lista en un String")
public class ToStringTest {
    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("Convierte una lista vacía en un String")
    @Test
    public void toStringTest(){
        assertEquals("[]",list.toString());
    }

    @DisplayName("Convierte una con un elemento en un String")
    @Test
    public void toStringTestOneElement(){
        list = new SingleLinkedListImpl<>("A");
        assertEquals("[A]",list.toString());
    }
    @DisplayName("Convierte una lista vacía con varios elementos en un String")
    @Test
    public void toStringTestVariousElements(){
        String[] elements = new String[2];
        elements[0] = "A";
        elements[1] = "B";
        list = new SingleLinkedListImpl<>("A", "B");
        assertEquals("[A, B]",list.toString());
    }
}
