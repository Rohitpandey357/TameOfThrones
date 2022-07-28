package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

/**
 * This a class to test functionalities of KingdomEmblems class
 * in different scenarios 
 */

public class KingdomEmblemsTest {
    private KingdomEmblems kingdomEmblems;

    /**
     * This is a test to check the getter methods of the 
     * kingdom emblem class.
     */
    @Test
    public void kingdomEmblemsGettersTest() {
        kingdomEmblems = new KingdomEmblems();
        HashMap<String, String> expectedKingdomEmblems = new HashMap<String, String>();
        expectedKingdomEmblems.put("SPACE", "GORILLA");
        expectedKingdomEmblems.put("LAND", "PANDA");
        expectedKingdomEmblems.put("ICE", "MAMMOTH");
        expectedKingdomEmblems.put("AIR", "OWL");
        expectedKingdomEmblems.put("FIRE", "DRAGON");
        expectedKingdomEmblems.put("WATER", "OCTOPUS");
        assertEquals(expectedKingdomEmblems, kingdomEmblems.getKingdomEmblems());
    }

    /**
     * This is a test to check the setter methods of the
     * kingdom emblem class.
     */
    @Test
    public void kingdomEmblemsSettersTest() {
        kingdomEmblems = new KingdomEmblems();
        HashMap<String, String> expectedKingdomEmblems = new HashMap<String, String>();
        expectedKingdomEmblems.put("SPACE", "GORILLA");
        expectedKingdomEmblems.put("LAND", "PANDA");
        expectedKingdomEmblems.put("ICE", "MAMMOTH");
        expectedKingdomEmblems.put("AIR", "OWL");
        expectedKingdomEmblems.put("FIRE", "DRAGON");
        expectedKingdomEmblems.put("WATER", "OCTOPUS");
        assertEquals(expectedKingdomEmblems, kingdomEmblems.getKingdomEmblems());

        kingdomEmblems.setKingdomEmblem("AIR", "WOLF");     // setting a new value for AIR kingdom
        assertFalse(kingdomEmblems.getKingdomEmblems().get("AIR") == "OWL");
        assertTrue(kingdomEmblems.getKingdomEmblems().get("AIR") == "WOLF");
    }
}
