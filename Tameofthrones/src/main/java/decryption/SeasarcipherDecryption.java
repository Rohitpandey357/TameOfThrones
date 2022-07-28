package decryption;

import java.util.ArrayList;
import java.util.HashMap;

import models.Kingdom;
import models.KingdomEmblems;

/**
 * A class to decrypt the secret message. 
 * The mechanism to decrypt is rotating every letter of the message anti-clockwise by a key.
 */

public class SeasarcipherDecryption implements Decryption<Kingdom> {
    
    private ArrayList<Kingdom> kingdomsWithDecryptedMessage = new ArrayList<Kingdom>(); 
    private KingdomEmblems kEmblems;
    // This will store all the kingdom emblems;
    private HashMap<String, String> kingdomEmblems = new HashMap<String, String>();
    
    /**
     * This method takes in an arraylist of kingdoms that have encrypted messages in them
     * and decrypt those messages.
     * 
     * @param ArrayList<Kingdom> kingdomsWithEncryptedMessage
     * @return ArrayList<Kingdom> kingdomsWithDecreytedMessage
     */
    public ArrayList<Kingdom> decrypt(ArrayList<Kingdom> kingdomsWithEncryptedMessage) {
        try {
             //Get emblems of the kingdoms
             kEmblems = new KingdomEmblems();
             kingdomEmblems = kEmblems.getKingdomEmblems();

            for(int kingdom = 0; kingdom < kingdomsWithEncryptedMessage.size(); kingdom++) {
                
                String encryptedMessage = kingdomsWithEncryptedMessage.get(kingdom).getMessage();
                String kingdomName = kingdomsWithEncryptedMessage.get(kingdom).getName();
                String kingdomEmblem = kingdomEmblems.get(kingdomName);

                int key = kingdomEmblem.length();
                String decryptedMessage = new String();
                //gets the decrypted message
                decryptedMessage = getDecryptedMessage(encryptedMessage,key);
                
                // Making new kingdom with decrypted message
                Kingdom decryptedKingdom = new Kingdom(kingdomName, kingdomEmblem, decryptedMessage);
                kingdomsWithDecryptedMessage.add(decryptedKingdom);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong while decrypting the text");
        }
        return kingdomsWithDecryptedMessage;
    }


    /**
     * A method that takes in encrypted message and a key and returns the decrypted message.
     * Decryption is done by rotating the character anti clockwise by the key.
     * for e.g. if key = 3, then,
     * A -> X
     * B -> Y
     * D -> A
     * E -> B
     * 
     * @param encryptedMessage
     * @param key
     * @return decryptedMessage
     */

    public String getDecryptedMessage(String encryptedMessage, int key) {
        
        if(key < 1) {
            return encryptedMessage;
        }
        String decryptedMessage = new String();
        // Decryption logic
        for(int character = 0; character < encryptedMessage.length(); character++) {
            // Getting integer value of the decrypted character, A -> 65 and Z -> 90
            int valueOfDecryptedCharacter = encryptedMessage.charAt(character) - key;
            
            /*
             If value becomes smaller than 65 then add 25 to make it come under the 
             ASCII values of the english uppercase alphabets   
            */
             if(valueOfDecryptedCharacter < 65) {
                valueOfDecryptedCharacter = valueOfDecryptedCharacter + 26;
            }
            decryptedMessage = decryptedMessage + String.valueOf((char)valueOfDecryptedCharacter);
        }
        return decryptedMessage;
    }
}
