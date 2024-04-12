package Database;

import DataStructures.*;

public class DatabaseManager {

    private static final Database db = new Database();

    /**
     * Determine if a username has already been used
     * @param username username to find
     * @return if username was found
     */
    public static boolean userExists(String username) {
        User[] users = db.readUsers();

        for(User user : users)
            if(user.getName().equals(username))
                return true;

        return false;
    }

    /**
     * Verifies a user
     * @param username
     * @param password
     * @return User if valid, null if invalid
     */
    public static User validateAccount(String username, String password) {

    }

    public static void createAccount(User user) {

    }
}