package models;

import java.util.HashMap;

public class KingdomEmblems {
    private HashMap<String, String> kingdomEmblems = new HashMap<String, String>();
    
    // Setting emblems of the known kingdoms
    public KingdomEmblems() {
        kingdomEmblems.put("SPACE", "GORILLA");
        kingdomEmblems.put("LAND", "PANDA");
        kingdomEmblems.put("ICE", "MAMMOTH");
        kingdomEmblems.put("AIR", "OWL");
        kingdomEmblems.put("FIRE", "DRAGON");
        kingdomEmblems.put("WATER", "OCTOPUS");
    }

    // public getters and setters of the member variables

    public HashMap<String, String> getKingdomEmblems() {
        return this.kingdomEmblems;
    }

    public void setKingdomEmblem(String key, String value) {
        this.kingdomEmblems.put(key, value);
    }
}
