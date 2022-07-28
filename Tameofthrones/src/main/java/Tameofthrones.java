import java.util.ArrayList;

import ruler.RulingKingdom;
import decryption.SeasarcipherDecryption;
import fileparser.Kingdomparser;
import models.Kingdom; 

/**
 * Solution Class of our problem which includes the main function
 * and refer other classes for different responsibilities that those classes perform.
 */

public class Tameofthrones {
    
    private static final Integer KINGDOMS_REQUIRED_TO_BE_A_RULER = 3; 

    /**
     * Our main function which refer to other classes and methods and find the
     * ruler of the country.
     *  
     * @param args
     */
    public static void main(String []args) {
        try {
            String filepath = args[0];             // Taking file path as input.

            // Mapping the text file into the Kingdom class
            Kingdomparser fileParser = new Kingdomparser();
            ArrayList<Kingdom> kingdomsWithEncryptedMessage = fileParser.parseFile(filepath); 

            // Decrypting the secret message of the kingdoms
            SeasarcipherDecryption seasarcipherDecryption = new SeasarcipherDecryption();
            ArrayList<Kingdom> kingdomsWithDecryptedMessage = seasarcipherDecryption.decrypt(kingdomsWithEncryptedMessage);

            // Getting all the kingdoms who support king shan
            RulingKingdom rulingKingdom = new RulingKingdom();
            ArrayList<String> supportedKingdoms = rulingKingdom.findRuler(kingdomsWithDecryptedMessage);

            // If the supported kingdoms are more than the kingdoms required 
            // to be a ruler then print their names
            if(supportedKingdoms.size() > KINGDOMS_REQUIRED_TO_BE_A_RULER) {
                for(int kingdomName = 0; kingdomName < supportedKingdoms.size(); kingdomName++) {
                    System.out.print(supportedKingdoms.get(kingdomName) + " ");
                }
            }
            else {
                System.out.print("NONE");
            }
        
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
            return;
        }
        
    }
}