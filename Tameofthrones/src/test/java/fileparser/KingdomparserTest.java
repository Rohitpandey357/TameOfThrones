package fileparser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import models.Kingdom;

/**
 * A unit test to test the kingdom parser class.
 * It checks whether the fileParser method of kingdom parser method 
 * extracts kingdoms from the file correctly or not.
 */

public class KingdomparserTest {
    private Kingdomparser kingdomparser;

    /**
     * This is a test to check the kingdom parser class 
     * from a sample input file
     */
    @Test    
    public void kingdomParserWhenMessagesDontContainSpacesTest() {
        String filepath = "src\\test\\resources\\sampleinput.txt";   // Path to our sample input
        kingdomparser = new Kingdomparser();            
        ArrayList<Kingdom> kingdoms = kingdomparser.parseFile(filepath);
        assertEquals(3, kingdoms.size());
        assertEquals("AIR", kingdoms.get(0).getName());
        assertEquals("ROZO", kingdoms.get(0).getMessage());
        assertEquals("OWL", kingdoms.get(0).getEmblem());
    }


    /**
     * This is a test to check the kingdom parser class when the
     * messages contains space 
     */
    @Test
    public void kingdomParserWhenMessagesContainSpacesTest() {
        String filepath = "src\\test\\resources\\sampleinput2.txt";   // Path to our sample input
        kingdomparser = new Kingdomparser();            
        ArrayList<Kingdom> kingdoms = kingdomparser.parseFile(filepath);
        assertEquals(5, kingdoms.size());
        assertEquals("LAND", kingdoms.get(0).getName());
        assertEquals("PANDAUFSIKLOOCV", kingdoms.get(0).getMessage());
        assertEquals("ICE", kingdoms.get(1).getName());
        assertEquals("MAMMOTHTHVAO", kingdoms.get(1).getMessage());
        assertEquals("FIRE", kingdoms.get(2).getName());
        assertEquals("DRAGONJXGMUT", kingdoms.get(2).getMessage());
        assertEquals("AIR", kingdoms.get(3).getName());
        assertEquals("ZORRO", kingdoms.get(3).getMessage());
        assertEquals("WATER", kingdoms.get(4).getName());
        assertEquals("OCTOVJAVWBZPUS", kingdoms.get(4).getMessage());
    }

}
