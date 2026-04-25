/**
 * {@code ClipboardKernel} enhanced with secondary methods.
 */
public interface Clipboard extends ClipboardKernel {

    /**
     * Returns true if {@code text} exists in the clipboard list.
     *
     * @param text
     *            the text to search for
     * @return true if the clipboard contains {@code text}, false if not
     * @ensures contains is true if text is found in this, false if not
     */
    boolean contains(String text);

    /**
     * Returns the oldest entry in the clipboard history without removing it.
     *
     * @return the oldest entry in this
     * @requires this is not empty
     * @ensures oldest is the entry that was copied least recently in this
     */
    String oldest();

    /**
     * Moves the entry at {@code index} to the top of the clipboard list.
     *
     * @param index
     *            the index of the entry for pin
     * @requires index is greater than or equal to 0 and less than this.size()
     * @updates this
     * @ensures the entry previously at {@code index} is now at the top of this
     */
    void pin(int index);

    /**
     * Removes all duplicate entries from the clipboard history, keeps only the
     * most recent copy.
     *
     * @updates this
     * @ensures all entries in this are unique and the most recent copy of each
     *          entry has been kept
     */
    void removeDuplicates();

}
