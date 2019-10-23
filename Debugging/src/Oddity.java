import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Oddity {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Oddity() {
    }

    /**
     * Returns a modulo b using "clock arithmetic".
     *
     * @param a
     *            the first operand
     * @param b
     *            the modulus
     * @return a modulo b
     * @requires b > 0
     * @ensures mod = a mod b
     */
    private static int mod(int a, int b) {
        int mod = a % b;
        if (mod < 0) {
            mod = mod + b;
        }
        return mod;

    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */

    /*
     * final int[] values = { 8, -4, 3, 0, -5 }; int i = 0; while (i <
     * values.length) { int remainder = Math.abs(values[i] % 2); if (remainder
     * == 1) { out.println("odd"); } else { out.println("even"); } i = i + 1; }
     */

    /*
     * public static void main(String[] args) { SimpleWriter out = new
     * SimpleWriter1L(); double x = 456.0; double y = 100.0 * 4.56; if
     * (Math.abs(x - y) < .00001) { out.println("equal"); } else {
     * out.println("not equal"); }
     */

    /*
     * public static void main(String[] args) { SimpleWriter out = new
     * SimpleWriter1L(); final double microsPerDay = (24 * 60 * 60 * 1000) *
     * 1000; final double millisPerDay = 24 * 60 * 60 * 1000;
     * out.println(microsPerDay / millisPerDay); out.close(); }
     */

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        out.println(12345 + 54321);
        out.close();
    }

    /*
     * Close input and output streams
     */

}
