/**
 * Clipboard kernel tests.
 */

package components.clipboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.Clipboard;
import components.Clipboard1L;

/**
 * Clipboard Kernel tests.
 */
public class Clipboard1LTest {

    // test copy

    /**
     * Tests copy one.
     */
    @Test
    public void testCopyOne() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("hello");
        cCopy.copy("hello");
        assertEquals("hello", c.paste());
        assertEquals(cCopy, c);
    }

    /**
     * Tests copy multiple.
     */
    @Test
    public void testCopyMultiple() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        cCopy.copy("first");
        cCopy.copy("second");
        assertEquals("second", c.paste());
        assertEquals(cCopy, c);
    }

    /**
     * Tests copy duplicate entries.
     */
    @Test
    public void testCopyDuplicate() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("hello");
        c.copy("hello");
        cCopy.copy("hello");
        cCopy.copy("hello");
        assertEquals(2, c.size());
        assertEquals(cCopy, c);
    }

    // test paste

    /**
     * Tests paste one entry.
     */
    @Test
    public void testPasteOne() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("hello");
        cCopy.copy("hello");
        assertEquals("hello", c.paste());
        assertEquals(cCopy, c);
    }

    /**
     * Tests paste does not remove entries.
     */
    @Test
    public void testPasteDoesNotRemove() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.paste();
        assertEquals(1, c.size());
    }

    /**
     * Tests paste returns most recent entry.
     */
    @Test
    public void testPasteMostRecent() {
        Clipboard c = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        assertEquals("second", c.paste());
    }

    // test clearEntry

    /**
     * Tests clearing a single entry.
     */
    @Test
    public void testClearEntryOne() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.clearEntry();
        assertTrue(c.isEmpty());
    }

    /**
     * Tests clearing multiple entries.
     */
    @Test
    public void testClearEntryMultiple() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.clearEntry();
        cCopy.copy("first");
        assertEquals(cCopy, c);
    }

    /**
     * Tests clearing entry by index.
     */
    @Test
    public void testClearEntryIndex() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.copy("third");
        c.clearEntry(1);
        cCopy.copy("first");
        cCopy.copy("third");
        assertEquals(cCopy, c);
    }

    // test entry

    /**
     * Tests entry at first index.
     */
    @Test
    public void testEntryFirst() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        cCopy.copy("first");
        cCopy.copy("second");
        assertEquals("second", c.entry(0));
        assertEquals(cCopy, c);
    }

    /**
     * Tests entry at last index.
     */
    @Test
    public void testEntryLast() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        cCopy.copy("first");
        cCopy.copy("second");
        assertEquals("first", c.entry(1));
        assertEquals(cCopy, c);
    }

    /**
     * Tests entry does not remove values.
     */
    @Test
    public void testEntryDoesNotRemove() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.entry(0);
        assertEquals(1, c.size());
    }

    // test size

    /**
     * Tests size when empty.
     */
    @Test
    public void testSizeEmpty() {
        Clipboard c = new Clipboard1L();
        assertEquals(0, c.size());
    }

    /**
     * Tests size with one entry.
     */
    @Test
    public void testSizeOne() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        assertEquals(1, c.size());
    }

    /**
     * Tests size with multiple entries.
     */
    @Test
    public void testSizeMultiple() {
        Clipboard c = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.copy("third");
        assertEquals(3, c.size());
    }

    // test isEmpty

    /**
     * Tests isEmpty when true.
     */
    @Test
    public void testIsEmptyTrue() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        assertTrue(c.isEmpty());
        assertEquals(cCopy, c);
    }

    /**
     * Tests isEmpty when false.
     */
    @Test
    public void testIsEmptyFalse() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        assertFalse(c.isEmpty());
    }

    /**
     * Tests isEmpty after clearing.
     */
    @Test
    public void testIsEmptyAfterClear() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.clearEntry();
        assertTrue(c.isEmpty());
    }

}
