import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test static methods {@code generateElements} and
 * {@code nextWordOrSeparator}.
 *
 * @author Put your name here
 *
 */
public final class NextWordOrSeparatorTest {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NextWordOrSeparatorTest() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces strSet
     * @ensures strSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> strSet) {
        Set<Character> trans = new Set1L<>();
        for (int x = 0; x < str.length(); x++) {
            char y = str.charAt(x);
            if (!trans.contains(y)) {
                trans.add(y);
            }
        }
        strSet.transferFrom(trans);
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        char check = text.charAt(position);
        String nextWordorSeparator = text.substring(position, position + 1);

        boolean separator = false;

        if (separators.contains(check)) {

            for (int x = position + 1; x < text.length() && !separator; x++) {
                char check2 = text.charAt(x);
                if (separators.contains(check2)) {
                    nextWordorSeparator = nextWordorSeparator + check2;
                } else {
                    separator = true;
                }

            }

        } else {
            for (int x = position + 1; x < text.length() && !separator; x++) {
                char check2 = text.charAt(x);
                if (!separators.contains(check2)) {
                    nextWordorSeparator = nextWordorSeparator + check2;
                } else {
                    separator = true;
                }
            }
        }
        return nextWordorSeparator;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Define separator characters for test
         */
        final String separatorStr = " \t,.?! ";
        Set<Character> separatorSet = new Set1L<>();
        generateElements(separatorStr, separatorSet);
        /*
         * Open input and output streams
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Ask for test cases
         */
        out.println();
        out.print("New test case (y/n)? ");
        String response = in.nextLine();
        while (response.equals("y")) {
            /*
             * Output heading
             */
            out.print("Test case: ");
            String testStr = in.nextLine();
            out.println();
            out.println("----Next test case----");
            out.println();
            /*
             * Process test case
             */
            int position = 0;
            while (position < testStr.length()) {
                String token = nextWordOrSeparator(testStr, position,
                        separatorSet);
                if (separatorSet.contains(token.charAt(0))) {
                    out.print("  Separator: <");
                } else {
                    out.print("  Word: <");
                }
                out.println(token + ">");
                position += token.length();
            }
            /*
             * Ask user whether to continue
             */
            out.println();
            out.print("New test case (y/n)? ");
            response = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}