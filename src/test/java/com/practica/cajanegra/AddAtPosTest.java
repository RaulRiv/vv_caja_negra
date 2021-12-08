package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("AddAtPos - Inserta el elemento en la posición p, desplazando los elementos a partir de esa posición. " +
        "Si la lista tiene menos de p elementos lo insertará como último elemento")
public class AddAtPosTest {

    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("CP 1 - Si p es menor o igual a cero lanza IllegalArgumentException")
    @CsvSource(value={"0,A","-1,A","0,B","-1,B","0,M","-1,M","0,Y","-1,Y","0,Z","-1,Z","0,@","-1,@","0,[","-1,["})
    @ParameterizedTest
    public void testCp1(int position, String element){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.addAtPos(element, position);
        });
    }

    @DisplayName("CP 2 - Si p es 1 y la lista está vacía añade el elemento en la primera posición")
    @CsvSource(value={"1,A","1,B","1,M","1,Y","1,Z","1,@","1,["})
    @ParameterizedTest
    public void testCp2(int position, String element){
        list.addAtPos(element, position);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(element, list.getAtPos(1));
    }

    @DisplayName("CP 3 - Si p es 1 y la lista tiene 1 elemento añade el elemento en la primera posición " +
            "y desplaza el original a la segunda")
    @CsvSource(value={"1,A","1,B","1,M","1,Y","1,Z","1,@","1,["})
    @ParameterizedTest
    public void testCp3(int position, String element){
        list.addAtPos("R", 1);
        list.addAtPos(element, position);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(element, list.getAtPos(1));
        Assert.assertEquals("R", list.getAtPos(2));
    }

    @DisplayName("CP 4 - Si p es 3 (mayor que la longitud) y la lista tiene 1 elemento añade el elemento " +
            "en la última posición(2) y mantiene el original en la primera")
    @CsvSource(value={"3,A","3,B","3,M","3,Y","3,Z","3,@","3,["})
    @ParameterizedTest
    public void testCp4(int position, String element){
        list.addAtPos("R", 1);
        list.addAtPos(element, position);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals("R", list.getAtPos(1));
        Assert.assertEquals(element, list.getAtPos(2));
    }
}
