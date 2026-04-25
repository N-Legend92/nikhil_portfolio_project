import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof of concept for the component.
 */

public class ClipboardProof {

    //Kernel methods

    /**
     * List of all the copied entries.
     */
    private Sequence<String> list = new Sequence1L<>();

    /**
     * Adds a copy of the entry to the top of the list.
     */
    void copy(String entry) {
        this.list.add(0, entry);
    }

    /**
     * Returns most recently copied entry.
     */
    String paste() {
        return this.list.entry(0);
    }

    /**
     * Removes the top entry from the list
     */
    void clearEntry() {
        this.list.remove(0);
    }

    /**
     * Returns the number of entries currently stored.
     */
    int size() {
        return this.list.length();
    }

    /**
     * Returns whether the clipboard has no entries.
     */
    boolean isEmpty() {
        return this.list.length() == 0;
    }

    //Secondary methods

    /**
     * Returns true if text exists anywhere in the clipboard history.
     */
    boolean contains(String text) {
        boolean bool = false;
        Sequence<String> temp = new Sequence1L<>();
        int length = this.size();
        for (int i = 0; i < length; i++) {
            String entry = this.paste();
            this.clearEntry();
            if (entry.equals(text)) {
                bool = true;
            }
            temp.add(temp.length(), entry);
        }
        for (int i = 0; i < temp.length(); i++) {
            this.list.add(i, temp.entry(i));
        }
        return bool;
    }

    /**
     * Returns the oldest entry in the clipboard history without removing it.
     */
    String oldest() {
        Sequence<String> temp = new Sequence1L<>();
        int length = this.size();
        String old = "";
        for (int i = 0; i < length; i++) {
            String entry = this.paste();
            this.clearEntry();
            if (i == length - 1) {
                old = entry;
            }
            temp.add(temp.length(), entry);
        }
        for (int i = 0; i < temp.length(); i++) {
            this.list.add(i, temp.entry(i));
        }
        return old;
    }

    /**
     * Main method demonstrating the clipboard component in action.
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        ClipboardProof clipboard = new ClipboardProof();

        // User copies a few things
        out.println("Enter items to copy to clipboard:");
        out.print("Item 1: ");
        clipboard.copy(in.nextLine());
        out.print("Item 2: ");
        clipboard.copy(in.nextLine());
        out.print("Item 3: ");
        clipboard.copy(in.nextLine());
        out.print("Item 4: ");
        clipboard.copy(in.nextLine());

        // User wants to know how many entries are in the clipboard
        out.println("Items in clipboard: " + clipboard.size());

        // User wants to paste item
        out.println("Pasting: " + clipboard.paste());

        // User wants to paste second most recent item
        clipboard.clearEntry();
        out.println("Pasting second most recent item: " + clipboard.paste());

        // User wants to know how many entries are in the clipboard
        out.println("Items in clipboard: " + clipboard.size());

        // User wants to know what they copied first
        out.println("Oldest: " + clipboard.oldest());

        // User searches for something they copied earlier
        out.print("Enter a term to search for: ");
        String search = in.nextLine();
        out.println("Contains " + search + ": " + clipboard.contains(search));

        // User wants to clear out items
        out.println("Clearing items");
        while (!clipboard.isEmpty()) {
            clipboard.clearEntry();
        }
        out.println("Is clipboard empty? " + clipboard.isEmpty());

        // User wants to know how many entries are in the clipboard
        out.println("Items in clipboard: " + clipboard.size());

        in.close();
        out.close();
    }

}
