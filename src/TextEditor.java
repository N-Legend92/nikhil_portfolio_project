import components.Clipboard;
import components.Clipboard1L;

/**
 * Text editor that uses Clipboard to manage copy/paste history.
 */
public class TextEditor {

    private String document;
    private Clipboard clipboard;

    public TextEditor() {
        this.document = "";
        this.clipboard = new Clipboard1L();
    }

    /**
     * Copies text into the clipboard history.
     */
    public void copy(String text) {
        this.clipboard.copy(text);
    }

    /**
     * Appends the most recently copied text to the document.
     */
    public void paste() {
        if (!this.clipboard.isEmpty()) {
            this.document += this.clipboard.paste();
        }
    }

    /**
     * Returns the current document contents.
     */
    public String getDocument() {
        return this.document;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.copy("Hello, ");
        editor.copy("World!");
        editor.paste(); // appends "World!"
        editor.paste(); // appends "World!" again

        System.out.println(editor.getDocument()); // "World!World!"
        System.out.println(editor.clipboard); // World!, Hello,
    }
}
