import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {
    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas6.toStringWithCommas(n);
    }
    //Test4? , Test6?
    //Test5 doesn't restore the n;

    @Test
    public void testToStringWithCommas234() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(234);
        NaturalNumber nExpected = new NaturalNumber2(234);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "234";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }

    @Test
    public void testToStringWithCommas1244444444() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(1244444444);
        NaturalNumber nExpected = new NaturalNumber2(1244444444);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "1,244,444,444";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);
        assertEquals(rtExpected, rt);
    }

    @Test
    public void testToStringWithCommas124444444() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(124444444);
        NaturalNumber nExpected = new NaturalNumber2(124444444);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "124,444,444";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }

    @Test
    public void testToStringWithCommas2443() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(2443);
        NaturalNumber nExpected = new NaturalNumber2(2443);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "2,443";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }
    //test2 has problem with odd number of digits

    @Test
    public void testToStringWithCommas22443() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(22443);
        NaturalNumber nExpected = new NaturalNumber2(22443);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "22,443";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }

    @Test
    public void testToStringWithCommas234333() {
        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(234333);
        NaturalNumber nExpected = new NaturalNumber2(234333);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "234,333";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }

    @Test
    public void testToStringWithCommas0() {

        /* Set up variables and call method under test */
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);

        String rt = redirectToMethodUnderTest(n);
        String rtExpected = "0";
        /* Assert that values of variables match expectations */
        assertEquals(nExpected, n);

        assertEquals(rtExpected, rt);
    }
    //Test3 has a problem with this, which shows that the method doesn't know how
    //handle a 0 NN

}
