import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        out.print(n);
        while (n != 1) {
            if (n % 2 == 0) {
                out.print(n / 2);

            } else {
                out.print((3 * n) + 1);

            }
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.print("Enter a positive integer greater than 0: ");
        int x = Integer.parseInt(in.nextLine());

        while (x <= 0) {
            out.print("Enter a positive integer greater than 0: ");
            x = Integer.parseInt(in.nextLine());
        }
        generateSeries(x, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
