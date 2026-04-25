import components.standard.Standard;

/**
 * Kernel interface for the Clipboard component.
 */
public interface ClipboardKernel extends Standard<Clipboard> {

    /**
     * Adds {@code entry} to the top of the clipboard history.
     *
     * @param text
     *            the text to copy
     * @updates this
     * @ensures this stays this without changing
     */
    void copy(String text);

    /**
     * Returns the most recently copied entry.
     *
     * @return the most recently copied entry
     * @requires this is not empty
     * @ensures paste remains at this[0]
     */
    String paste();

    /**
     * Removes the most recently copied entry from the clipboard.
     *
     * @requires this is not empty
     * @updates this
     * @ensures the most recently copied entry has been removed from this
     */
    void clearEntry();

    /**
     * Removes the entry at the given index from the clipboard.
     *
     * @param index
     *            the index of the entry to remove
     * @requires index is greater than or equal to 0 and less than this.size()
     * @updates this
     * @ensures the entry at the given index has been removed from this
     */
    void clearEntry(int index);

    /**
     * Returns the entry at the given index without removing it.
     *
     * @param index
     *            the index of the entry to return
     * @return the entry at {@code index}
     * @requires index is greater than or equal to 0 and less than this.size()
     * @ensures entry is the entry at this[{@code index}]
     */
    String entry(int index);

    /**
     * Returns the number of entries stored in the clipboard component.
     *
     * @return the number of entries in this
     * @ensures size is the number of entries in this
     */
    int size();

    /**
     * Returns whether or not the clipboard has no entries.
     *
     * @return true if the clipboard is empty, false if not
     * @ensures isEmpty is true if this has no entries, false if not
     */
    boolean isEmpty();

}
