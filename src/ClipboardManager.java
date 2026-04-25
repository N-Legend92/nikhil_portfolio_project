import components.Clipboard;
import components.Clipboard1L;

/**
 * Demonstrates Clipboard in a simple clipboard manager.
 */
public class ClipboardManager {

    public static void main(String[] args) {
        Clipboard clipboard = new Clipboard1L();

        clipboard.copy("buy groceries");
        clipboard.copy("meeting at 3pm");
        clipboard.copy("buy groceries"); // duplicate
        clipboard.copy("call mom");

        System.out.println("History:  " + clipboard);
        // call mom, buy groceries, meeting at 3pm, buy groceries

        clipboard.removeDuplicates();
        System.out.println("Deduped:  " + clipboard);
        // call mom, buy groceries, meeting at 3pm

        clipboard.pin(2); // promote oldest to top
        System.out.println("Pinned:   " + clipboard);
        // meeting at 3pm, call mom, buy groceries

        System.out.println("Oldest:   " + clipboard.oldest()); // buy groceries
        System.out.println(
                "Contains 'call mom': " + clipboard.contains("call mom")); // true
    }
}
