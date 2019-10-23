import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";
        Set<T> remove = s.newInstance();
        Set<T> transForS = s.newInstance();

        for (int x = 0; x < s.size();) {
            T y = s.removeAny();
            if (this.contains(y)) {
                this.remove(y);
                remove.add(y);
            }
            transForS.add(y);
        }

        s.transferFrom(transForS);

        return remove;

    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> transForS = s.newInstance();

        for (int x = 0; x < s.size();) {
            T y = s.removeAny();
            if (!this.contains(y)) {
                this.add(y);

            } else {

                transForS.add(y);
            }

        }
        s.transferFrom(transForS);

    }

}