package decryption;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import models.Kingdom;

/**
 * This is a class to test SeasarcipherDecryption class
 * in various different scenarios.
 * The SeasercipherDecryption class takes in an arraylist of kingdoms who have encrypted messages,
 * decrypt those messages and return an arraylist of kingdoms with decrypted messages
 */
public class SeasercipherDecryptionTest {
    private SeasarcipherDecryption seaserCipherDecryption;
    
    /**
     * A test to check the decrypt method of the class.
     * decrypt method takes in arraylist of kingdoms with ecrypted message and returns 
     * arraylist of kingdom with decrypted message.
     */
    @Test
    public void seasercipherDecryptionTest() {
        
        //This will store the kingdoms with encrypted message
        ArrayList<Kingdom> kingdomsWithEncryptedMessage = new ArrayList<Kingdom>();
        
        // Add some kingdoms to test
        kingdomsWithEncryptedMessage.add(new Kingdom("AIR", "OWL", "ROZO"));
        kingdomsWithEncryptedMessage.add(new Kingdom("LAND", "PANDA", "FAIJWJSOOFAMAU"));
        kingdomsWithEncryptedMessage.add(new Kingdom("ICE", "MAMMOTH", "STHSTSTVSASOS"));

        seaserCipherDecryption = new SeasarcipherDecryption();
        ArrayList<Kingdom> kingdomsWithDecryptedMessage = seaserCipherDecryption.decrypt(kingdomsWithEncryptedMessage);
        assertEquals(3, kingdomsWithDecryptedMessage.size());
        assertEquals("AIR", kingdomsWithDecryptedMessage.get(0).getName());
        assertEquals("OLWL", kingdomsWithDecryptedMessage.get(0).getMessage());
        assertEquals("OWL", kingdomsWithDecryptedMessage.get(0).getEmblem());
    }    

    /**
     * A test to check the get decrypted method which takes a string and a int as parameters
     * and returns the decrypted string by rotating the chracters of the string
     * anti clockwise by the int value.
     * for e.g. if key = 3, then,
     * A -> X
     * B -> Y
     * D -> A
     * E -> B
     */
    @Test
    public void getDecryptedMessageTest() {
        seaserCipherDecryption = new SeasarcipherDecryption();
        String encryptedMessage = "ROZO";
        Integer key = 3;
        String decryptedMessage = seaserCipherDecryption.getDecryptedMessage(encryptedMessage, key);
        assertEquals("OLWL", decryptedMessage);
    }

    /**
     * A test to check getDecryptedMessage method when key is 0
     */
    @Test
    public void getDecryptedMessageWhenKeyIsZeroTest() {
        seaserCipherDecryption = new SeasarcipherDecryption();
        String encryptedMessage = "ROZO";
        Integer key = 0;
        String decryptedMessage = seaserCipherDecryption.getDecryptedMessage(encryptedMessage, key);
        assertEquals("ROZO", decryptedMessage);
    }

    /**
     * A test to check getDecryptedMessage method when key is negative
     */
    @Test
    public void getDecryptedMessageWhenKeyIsNegativeTest() {
        seaserCipherDecryption = new SeasarcipherDecryption();
        String encryptedMessage = "ROZO";
        Integer key = -3;
        String decryptedMessage = seaserCipherDecryption.getDecryptedMessage(encryptedMessage, key);
        assertEquals("ROZO", decryptedMessage);
    }
}
