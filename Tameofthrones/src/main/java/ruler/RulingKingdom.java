package ruler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import models.Kingdom;

/**
 * A class that implements Ruler interface to find the ruling kingdom of the country
 */

public class RulingKingdom implements Ruler<Kingdom, String> {
    //to store the kingdoms that support king shan
    ArrayList<String> alliedKingdoms = new ArrayList<String>();
    private HashMap<Character, Integer> frequencyOfLettersInMessage;
    //to store the kingdoms that have already supported king shan 
    private TreeSet<String> hasAlreadySupported = new TreeSet<String>();


    // A method to find the ruler
    public ArrayList<String> findRuler(ArrayList<Kingdom> kingdoms) {
        try {
            // Because Space Kingdom always support itself
            alliedKingdoms.add("SPACE");
            hasAlreadySupported.add("SPACE");
            for(int king = 0; king < kingdoms.size(); king++) {
                // Get kingdom and other data of the kingdom
                Kingdom kingdom = kingdoms.get(king);
                String emblem = kingdom.getEmblem();
                String message = kingdom.getMessage();
                String name = kingdom.getName();

                // if this kingdom has already supported then we can skip it
                if(hasAlreadySupported.contains(name) == true ) {
                    continue;
                }
                // fills the hashmap with frequency of letters in the message
                frequencyOfLettersInMessage = getFrequencyOfLettersInMessage(message);

                // if the kingdom is friend then add it to the list of supported kingdoms
                if(isTheKingdomFriend(emblem, frequencyOfLettersInMessage) == true ){
                    // Add the friend to supported kingdoms that have already supported
                    alliedKingdoms.add(name);
                    hasAlreadySupported.add(name);
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();;
            System.out.println("Something went wrong while checking which kingdom supports SPACE kingdom.");
        }
        return alliedKingdoms;
    }


    // A method to find whether the given kingdom is friend or not
    public Boolean isTheKingdomFriend(String emblem, HashMap<Character, Integer> frequencyOfLettersInMessage) {
        Boolean isItFriend = true;
        for(int character = 0; character < emblem.length(); character++ ) {
            Character letter = emblem.charAt(character);
            // If message contains this letter than decrement the frequency of this letter in message
            if(frequencyOfLettersInMessage.get(letter) != null ) {
                frequencyOfLettersInMessage.put(letter, frequencyOfLettersInMessage.get(letter) - 1 );
                // if frequency of the letter becomes 0, remove that letter from hashmap
                if(frequencyOfLettersInMessage.get(letter) == 0) {
                    frequencyOfLettersInMessage.remove(letter);
                }
            }
            else {   // else it is not a friend and break;
                isItFriend = false;
                break;
            }
        }
        return isItFriend;
    }


    // A method to fill hashmap with the frequencies of letters present in the message
    public HashMap<Character, Integer> getFrequencyOfLettersInMessage(String message) {
        HashMap<Character, Integer> frequencyOfLetters = new HashMap<Character, Integer>();
        for(int character = 0; character < message.length(); character++) {
            Character letter = message.charAt(character);   
            // Incrementing the letter frequency in hashmap
            if(frequencyOfLetters.get(letter) != null ) {
                frequencyOfLetters.put(letter, frequencyOfLetters.get(letter) + 1);
            }
            else {
                frequencyOfLetters.put(letter, 1);
            }
        }
        return frequencyOfLetters;
    }


}
