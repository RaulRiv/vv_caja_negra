package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Inserta n veces el elemento al final de la lista.")
public class AddNTimesTest {

    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("CP 0 - Si n es menor que cero lanza IllegalArgumentException")
    @CsvSource(value={"-1,A","-2,A","-1,B","-2,B","-1,M","-2,M","-1,Y","-2,Y","-1,Z","-2,Z","-1,@","-2,@","-1,[","-2,["})
    @ParameterizedTest
    public void testCp0(int n, String element){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            list.addNTimes(element, n);
        });
    }

    @DisplayName("CP 1 - Si n es 0 y la lista está vacía la lista se queda vacía al añadirlo 0 veces")
    @CsvSource(value={"0,A","0,B","0,M","0,Y","0,Z","0,@","0,[",})
    @ParameterizedTest
    public void testCp1(int n, String element){
        //ESTE TEST DA ERROR Y NO DEBERÍA 'No puedes introducir n�meros menores que cero' NO DEJA INTRODUCIR 0
        list.addNTimes(element, n);
        Assert.assertEquals(0, list.size());
    }

    @DisplayName("CP 2 - Si n > 0 y la lista está vacía se añade el elemento n veces al final de la lista")
    @CsvSource(value={"1,A","2,A","1,B","2,B","1,M","2,M","1,Y","2,Y","1,Z","2,Z","1,@","2,@","1,[","2,["})
    @ParameterizedTest
    public void testCp2(int n, String element){
        list.addNTimes(element, n);
        Assert.assertEquals(n, list.size());
        for(int i = 1; i <= n; i++){
            Assert.assertEquals(element, list.getAtPos(i));
        }
    }

    @DisplayName("CP 3 - Si n es 3 (mayor que la longitud) y la lista tiene 1 elemento añade el elemento " +
            "en la última posición(2) y mantiene el original en la primera")
    @CsvSource(value={"3,A","3,B","3,M","3,Y","3,Z","3,@","3,["})
    @ParameterizedTest
    public void testCp3(int position, String element){
        list.addAtPos("R", 1);
        list.addAtPos(element, position);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals("R", list.getAtPos(1));
        Assert.assertEquals(element, list.getAtPos(2));
    }
}
