/* (C) 2016, A. Diagne, F. Frank
 * Hochschule München, FK07
 * Praktikum Rechnerarchitektur
 * Oracle Corporation Java 1.8.0_51, OSX 10.11.4
 * emma (Intel Core i5 CPU/2600 MHz, 2 Cores, 8000 MB RAM)
 **/

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** This class Tests the equals-method from the SimpleSplitString- and the DualSplitString-class.
 * @author Florian Frank, Alioun Diagne
 * @version 07-04-2016
 *
 *
 */
@SuppressWarnings(value = {"PMD.NoPackage",
        "PMD.StringInstantiation"})
public class SimpleSplitStringEqualsTest implements SplitStringEqualsTest {


    @Test
    @Override
    public void testEqualsParameter() {
        final SimpleSplitString equalsParameterString1 = new SimpleSplitString("Test123");
        final SimpleSplitString splitString2 = new SimpleSplitString("Test123");
        assertTrue(equalsParameterString1.equals(splitString2));
        assertTrue(equalsParameterString1.equals((Object) splitString2));
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
    public void testEqualsTypeCheck(){
       final SplitString splitString = new SimpleSplitString("test");
       final DualSplitString dualSplitString = new DualSplitString("test");

        assertEquals(splitString.equals(dualSplitString), dualSplitString.equals(splitString));
    }

    @Test
    @Override
    public void testEqualsStringComparison() {
        final SimpleSplitString splitString1 = new SimpleSplitString(new String("String123"));
        final SimpleSplitString splitString2 = new SimpleSplitString(new String("String123"));
        /** Bei einem Vergleich mit == wären die Strings unterschiedlich, da nur die Referenz verglichen wird*/
        assertTrue(splitString1.equals(splitString2));
    }
}
