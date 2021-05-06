import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testOffByN {

    static CharacterComparator obn5 = new OffByN(5);
    static CharacterComparator obn0 = new OffByN(0);

    @Test
    public void offByNTest() {
        assertTrue(obn5.equalChars('a', 'f'));
        assertTrue(obn5.equalChars('f', 'a'));
        assertTrue(obn0.equalChars('0', '0'));
        assertFalse(obn0.equalChars('a', 'z'));
    }
}
