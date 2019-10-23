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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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

        int cents = Integer.parseInt(in.nextLine());

        final int[] coinDemo = { 100, 50, 25, 10, 5, 1 };

        int[] changeCoin = new int[coinDemo.length];

        for (int x = 0; x < coinDemo.length; x++) {
            changeCoin[x] = cents / coinDemo[x];
            cents = cents % coinDemo[x];
        }
        String[] namesCoin = { "Dollar Coins: ", "Half-Dollar: ", "Quarter: ",
                "Dime: ", "Nickel: ", "Penny: " };

        for (int x = 0; x < coinDemo.length; x++) {
            out.println(namesCoin[x] + changeCoin[x]);
        }

        in.close();
        out.close();
    }

}
