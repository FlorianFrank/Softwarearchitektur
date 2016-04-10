/* (C) 2016, R. Schiedermeier, rs@cs.hm.edu
 * Hochschule Muenchen, Fakultaet fuer Informatik und Mathematik, Praktikum Software-Architektur
 * Java 1.8.0_72, Linux x86_64 4.3.0
 * emma (Intel Core i7-4790 CPU/3.60GHz, 8 cores, 2600 MHz, 32128 MByte RAM)
 **/

/** Interface fuer Testklassen, die die equals-Methode von SplitString testen.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2016-02-20
 */
@SuppressWarnings("PMD.NoPackage")
public interface SplitStringEqualsTest {
    /** Dieser Test scheitert, wenn SplitString.equals keinen Object-Parameter hat,
     * sondern ueberladen ist.
     */
    void testEqualsParameter();

    /** Dieser Test scheitert, wenn die DualSplitString.equals nicht super.equals aufruft.
     */
    void testEqualsSuperCall();

    /** Dieser Test scheitert, wenn SplitString.equals die Typen mit instanceof vergleicht
     * statt mit Typobjekten.
     */
    void testEqualsTypeCheck() throws NoSuchMethodException;

    /** Dieser Test scheitert, wenn SplitString.equals die Strings mit == statt equals vergleicht.
     */
    void testEqualsStringComparison();

}