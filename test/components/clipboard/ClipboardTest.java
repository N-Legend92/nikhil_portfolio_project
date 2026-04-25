package components.clipboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.Clipboard;
import components.Clipboard1L;

/**
 * Clipboard secondary tests.
 */
public class ClipboardTest {

    // test contains

    /**
     * Tests contains returns true.
     */
    @Test
    public void testContainsTrue() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("hello");
        cCopy.copy("hello");
        assertTrue(c.contains("hello"));
        assertEquals(cCopy, c);
    }

    /**
     * Tests contains returns false.
     */
    @Test
    public void testContainsFalse() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        assertFalse(c.contains("goodbye"));
    }

    /**
     * Tests contains does not modify.
     */
    @Test
    public void testContainsDoesNotMutate() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        cCopy.copy("first");
        cCopy.copy("second");
        c.contains("first");
        assertEquals(cCopy, c);
    }

    // test oldest

    /**
     * Tests oldest with one entry.
     */
    @Test
    public void testOldestOne() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("hello");
        cCopy.copy("hello");
        assertEquals("hello", c.oldest());
        assertEquals(cCopy, c);
    }

    /**
     * Tests oldest with multiple entries.
     */
    @Test
    public void testOldestMultiple() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.copy("third");
        cCopy.copy("first");
        cCopy.copy("second");
        cCopy.copy("third");
        assertEquals("first", c.oldest());
        assertEquals(cCopy, c);
    }

    /**
     * Tests oldest does not modify.
     */
    @Test
    public void testOldestDoesNotMutate() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        cCopy.copy("first");
        cCopy.copy("second");
        c.oldest();
        assertEquals(cCopy, c);
    }

    // test pin

    /**
     * Tests pin operation.
     */
    @Test
    public void testPin() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.copy("third");
        c.pin(0);
        cCopy.copy("first");
        cCopy.copy("second");
        cCopy.copy("third");
        assertEquals(cCopy, c);
    }

    // test removeDuplicates

    /**
     * Tests removeDuplicates with none.
     */
    @Test
    public void testRemoveDuplicatesNone() {
        Clipboard c = new Clipboard1L();
        Clipboard cCopy = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        c.removeDuplicates();
        cCopy.copy("first");
        cCopy.copy("second");
        assertEquals(cCopy, c);
    }

    /**
     * Tests removeDuplicates with one duplicate.
     */
    @Test
    public void testRemoveDuplicatesOne() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.copy("hello");
        c.removeDuplicates();
        assertEquals(1, c.size());
        assertEquals("hello", c.paste());
    }

    /**
     * Tests removeDuplicates keeps recent.
     */
    @Test
    public void testRemoveDuplicatesKeepsMostRecent() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        c.copy("world");
        c.copy("hello");
        c.removeDuplicates();
        assertEquals("hello", c.entry(0));
        assertEquals(2, c.size());
    }

    // test toString

    /**
     * Tests toString when empty.
     */
    @Test
    public void testToStringEmpty() {
        Clipboard c = new Clipboard1L();
        assertEquals("[]", c.toString());
    }

    /**
     * Tests toString with one entry.
     */
    @Test
    public void testToStringOne() {
        Clipboard c = new Clipboard1L();
        c.copy("hello");
        assertEquals("[hello]", c.toString());
    }

    /**
     * Tests toString with multiple entries.
     */
    @Test
    public void testToStringMultiple() {
        Clipboard c = new Clipboard1L();
        c.copy("first");
        c.copy("second");
        assertEquals("[second, first]", c.toString());
    }

    // test equals

    /**
     * Tests equals returns true.
     */
    @Test
    public void testEqualsTrue() {
        Clipboard c1 = new Clipboard1L();
        Clipboard c2 = new Clipboard1L();
        c1.copy("hello");
        c2.copy("hello");
        assertTrue(c1.equals(c2));
    }

    /**
     * Tests equals returns false.
     */
    @Test
    public void testEqualsFalse() {
        Clipboard c1 = new Clipboard1L();
        Clipboard c2 = new Clipboard1L();
        c1.copy("hello");
        c2.copy("world");
        assertFalse(c1.equals(c2));
    }

    /**
     * Tests equals with empty clipboards.
     */
    @Test
    public void testEqualsEmpty() {
        Clipboard c1 = new Clipboard1L();
        Clipboard c2 = new Clipboard1L();
        assertTrue(c1.equals(c2));
    }

}
