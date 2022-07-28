package ruler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import models.Kingdom;

/*
A unit test to test the rulerSupport class under different scenarios
*/

public class RulingKingdomTest {
    private RulingKingdom rulingKingdom;
    
    /**
     * Test for when king Shan sends messages to different kingdoms
     * but he doesn't get enough supporters to be a ruler   
     */ 
    @Test
    public void findRulerWhenMessagesSentToDifferentKingdomsTest() {
        //This will store the kingdoms with encrypted message
        ArrayList<Kingdom> kingdomsWithEncryptedMessage = new ArrayList<Kingdom>();
            
        // Add some kingdoms to test
        kingdomsWithEncryptedMessage.add(new Kingdom("AIR", "OWL", "OWLO"));
        kingdomsWithEncryptedMessage.add(new Kingdom("LAND", "PANDA", "FAIJWJSOOFAMAU"));
        kingdomsWithEncryptedMessage.add(new Kingdom("ICE", "MAMMOTH", "STHSTSTVSASOS"));

        ArrayList<String> supportedKingdoms = new ArrayList<String>();
        rulingKingdom = new RulingKingdom();
        supportedKingdoms = rulingKingdom.findRuler(kingdomsWithEncryptedMessage);
        assertEquals(2, supportedKingdoms.size());
        assertEquals("SPACE", supportedKingdoms.get(0) );
        assertEquals("AIR", supportedKingdoms.get(1) );
    }

    /**
     * Test for when king Shan sends message to same kingdom
     */
    @Test
    public void findRulerWhenMessagesSentToSameKingdomTest() {
        //This will store the kingdoms with encrypted message
        ArrayList<Kingdom> kingdomsWithEncryptedMessage = new ArrayList<Kingdom>();
            
        // Add some kingdoms to test
        kingdomsWithEncryptedMessage.add(new Kingdom("AIR", "OWL", "OWLO"));
        kingdomsWithEncryptedMessage.add(new Kingdom("AIR", "OWL", "FAIJWJSOOFAMAU"));
        kingdomsWithEncryptedMessage.add(new Kingdom("AIR", "OWL", "STHSTSTVSASOS"));

        ArrayList<String> supportedKingdoms = new ArrayList<String>();
        rulingKingdom = new RulingKingdom();
        supportedKingdoms = rulingKingdom.findRuler(kingdomsWithEncryptedMessage);
        assertEquals(2, supportedKingdoms.size());
        assertEquals("SPACE", supportedKingdoms.get(0) );
        assertEquals("AIR", supportedKingdoms.get(1) );
    }


    /**
     * This is a test for the method getFrequencyOfLettersInMessage
     * The method fills a hashmap with the characters and their frequencies from a string
     */

    @Test
    public void getFrequencyOfLettersInNonEmptyMessageTest() {
        String testMessage = "AAWPD";

        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        rulingKingdom = new RulingKingdom();
        frequencies = rulingKingdom.getFrequencyOfLettersInMessage(testMessage);
        
        assertEquals(frequencies.size(), 4);
        assertEquals(frequencies.get('A'),2);
        assertEquals(frequencies.get('W'),1);
        assertEquals(frequencies.get('P'),1);
        assertEquals(frequencies.get('D'),1);
    }

    /**
     * This is a test for the method getFrequencyOfLettersInMessage with an empty string
     */

     @Test
    public void getFrequencyOfLettersInEmptyMessageTest() {
    String testMessage = "";
    HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
    rulingKingdom = new RulingKingdom();
    frequencies = rulingKingdom.getFrequencyOfLettersInMessage(testMessage);
    assertTrue(frequencies.size() == 0);
    }


    /**
    * This is a test for method isTheKingdomFriend when the message contains the emblem
    * of the kingdom
    */
    @Test
    public void KingdomIsFriendTest() {
        String emblem = "OWL";
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        frequencies.put('O',3);
        frequencies.put('W', 2);
        frequencies.put('L', 1);
        frequencies.put('A', 10);
        frequencies.put('Z', 4);

        Boolean isTheKingdomFriend;
        rulingKingdom = new RulingKingdom();
        isTheKingdomFriend = rulingKingdom.isTheKingdomFriend(emblem, frequencies);
        assertTrue(isTheKingdomFriend);
    }

    /**
    * This is a test for method isTheKingdomFriend when the message does not contains the emblem
    * of the kingdom
    */
    @Test
    public void KingdomIsNotFriendTest() {
        String emblem = "OWL";
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        frequencies.put('W', 2);
        frequencies.put('L', 1);
        frequencies.put('A', 10);
        frequencies.put('Z', 4);

        Boolean isTheKingdomFriend = false;
        rulingKingdom = new RulingKingdom();
        isTheKingdomFriend = rulingKingdom.isTheKingdomFriend(emblem, frequencies);
        assertFalse(isTheKingdomFriend);
    }


}
