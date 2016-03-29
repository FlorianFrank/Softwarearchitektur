/* (C) 2016, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_72, Linux i386 4.3.0
 * emma (Intel Core i7-4790 CPU/3601 MHz, 8 Cores, 32000 MB RAM)
 **/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/** Tests fuer Splitstrings mit zwei Cursor.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2016-02-22
 */
public class DualSplitStringTest extends SimpleSplitStringTest {
    private final DualSplitString sut = (DualSplitString)getHello();

    public DualSplitStringTest() {
        super(new DualSplitString(""),
                new DualSplitString("hello"),
                new DualSplitString("hello"),
                new DualSplitString("hello"));
    }

    @Test public void home2ToString() {
        String want = "";
        sut.home2();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forward2ToString() {
        String want = "h";
        sut.home2().forward2();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forward1ToString() {
        String want = "h";
        sut.home2().forward();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forwardEndToString() {
        String want = "hello";
        sut.home2().forward().forward().forward().forward().forward();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forward1forward2x3EndToString() {
        String want = "el";
        sut.home2().forward();
        sut.forward2().forward2().forward2();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forward1x3forward2EndToString() {
        String want = "el";
        sut.home2().forward().forward().forward();
        sut.forward2();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void home2forward1x3forward2x3EndToString() {
        String want = "";
        sut.home2().forward().forward().forward();
        sut.forward2().forward2().forward2();
        String have = sut.toString();
        assertEquals(want, have);
    }

    @Test public void equalsComparesCursor2() {
        DualSplitString helloAgain = (DualSplitString)getHelloAgain();
        sut.home2();
        assertFalse(sut.equals(helloAgain));
    }

    @Test public void home2At2() {
        int want = 0;
        sut.home2();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forward2At2() {
        int want = 1;
        sut.home2().forward2();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forward1At2() {
        int want = 0;
        sut.home2().forward();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forwardEndAt2() {
        int want = 0;
        sut.home2().forward().forward().forward().forward().forward();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forward1forward2x3EndAt2() {
        int want = 3;
        sut.home2().forward();
        sut.forward2().forward2().forward2();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forward1x3forward2EndAt2() {
        int want = 1;
        sut.home2().forward().forward().forward();
        sut.forward2();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

    @Test public void home2forward1x3forward2x3EndAt2() {
        int want = 3;
        sut.home2().forward().forward().forward();
        sut.forward2().forward2().forward2();
        int have = sut.getCursor2();
        assertEquals(want, have);
    }

}