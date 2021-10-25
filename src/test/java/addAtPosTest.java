import com.cajanegra.AbstractSingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class addAtPosTest {
    AbstractSingleLinkedListImpl<String> list;

    @BeforeEach
    public void setup(){
        list = new SingleLinkedListImpl<>();
    }
    // anterior @ y siguiente [
    @ParameterizedTest
    @CsvSource({"@,1,0","],1,0","A,1,1","Z,1,1","B,1,1","Y,1,1","R,1,1"})
    public void paramTest1(String t, String pos, String size){
        list.addAtPos(t, Integer.parseInt(pos));
        assertEquals(Integer.parseInt(size), list.size());
    }


}
