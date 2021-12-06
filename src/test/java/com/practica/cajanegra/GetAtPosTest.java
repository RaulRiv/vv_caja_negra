package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetAtPosTest {

    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        this.list = new SingleLinkedListImpl<>();
    }

    @Test
    public void InvalidIndexZeroLengthList(){
        int index = 0;
        Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> this.list.getAtPos(index));
        assertEquals(java.lang.IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void IndexOutOfBoundsZeroLengthList(){
        int index = 1;
        Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> this.list.getAtPos(index));
        assertEquals(java.lang.IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void InvalidIndexList(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 0;
        Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> this.list.getAtPos(index));
        assertEquals(java.lang.IllegalArgumentException.class, exception.getClass());
    }

    @Test
    public void IndexOutOfBounds(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 6;
        Exception exception = assertThrows(java.lang.IllegalArgumentException.class, () -> this.list.getAtPos(index));
        assertEquals(java.lang.IllegalArgumentException.class, exception.getClass());

    }

    @Test
    public void FirstValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 1;
        assertEquals("A", this.list.getAtPos(index));
    }

    @Test
    public void LastValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 5;
        assertEquals("E", this.list.getAtPos(index));
    }

    @Test
    public void MiddleValidIndex(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 3;
        assertEquals("C", this.list.getAtPos(index));

    }

    @Test
    public void MiddleValidIndexForValidElement(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "E");
        int index = 5;
        assertEquals("C", this.list.getAtPos(index));

    }

    @Test
    public void FirstValidIndexForInvalidElement(){
        this.list = new SingleLinkedListImpl<>("#", "B", "C", "D", "E");
        int index = 1;
        assertEquals("C", this.list.getAtPos(index));

    }

    @Test
    public void LastValidIndexForInvalidElement(){
        this.list = new SingleLinkedListImpl<>("A", "B", "C", "D", "#");
        int index = 5;
        assertEquals("C", this.list.getAtPos(index));

    }

    @Test
    public void MiddleValidIndexForInvalidElement(){
        this.list = new SingleLinkedListImpl<>("A", "B", "#", "D", "E");
        int index = 3;
        assertEquals("C", this.list.getAtPos(index));

    }

}
