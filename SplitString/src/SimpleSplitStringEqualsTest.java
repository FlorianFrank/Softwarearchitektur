import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** This class Tests the equals-method from the SimpleSplitString- and the DualSplitString-class.
 * @author florianfrank
 * @version 07-04-2016
 *
 *
 */
public class SimpleSplitStringEqualsTest implements SplitStringEqualsTest {


    @Override
    @Test
    public void testEqualsParameter() {
        final SimpleSplitString splitstring1 = new SimpleSplitString("Test123");
        final SimpleSplitString splitstring2 = splitstring1;
        final Object splitString3 = new SimpleSplitString("Test123");
        assertEquals(splitstring1.equals(splitstring2),splitstring2.equals(splitString3));
    }
    @Test
    @Override
    public void testEqualsSuperCall() {
        final DualSplitString splitString1 = new DualSplitString("EqualSuperCallTest123");
        final DualSplitString splitString2 = new DualSplitString("EqualSuperCallTest123");
        splitString1.forward();
         assertFalse(splitString1.equals(splitString2));
    }
    @Test
    @Override
    public void testEqualsTypeCheck() throws NoSuchMethodException {
        /** derived Class to check if the equals method contains a comparison by instance of
         *
          */
        class DerivedSimpleSplitString extends SimpleSplitString{
             /** sets string.
              * @param string delivered Strings
              */
             DerivedSimpleSplitString(String string){
              super(string);
            }
        }

        final DerivedSimpleSplitString derivedSimpleSplitString = new DerivedSimpleSplitString("DerivedTest123");
        final SimpleSplitString splitstring1 = new SimpleSplitString("DerivedTest123");
        assertFalse(splitstring1.equals(derivedSimpleSplitString));
    }

    @Test
    @Override
    public void testEqualsStringComparison() {
        final SimpleSplitString splitString1 = new SimpleSplitString(new String("StringTest123"));
        final SimpleSplitString splitString2 = new SimpleSplitString(new String("StringTest123"));
        assertTrue(splitString1.equals(splitString2));
    }
}
