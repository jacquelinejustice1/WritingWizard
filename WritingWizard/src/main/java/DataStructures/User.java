package DataStructures;

import java.io.Serializable;

/**
 * @author benbruyns
 * represents a user
 * contains name of user
 */
public class User implements Serializable {
    private final String name;
    private final String password;

    /**
     * Constructs the User class
     * @param name is the user's name
     * @param password is the user's password
     */
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    /**
     * Gets the name of the user
     * @return name of user
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the password of the user
     * @return password of user
     */
    public String getPassword() {
        return password;
    }
}
