/* (C) 2016, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_72, Linux i386 4.3.0
 * emma (Intel Core i7-4790 CPU/3601 MHz, 8 Cores, 32000 MB RAM)
 **/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.stream.IntStream;

/** Tests fuer Splitstrings.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2016-02-19
 */
public class SimpleSplitStringTest {
    private final SimpleSplitString empty;

    private final SimpleSplitString hello;

    private final SimpleSplitString helloAgain;

    private final SimpleSplitString helloOnceAgain;

    public SimpleSplitStringTest() {
        empty = new SimpleSplitString("");
        hello = new SimpleSplitString("hello");
        helloAgain = new SimpleSplitString("hello");
        helloOnceAgain = new SimpleSplitString("hello");
    }

    SimpleSplitStringTest(SimpleSplitString empty, SimpleSplitString hello, SimpleSplitString helloAgin, SimpleSplitString helloOnceAgain) {
        this.empty = empty;
        this.hello = hello;
        this.helloAgain = helloAgin;
        this.helloOnceAgain = helloOnceAgain;
    }

    @Test(expected = java.lang.NullPointerException.class, timeout = 100)
    public void ctorRejectsNull() {
        new SimpleSplitString(null);
    }

    @Test(timeout = 100)
    public void emptyToString() {
        SimpleSplitString sut = empty;
        String want = "";
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void emptyForwardToString() {
        SimpleSplitString sut = empty;
        String want = "";
        String have = sut.forward().toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void emptyForwardHomeToString() {
        SimpleSplitString sut = empty;
        String want = "";
        String have = sut.forward().home().toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void emptyAt() {
        SimpleSplitString sut = empty;
        int want = 0;
        int have = sut.getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void emptyForwardAt() {
        SimpleSplitString sut = empty;
        int want = 0;
        int have = sut.forward().getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void emptyForwardHomeAt() {
        SimpleSplitString sut = empty;
        int want = 0;
        int have = sut.forward().home().getCursor();
        assertEquals(want, have);
    }

    public SimpleSplitString getEmpty() {
        return empty;
    }

    public SimpleSplitString getHello() {
        return hello;
    }

    public SimpleSplitString getHelloAgain() {
        return helloAgain;
    }

    public SimpleSplitString getHelloOnceAgain() {
        return helloOnceAgain;
    }

    @Test(timeout = 100)
    public void helloToString() {
        SimpleSplitString sut = hello;
        String want = "hello";
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardToString() {
        SimpleSplitString sut = hello;
        String want = "ello";
        String have = sut.forward().toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardToEndToString() {
        SimpleSplitString sut = hello;
        String want = "";
        String have = sut.forward().forward().forward().forward().forward().toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardBeyondEnd() {
        SimpleSplitString sut = hello;
        String want = "";
        IntStream.range(0, 100).forEach(n -> sut.forward());
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardBeyondEndHomeToString() {
        SimpleSplitString sut = hello;
        String want = "hello";
        IntStream.range(0, 100).forEach(n -> sut.forward());
        IntStream.range(0, 100).forEach(n -> sut.home());
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloAt() {
        SimpleSplitString sut = hello;
        int want = 0;
        int have = sut.getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardAt() {
        SimpleSplitString sut = hello;
        int want = 1;
        int have = sut.forward().getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardToEndAt() {
        SimpleSplitString sut = hello;
        int want = 5;
        int have = sut.forward().forward().forward().forward().forward().getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardBeyondEndAt() {
        SimpleSplitString sut = hello;
        int want = 5;
        IntStream.range(0, 100).forEach(n -> sut.forward());
        int have = sut.getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void helloForwardBeyondEndHomeAt() {
        SimpleSplitString sut = hello;
        int want = 0;
        IntStream.range(0, 100).forEach(n -> sut.forward());
        IntStream.range(0, 100).forEach(n -> sut.home());
        int have = sut.getCursor();
        assertEquals(want, have);
    }

    @Test(timeout = 100)
    public void notEqualsNull() {
        SimpleSplitString sut = hello;
        assertFalse(sut.equals(null));
    }

    @Test(timeout = 100)
    public void equalsReflexive() {
        SimpleSplitString sut = hello;
        assertTrue(sut.equals(sut));
    }

    @Test(timeout = 100)
    public void equalsComparesStringsIfDifferent() {
        SimpleSplitString sut = hello;
        assertFalse(sut.equals(empty));
    }

    @Test(timeout = 100)
    public void equalsComparesStringsIfEqual() {
        SimpleSplitString sut = hello;
        assertTrue(sut.equals(helloAgain));
    }

    @Test(timeout = 100)
    public void equalsComparesCursors() {
        SimpleSplitString sut = hello;
        helloAgain.forward();
        assertFalse(sut.equals(helloAgain));
    }

    @Test(timeout = 100)
    public void equalsIsSymmetric() {
        SimpleSplitString sut = hello;
        assertEquals(sut.equals(empty), empty.equals(sut));
    }

    @Test(timeout = 100)
    public void equalsIsTransitive() {
        SimpleSplitString sut = hello;
        assertTrue(sut.equals(helloAgain));
        assertTrue(helloAgain.equals(helloOnceAgain));
        assertTrue(sut.equals(helloOnceAgain));
    }

}