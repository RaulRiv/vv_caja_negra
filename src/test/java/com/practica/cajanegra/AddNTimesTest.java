package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("AddNTimes - Inserta n veces el elemento al final de la lista.")
public class AddNTimesTest {

    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("CP 1 - Si n es menor que cero lanza IllegalArgumentException")
    @CsvSource(value={"-1,A","-2,A","-1,B","-2,B","-1,M","-2,M","-1,Y","-2,Y","-1,Z","-2,Z","-1,@","-2,@","-1,[","-2,["})
    @ParameterizedTest
    public void testCp1(int n, String element){
        assertThrows(IllegalArgumentException.class, () -> {
            list.addNTimes(element, n);
        });
    }

    @DisplayName("CP 2 - Si n es 0 y la lista está vacía la lista se queda vacía al añadirlo 0 veces")
    @CsvSource(value={"0,A","0,B","0,M","0,Y","0,Z","0,@","0,[",})
    @ParameterizedTest
    public void testCp2(int n, String element){
        //ESTE TEST DA ERROR Y NO DEBERÍA 'No puedes introducir n�meros menores que cero' NO DEJA INTRODUCIR 0
        list.addNTimes(element, n);
        assertEquals(0, list.size());
    }

    @DisplayName("CP 3 - Si n > 0 y la lista está vacía se añade el elemento n veces al final de la lista")
    @CsvSource(value={"1,A","2,A","1,B","2,B","1,M","2,M","1,Y","2,Y","1,Z","2,Z","1,@","2,@","1,[","2,["})
    @ParameterizedTest
    public void testCp3(int n, String element){
        list.addNTimes(element, n);
        assertEquals(n, list.size());
        for(int i = 1; i <= n; i++){
            assertEquals(element, list.getAtPos(i));
        }
    }

    @DisplayName("CP 4 - Si n > 0 y la lista tiene 1 elemento se añade el elemento n veces al final de la lista")
    @CsvSource(value={"1,A","2,A","1,B","2,B","1,M","2,M","1,Y","2,Y","1,Z","2,Z","1,@","2,@","1,[","2,["})
    @ParameterizedTest
    public void testCp4(int n, String element){
        list.addAtPos("R", 1);
        list.addNTimes(element, n);
        assertEquals(n + 1, list.size());
        assertEquals("R", list.getAtPos(1));
        for(int i = 2; i <= n + 1; i++){
            assertEquals(element, list.getAtPos(i));
        }
    }
}
