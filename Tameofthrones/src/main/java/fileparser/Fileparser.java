package fileparser;

import java.util.ArrayList;

/**
 * A generic interface to paarse a file and return list of general object
 */

public interface Fileparser<T> {        // T is a class here
    ArrayList<T> parseFile(String filepath);
}
