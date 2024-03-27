package DataStructures;

/**
 * @author benbruyns
 * represents a user
 * contains name of user
 */
public class User {
    private final String name;

    /**
     * Constucts the User class
     * @param name is the user's name
     */
    public User(String name){
        this.name = name;
    }

    /**
     * Gets the name of the user
     * @return name of user
     */
    public String getName(){
        return this.name;
    }
}
