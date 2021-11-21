import com.practica.cajanegra.GetAtPos;
import com.practica.cajanegra.IndexOfTest;
import com.practica.cajanegra.ReverseTest;
import com.practica.cajanegra.SizeTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        SizeTest.class,
        ReverseTest.class,
        IndexOfTest.class,
        GetAtPos.class,
})

public class RunTests {
}
