import com.practica.cajanegra.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        SizeTest.class,
        ReverseTest.class,
        IndexOfTest.class,
        AddFirstTest.class,
        AddLastTest.class,
        ToStringTest.class,
})

public class RunTests {
}
