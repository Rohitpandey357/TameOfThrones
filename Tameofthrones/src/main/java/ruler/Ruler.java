package ruler;

import java.util.ArrayList;

/**
 * A generic interface to find the ruler of the kingdom according to your own rules.
 */

public interface Ruler<T, U> {   // T and U are classes here
    public ArrayList<U> findRuler(ArrayList<T> list);
}
