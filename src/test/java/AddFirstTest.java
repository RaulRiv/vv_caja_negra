import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Añade un elemento pasado por parámetro al principio de la lista")
public class AddFirstTest {
    AbstractSingleLinkedListImpl<String> list;
    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }

    @DisplayName("Añade un elemento a una lista vacía")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void test(String element){
        list.addFirst(element);
        assertEquals(1, list.size());
    }

    @DisplayName("Añade un elemento a una lista con un elemento")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void test2(String element){
        String testElement = "foo";
        list = new SingleLinkedListImpl<>(testElement);
        list.addFirst(element);
        assertEquals(2, list.size());
    }

    @DisplayName("Añade un elemento a una lista con un elemento")
    @ValueSource(strings={"A","B","M","Y","Z","@","["})
    @ParameterizedTest
    public void test3(String element){
        String testElement1 = "foo1";
        String testElement2 = "foo2";
        list = new SingleLinkedListImpl<>(testElement1,testElement2);
        list.addFirst(element);
        assertEquals(3, list.size());
    }
}
