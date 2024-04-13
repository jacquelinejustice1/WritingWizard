package Database;

import DataStructures.*;

import java.util.*;

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
        User[] users = db.readUsers();

        for(User user : users)
            if(user.getName().equals(username) && user.getPassword().equals(password))
                return user;

        return null;
    }

    /**
     * Adds user to database
     * @param user user to add to database
     */
    public static void createAccount(User user) {
        User[] users = db.readUsers();

        ArrayList<User> userList = new ArrayList<>(Arrays.asList(users));
        userList.add(user);
        users = new User[userList.size()];
        users = userList.toArray(users);

        db.writeUsers(users);
    }

    /**
     * Saves file to database by adding it to database or overwriting previous version
     * @param file textFile to save
     */
    public static void saveFile(TextFile file) {
        TextFile[] allFiles = db.readFiles();

        for(TextFile textFile : allFiles) {
            if(textFile.getFileName().equals(file.getFileName())
                    && textFile.getOwnerName().equals(file.getOwnerName())) {

                textFile = file;
                db.writeFiles(allFiles);
                return;
            }
        }

        ArrayList<TextFile> fileList = new ArrayList<>(Arrays.asList(allFiles));
        fileList.add(file);
        TextFile[] files = new TextFile[fileList.size()];
        files = fileList.toArray(files);

        db.writeFiles(files);
    }

    /**
     * Gets all files a user has access to
     * @param user
     * @return files accessible to the user
     */
    public static TextFile[] getUserFiles(User user) {
        TextFile[] allFiles = db.readFiles();
        ArrayList<TextFile> userFilesList = new ArrayList<>(Arrays.asList(allFiles));

        for(TextFile file : allFiles) {
            for(Permission perm : file.getPermissions())
                if(perm.getUsername().equals(user.getName()) || file.getOwnerName().equals(user.getName())){
                    userFilesList.add(file);
                    break;
                }
        }

        TextFile[] userFiles = new TextFile[userFilesList.size()];
        userFiles = userFilesList.toArray(userFiles);

        return userFiles;
    }
}