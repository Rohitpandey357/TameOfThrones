package decryption;

import java.util.ArrayList;

/**
 * A general interface for decryption of any encrypted data type
 * @param encryptedList
 * @return  decryptedList 
 */



public interface Decryption<T> {   // T is a class here
    public ArrayList<T> decrypt(ArrayList<T> encryptedList);
}
