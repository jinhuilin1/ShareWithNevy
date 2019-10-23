import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Layered implementations of secondary method {@code sort} for
 * {@code Queue<String>}.
 */
public final class Queue1LSort1 extends Queue1L<String> {

    /**
     * No-argument constructor.
     */
    public Queue1LSort1() {
        super();
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * (q * <removeMin>) is permutation of #q  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";
        Queue<String> noMin = q.newInstance();

        String min = q.dequeue();
        while (q.length() > 0) {

            String i1 = q.dequeue();

            if (order.compare(min, i1) >= 0) {
                noMin.enqueue(min);
                min = i1;

            } else {
                noMin.enqueue(i1);

            }
        }
        q.transferFrom(noMin);
        return min;

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */

    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
//    public static void sort(Queue<String> q, Comparator<String> order) {
//        Queue<String> sort = q.newInstance();
//        while (q.length() > 0) {
//            String min = removeMin(q, order);
//            sort.enqueue(min);
//        }
//        q.transferFrom(sort);
//
//    }

    @Override
    public void sort(Comparator<String> order) {
        assert order != null : "Violation of: order is not null";
        Queue<String> sort = this.newInstance();
        while (this.length() > 0) {
            String min = removeMin(this, order);
            sort.enqueue(min);
        }
        this.transferFrom(sort);

    }
}
