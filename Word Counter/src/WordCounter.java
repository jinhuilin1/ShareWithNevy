import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program is designed to output a HTML file with glossy of words and their
 * number of occurrence given the user input text file.
 *
 *
 * @author Jin Lin
 * @date 08/29/2019
 */
public final class WordCounter {

    /**
     * Default constructor--private to prevent instantiation.
     */
    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    private WordCounter() {
        // no code needed here
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
    private static void generateSeperatorElements(String str,
            Set<Character> strSet) {
        Set<Character> trans = new Set1L<>();

        //check for every character in "str". if it's an unique character
        //the set "strSet",then add it to the set. if not, do not add.
        for (int x = 0; x < str.length(); x++) {
            char y = str.charAt(x);
            if (!trans.contains(y)) {
                trans.add(y);
            }
        }

        strSet.transferFrom(trans);
    }

    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {

        //character to check if its a Separator or word
        char check = text.charAt(position);

        //declear the string for return
        String nextWordorSeparator = text.substring(position, position + 1);

        boolean separator = false;

        //if the character at position is a separator, keep on adding separators
        //to the string "nextWordOrSeparator until reaches a letter/"word"
        if (separators.contains(check)) {

            for (int x = position + 1; x < text.length() && !separator; x++) {
                char check2 = text.charAt(x);
                if (separators.contains(check2)) {
                    nextWordorSeparator = nextWordorSeparator + check2;
                } else {
                    separator = true;
                }

            }

            //if the character at position is a "word", keep on adding words
            //to string "nextWordOrSeparator until reaches a separator
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

    /*
     * This program output the opening tags of a HTML page with a designated
     * style for WordCounter table given "output" {@code SimpleWriter},
     *
     * @param output the given {SimpleWriter}
     * 
     * @requires <pre> "output" {@code SimpleWriter} is not closed </pre>
     *
     * @ensures outputs the openings tags for WordCounter html page
     */
    private static void openingHTML(SimpleWriter output) {

        output.println("<!DOCTYPE html>");

        output.println("<html lang=\"en\">");
        output.println("<head>");
        output.println("<meta charset=\"UTF-8\">");
        output.println("<Style>");
        output.println(
                "table, th, td{ border: 1px solid black; padding: 5px;}");
        output.println("table{ border-spacing: 15px;}");
        output.println("</style>");

        //set the title of the page
        output.println("<title>Word Count</title></head>");

        output.println("<body>");
        output.println("<h1>Word Count</h1>");
        output.println("<hr>");
        output.println("<h3>Words</h3>");

        //set up the table tag
        output.println("<table style=\"width:100%\">");

    }

    /*
     * This program output the table tags of a HTML page with a designated style
     * for WordCounter program given "output" {@code SimpleWriter}, "words"
     * {@code Queue <String>) "wordAndCount" {@code Map<String, Integer>}.
     *
     * @param output the given {@code SimpleWriter}
     * 
     * @param words the given {@code Queue <String>}
     * 
     * @param words the given {@code Map <String, Integer>}
     * 
     * @requires <pre> "output" {@code SimpleWriter} is not closed </pre>
     *
     * @ensures outputs the openings tags for WordCounter html page
     */
    private static void tableWordOuput(Queue<String> words,
            Map<String, Integer> wordAndCount, SimpleWriter output) {

        //create a new Queue object to restore "word" queue
        Queue<String> copy = words.newInstance();

        //take every element (string) out of the sorted queue "words", and output html table out
        //of it
        for (int x = 0; words.length() > x;) {
            output.println("<tr>");

            String word = words.dequeue();

            output.println("<td>" + word + "</td>");

            //output the corresponding word count
            output.println("<td>" + wordAndCount.value(word) + "</td>");

            copy.enqueue(word);

            output.println("</tr>");
        }
        output.print("</table>");

        //restore the "word"
        words.transferFrom(copy);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        SimpleReader in = new SimpleReader1L();

        //read from user inputs for input and output file path
        out.print("The path of desired Input file: ");
        String inputFile = in.nextLine();

        out.print("The path of desired Output file: ");
        String outputFile = in.nextLine();

        SimpleWriter output = new SimpleWriter1L(outputFile);

        SimpleReader reader = new SimpleReader1L(inputFile);

        //defining what seperatros are and put them into a set
        final String seperators = " \t\n\r,.\"?!;'/|\\{}-";
        Set<Character> seperatorsSet = new Set1L<>();
        generateSeperatorElements(seperators, seperatorsSet);

        //crate a map and a sequence for sorting
        Map<String, Integer> wordsAndCount = new Map1L<>();
        Queue<String> words = new Queue1L();

        //read each line until reaching the end of the text file
        while (!reader.atEOS()) {
            //creating a initial position to read each line
            int position = 0;

            String line = reader.nextLine();

            while (position < line.length()) {

                String word = nextWordOrSeparator(line, position,
                        seperatorsSet);
                //if the first character of the returned string is
                //also an element of the "SeperatorsSet" set, don't add.
                //if not, add.
                if (!seperatorsSet.contains(word.charAt(0))) {
                    //check to see if the word has already been added
                    if (!wordsAndCount.hasKey(word)) {

                        //add to the map and start the count;

                        wordsAndCount.add(word, 1);

                        //add to the quene
                        words.enqueue(word);
                    }

                    //if it has the word as a key in the map, then add one to
                    //the corresponding integer
                    else {
                        int count = wordsAndCount.value(word);

                        count++;

                        wordsAndCount.replaceValue(word, count);
                    }

                }
                //add to the position count after finding the word
                position += word.length();

            }
        }

        //close the reader for input text
        reader.close();

        //calling the comparator constructor for string
        Comparator<String> cs = new StringLT();

        //sort the queue
        words.sort(cs);

        //output the opening tag to designated output file
        openingHTML(output);

        //output the table of words and counts to the designated output file
        tableWordOuput(words, wordsAndCount, output);

        //start of the table
        output.println("<tr>");
        output.println("<th>" + "Word" + "</th>");
        output.println("<th>" + "Count" + "</th>");
        output.println("</tr>");

        //closing tags
        output.println("</body>");
        output.println("</html>");

        //close the Simplewriter
        output.close();

    }
}
