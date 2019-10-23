import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_24_60() {
        NaturalNumber n = new NaturalNumber2(24);
        NaturalNumber m = new NaturalNumber2(60);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("12", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    @Test
    public void testIsEven_5() {
        NaturalNumber n = new NaturalNumber2(5);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("5", n.toString());
        assertTrue(!result);
    }

    @Test
    public void testIsEven_4() {
        NaturalNumber n = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("4", n.toString());
        assertTrue(result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    @Test
    public void testPowerMod_3_2_4() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(4);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("2", p.toString());
        assertEquals("4", m.toString());
    }

    @Test
    public void testPowerMod_4_2_8() {
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(8);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("0", n.toString());
        assertEquals("2", p.toString());
        assertEquals("8", m.toString());
    }
    /*
     * Tests of isWitnessToCompositeness
     */

    @Test

    public void isWitnessToCompositeness_2_6() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(6);

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("2", w.toString());
        assertEquals("6", n.toString());
        assertTrue(result);
    }

    public void isWitnessToCompositeness_1_3() {
        NaturalNumber w = new NaturalNumber2(1);
        NaturalNumber n = new NaturalNumber2(3);

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("1", w.toString());
        assertEquals("3", n.toString());
        assertTrue(result);
    }
    /*
     * Tests of isPrime2
     */

    @Test

    public void isPrime2_1() {
        NaturalNumber n = new NaturalNumber2(2);

        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("2", n.toString());
        assertTrue(result);
    }

    public void isPrime2_3() {
        NaturalNumber n = new NaturalNumber2(3);

        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("3", n.toString());
        assertTrue(result);
    }

    public void isPrime2_4() {
        NaturalNumber n = new NaturalNumber2(4);

        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("4", n.toString());
        assertTrue(!result);
    }

    public void isPrime2_17() {
        NaturalNumber n = new NaturalNumber2(17);

        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("17", n.toString());
        assertTrue(result);
    }

    /*
     * Tests of generateNextLikelyPrime
     */

    @Test

    public void generateNextLikelyPrime_2() {
        NaturalNumber n = new NaturalNumber2(2);

        CryptoUtilities.generateNextLikelyPrime(n);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(result);

    }

    public void generateNextLikelyPrime_4() {
        NaturalNumber n = new NaturalNumber2(4);

        CryptoUtilities.generateNextLikelyPrime(n);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(result);
    }

    public void generateNextLikelyPrime_27() {
        NaturalNumber n = new NaturalNumber2(27);

        CryptoUtilities.generateNextLikelyPrime(n);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(result);
    }
}
