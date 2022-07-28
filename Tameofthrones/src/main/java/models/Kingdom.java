package models;
/**
 * A class to store the data about the kingdom like the name, 
 * emblem and the message that is sent to it.
 */

public class Kingdom {
    private String name;
    private String emblem;
    private String message;

    // Setting data as per given by user
    public Kingdom(String name, String emblem, String message) {
        this.name = name;
        this.emblem = emblem;
        this.message = message;
    }

    /*
        public getters and setters for data members
    */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmblem() {
        return this.emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}