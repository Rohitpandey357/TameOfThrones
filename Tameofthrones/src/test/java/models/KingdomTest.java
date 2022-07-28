package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * This is a class to test functionalities of Kingdom class
 * in different scenarios
 */

public class KingdomTest {
    private Kingdom kingdom;

    /**
     * A test to check whether the kingdom is initialised with proper
     * arguments or not.
     */
    @Test
    public void kingdomInitialisationTest() {
        kingdom = new Kingdom("AIR", "OWL", "ZORO");
        assertTrue(kingdom.getName() == "AIR");
        assertTrue(kingdom.getEmblem() == "OWL" );
        assertTrue(kingdom.getMessage() == "ZORO");
    }

    /**
     * A test to check get methods of the kingdom class
     */
    @Test
    public void kingdomGettersTest() {
        kingdom = new Kingdom("AIR", "OWL", "ZORO");
        assertEquals("AIR", kingdom.getName());
        assertEquals("OWL", kingdom.getEmblem());
        assertEquals("ZORO", kingdom.getMessage());
    }

    /**
     * A test to check set methods of the kingdom class
     */
    @Test
    public void kingdomSettersTest() {
        kingdom = new Kingdom("AIR", "OWL", "ZORO");
        assertEquals("AIR", kingdom.getName());
        assertEquals("OWL", kingdom.getEmblem());
        assertEquals("ZORO", kingdom.getMessage());
        kingdom.setEmblem("PANDA");
        assertEquals("PANDA", kingdom.getEmblem());
        kingdom.setName("LAND");
        assertEquals("LAND", kingdom.getName());
        kingdom.setMessage("AABRA");
        assertEquals("AABRA", kingdom.getMessage());
    }
}
