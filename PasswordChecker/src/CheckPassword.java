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
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        if (lengthCheck(s)) {

            int count = 4;
            String[] error = { "", "", "", "" };

            if (!containsUpperCaseLetter(s)) {
                count--;
                error[0] = "Upper Case Letter ";
            }

            if (!containsLowerCaseLetter(s)) {
                count--;
                error[1] = "Lower Case Letter ";
            }

            if (!containsDigits(s)) {
                count--;
                error[2] = "Digits ";
            }
            if (!containsSepcialCase(s)) {
                count--;
                error[3] = "Special case ";
            }

            if (count >= 3) {
                out.println("criteria met ");
            }
            if (count < 3) {
                out.print("The criteria(s) not met is(are): ");

                for (int x = 0; x < error.length; x++) {
                    out.print(error[x]);
                }

            }

        }

        else {
            out.println(
                    "The password entered does not meet the length criteria");
        }

    }

    /**
     * Check for the length of the string.
     *
     * @param s
     *            the string to check
     * @return lengthCheck Return if it's true.
     */
    private static boolean lengthCheck(String s) {
        boolean check = false;
        final int critiera = 8;
        if (s.length() >= critiera) {
            check = true;
        }
        return check;
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        boolean check = false;
        for (int x = 0; x < s.length(); x++) {
            if (Character.isUpperCase(s.charAt(x))) {
                check = true;
            }
        }
        return check;

    }

    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper lower letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        boolean check = false;
        for (int x = 0; x < s.length(); x++) {
            if (Character.isLowerCase((s.charAt(x)))) {
                check = true;
            }
        }
        return check;

    }

    /**
     * Checks if the given String contains an digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains an digit, false otherwise
     */
    private static boolean containsDigits(String s) {
        boolean check = false;
        for (int x = 0; x < s.length(); x++) {
            if (Character.isDigit(((s.charAt(x))))) {
                check = true;
            }
        }
        return check;

    }

    /**
     * Checks if the given String contains a special case.
     *
     * @param s
     *            the String to check
     * @return true if s contains an special case, false otherwise
     */
    private static boolean containsSepcialCase(String s) {
        boolean check = false;
        String[] specialChar = { "!", "@", "#", "$", "%", "^", "&", "*", "(",
                ")", "_", "-", "+", "=", "[", "{", "}", "]", "\\", "|", ";",
                ":", "'", "\"", "<", ",", ">", ".", "?", "/", "~" };

        for (int x = 0; x < s.length(); x++) {
            for (int y = 0; y < specialChar.length; y++) {
                if (Character.toString(s.charAt(x)).equals(specialChar[y])) {
                    check = true;
                }
            }
        }
        return check;
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
        out.print("Input your desired password: ");
        String password = in.nextLine();

        checkPassword(password, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
