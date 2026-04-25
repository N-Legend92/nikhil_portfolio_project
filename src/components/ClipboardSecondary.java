package components;

/**
 * Layered implementations of secondary methods for {@code Clipboard}.
 */
public abstract class ClipboardSecondary implements Clipboard {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        String result = "[";
        int length = this.size();
        for (int i = 0; i < length; i++) {
            result += this.entry(i);
            if (i < length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        boolean eq = (this == obj);
        if (!eq && obj instanceof Clipboard) {
            Clipboard other = (Clipboard) obj;
            eq = (this.size() == other.size());
            int i = 0;
            while (eq && i < this.size()) {
                eq = this.entry(i).equals(other.entry(i));
                i++;
            }
        }
        return eq;
    }
    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean contains(String text) {
        boolean found = false;
        int length = this.size();
        for (int i = 0; i < length; i++) {
            if (this.entry(i).equals(text)) {
                found = true;
            }
        }
        return found;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String oldest() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        return this.entry(this.size() - 1);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void pin(int index) {
        assert 0 <= index
                && index < this.size() : "Violation of: index is within bounds";
        String pinned = this.entry(index);
        this.clearEntry(index);
        this.copy(pinned);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void removeDuplicates() {
        int i = 0;
        while (i < this.size()) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (this.entry(j).equals(this.entry(i))) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                this.clearEntry(i);
            } else {
                i++;
            }
        }
    }

}
