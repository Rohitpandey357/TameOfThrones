package fileparser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Kingdom;
import models.KingdomEmblems;

/**
 * A class that implements Fileparser interface to parse kingdoms from a file
 */

public class Kingdomparser implements Fileparser<Kingdom> {

    // will store all the kingdoms
    private ArrayList<Kingdom> kingdoms = new ArrayList<Kingdom>();
    private Scanner sc;
    private KingdomEmblems kEmblems;
    // This will store all the kingdom emblems;
    private HashMap<String, String> kingdomEmblems = new HashMap<String, String>();

    /**
     * This method does the following things :
     * Takes in filepath
     * Parse kingdoms out of the file and store it into an arraylist
     * return the arraylist
     * 
     * @param filepath
     * @return List of kingdoms
     */
    
    public ArrayList<Kingdom> parseFile(String filepath) {
        try {
            sc = new Scanner(new File(filepath));
        
            ArrayList<String> lines = new ArrayList<String>();   
            while (sc.hasNextLine()) {                  // loop runs until the very last line
                lines.add(sc.nextLine());                     // Adding every line to lines List
            }

            /**
             * Kingdom Emblems is a class which stores the emblems of all the kingdoms in a HashMap.
             * getKingdomEmblems returns all the pre stores emblems of the kingdom
             */
            kEmblems = new KingdomEmblems();
            kingdomEmblems = kEmblems.getKingdomEmblems();

            for(int line = 0; line < lines.size(); line++) {
                /**
                 * Splitting the data on whitespaces to get emblem and secret message
                 * "I am a boy" => {"I", "am", "a", "boy"}
                 */
                String[] kingdomData = lines.get(line).split("\\s+");
                
                /**
                 * Removing spaces from the message
                 * for eg. the message, "King Shan rules" becomes "KingShanrules" 
                 */
                String message = new String();
                for(int word = 1; word < kingdomData.length; word++) {
                    message = message + kingdomData[word];
                }
                // Making a kingdom with it's emblem and secret message
                Kingdom kingdom = new Kingdom(kingdomData[0], kingdomEmblems.get(kingdomData[0]) , message);

                //Adding the newly created kingdom to kingdoms array
                kingdoms.add(kingdom);
            }
            
        }
        catch(Exception e) {
            // Catching any exception found
            e.printStackTrace();            
            System.out.println("Invalid File.");
        }
        return kingdoms;
    }
}
