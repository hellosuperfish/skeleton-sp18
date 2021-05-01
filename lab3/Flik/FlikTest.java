import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void HorribleSteveTest(){
        assertTrue(Flik.isSameNumber(null, null));
        assertTrue(Flik.isSameNumber(1, 1));
    }
}
