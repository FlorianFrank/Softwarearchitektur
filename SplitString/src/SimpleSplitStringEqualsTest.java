

/**
 * Created by florianfrank on 04.04.16.
 */
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleSplitStringEqualsTest implements SplitStringEqualsTest {


    @Override
    @Test
    public void testEqualsParameter() {
        final SimpleSplitString splitstring1 = new SimpleSplitString("Test123");
        assertEquals(splitstring1.equals(splitstring1),splitstring1.equals((Object) splitstring1));
    }
    @Test
    @Override
    public void testEqualsSuperCall() {
        final DualSplitString splitString1 = new DualSplitString("Test123");
        final DualSplitString splitString2 = new DualSplitString("Test123");
        splitString1.forward();
         assertFalse(splitString1.equals(splitString2));
    }
    @Test
    @Override
    public void testEqualsTypeCheck() throws NoSuchMethodException {

    }

    @Test
    @Override
    public void testEqualsStringComparison() {
        final SimpleSplitString splitString1 = new SimpleSplitString(new String("Test123"));
        final SimpleSplitString splitString2 = new SimpleSplitString(new String("Test123"));
        System.out.println(splitString2.equals(splitString1));
        assertTrue(splitString1.equals(splitString2));
    }
}
