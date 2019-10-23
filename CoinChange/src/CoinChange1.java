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
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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

        out.print("Enter the amount of cents for change: ");

        final int valueDollar = 100;

        final int valueHalfDollar = 50;

        final int valueQuarter = 25;

        final int valueDime = 10;

        final int valueNickel = 5;

        int cents = Integer.parseInt(in.nextLine());

        int dollar = 0;

        int halfDollar = 0;

        int qurter = 0;

        int dime = 0;

        int nickel = 0;

        int penny = 0;
        if (cents / valueDollar != 0) {

            dollar = cents / valueDollar;

            cents = cents % valueDollar;
        }
        if (cents / valueHalfDollar != 0) {
            halfDollar = cents / valueHalfDollar;

            cents = cents % valueHalfDollar;
        }
        if (cents / valueQuarter != 0) {
            qurter = cents / valueQuarter;

            cents = cents % valueQuarter;
        }
        if (cents / valueDime != 0) {
            dime = cents / valueDime;

            cents = cents % valueDime;
        }
        if (cents / valueNickel != 0) {

            nickel = cents / valueNickel;

            cents = cents % valueNickel;

        } else {
            penny = cents;

        } /*
           * } Close input and output streams
           */
        out.print("Dollar coins: " + dollar + " " + "Half-Dollar: " + halfDollar
                + " " + "Quarter: " + qurter + " " + "Dime: " + dime + " "
                + "Nickel: " + nickel + " " + "Penny: " + penny);

        in.close();
        out.close();
    }

}
