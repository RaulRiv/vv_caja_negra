package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("addLast - Añade un elemento pasado por parámetro al final de la lista")
public class AddLastTest {
    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }
    @DisplayName("Añade un elemento al final de una lista vacía")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void addLastToEmpty(String element){
        list.addLast(element);
        assertEquals(1, list.size());
    }

    @DisplayName("Añade un elemento al final de una lista con un elemento")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void addLastToOneElement(String element){
        String testElement = "A";
        list = new SingleLinkedListImpl<>(testElement);
        list.addLast(element);
        assertEquals(2, list.size());
    }

    @DisplayName("Añade un elemento al final de una lista con más de un elemento")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void addLastToVariousElements(String element){
        String testElement1 = "A";
        String testElement2 = "B";
        list = new SingleLinkedListImpl<>(testElement1,testElement2);
        list.addLast(element);
        assertEquals(3, list.size());
    }
}
