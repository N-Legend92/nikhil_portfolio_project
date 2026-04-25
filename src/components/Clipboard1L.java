package components;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code Clipboard} represented as a {@code Sequence<String>} with
 * implementations of primary methods.
 *
 * @convention <pre>
 * Nothing in the list is ever null.
 * </pre>
 * @correspondence <pre>
 * The clipboard is represented by entries in the list in order. The entry at
 * index 0 is the most recently copied entry and the entry in the last index
 * is the oldest entry.
 * </pre>
 */
public class Clipboard1L extends ClipboardSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Sequence<String> list;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.list = new Sequence1L<String>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Clipboard1L() {
        this.createNewRep();
    }

    /**
     * Constructor from {@code String}.
     *
     * @param entry
     *            {@code String} to initialize from
     */
    public Clipboard1L(String entry) {
        assert entry != null : "Violation of: entry is not null";
        this.createNewRep();
        this.list.add(0, entry);
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final Clipboard newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Clipboard source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Clipboard1L : ""
                + "Violation of: source is of dynamic type Clipboard1L";
        Clipboard1L localSource = (Clipboard1L) source;
        this.list = localSource.list;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void copy(String entry) {
        assert entry != null : "Violation of: entry is not null";
        this.list.add(0, entry);
    }

    @Override
    public final String paste() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        return this.list.entry(0);
    }

    @Override
    public final void clearEntry() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        this.list.remove(0);
    }

    @Override
    public final void clearEntry(int index) {
        assert 0 <= index
                && index < this.size() : "Violation of: index is within bounds";
        this.list.remove(index);
    }

    @Override
    public final String entry(int index) {
        assert 0 <= index
                && index < this.size() : "Violation of: index is within bounds";
        return this.list.entry(index);
    }

    @Override
    public final int size() {
        return this.list.length();
    }

    @Override
    public final boolean isEmpty() {
        return this.list.length() == 0;
    }

}
