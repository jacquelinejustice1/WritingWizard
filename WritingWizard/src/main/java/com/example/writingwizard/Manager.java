package com.example.writingwizard;

import DataStructures.*;
import Database.*;
import static Database.DatabaseManager.*;

import java.util.HashMap;

/**
 * @author Jordan Weaver
 * Contains currentuser logged in and currentFile being used.
 */
public class Manager {

    static User currentuser;
    static TextFile currentFile;
    //Create Account Functions

    /**
     * Creates a user account if the username it does not already exist.
     * @param username of user.
     * @param password of account.
     * @return whether user was successfully created.
     */
    public boolean createUser(String username, String password){
        if (!DatabaseManager.userExists(username)) {
            User user = new User(username, password);
            DatabaseManager.createAccount(user);
            currentuser = new User(username, password);
            createFile("","");
            return true;
        } else
            return false;
    }
    /**
     * Validates the username entered and reentered are equal.
     * @param username of user.
     * @param usernameReenter of user.
     * @return whether the params are equal.
     */
    public boolean validateUserNameCreation(String username, String usernameReenter){
        return username.equalsIgnoreCase(usernameReenter);
    }

    /**
     * Validates the password entered and reentered are equal.
     * @param password of account.
     * @param reEnteredPassword of account.
     * @return whether params are equal.
     */
    public boolean validatePasswordCreation(String password, String reEnteredPassword){
        return password.equals(reEnteredPassword);
    }

    /**
     * Validates the user's login attempt.
     * @param username of user.
     * @param password of user.
     * @return whether successfully logged in.
     */
    public boolean validateLogin(String username, String password){ //validates user log in
        if (username.isBlank() || password.isBlank())
            return false;
        else {
            if (DatabaseManager.userExists(username)) {
                if (DatabaseManager.validateAccount(username, password) != null) {
                    currentuser = new User(username, password);
                    createFile("", "");
                    return true;
                } else
                    return false;
            } else
                return false;
        }
    }

    /**
     * Checks currentuser's permission on the given file.
     * @param file TextFile.
     * @return user's permissionLevel on the file.
     */
    public static PermissionLevel checkPermissions(TextFile file) {
        if (currentuser.getName().equals(file.getOwnerName())) {
            return PermissionLevel.write;
        }
        Permission[] perms = file.getPermissions();
        for (Permission perm: perms) {
            if (perm.getUsername().equals(currentuser.getName())) {
                return (perm.getPermissionLevel());
            }
        }
        return PermissionLevel.none;
    }

    /**
     * Maps PermissionLevel to TextFile.
     * @return the paired PermissionLevels and TextFiles.
     */
    public static HashMap<TextFile, PermissionLevel> getFiles() {
        HashMap<TextFile, PermissionLevel> hash = new HashMap<>();
        TextFile[] files = getUserFiles(currentuser);
        for (TextFile file: files) {
            hash.put(file, checkPermissions(file));
        }
        return hash;
    }

    /**
     * checks if user has write permissions.
     * @return whether user has write permissions.
     */
    public static boolean hasWrite() {
        return (checkPermissions(currentFile) == PermissionLevel.write);
    }

    /**
     * Opens the given file.
     * @param file to open.
     * @return content of file.
     */
     public static String openFile(TextFile file){
         currentFile = file;
        return file.getContent();
        //opens text file from user that shared the text files to the document
     }

    /**
     * Creates a file.
     * @param name filename.
     * @param content file contents.
     */
    public static void createFile(String name, String content){
        currentFile = new TextFile(name, content, currentuser.getName(),
                new Permission[]{});
        //creates a file from the content in the textarea
    }

    /**
     * Saves a file.
     * @param contents to save.
     */
    public void saveFile(String contents) {
        currentFile.setContent(contents);
        DatabaseManager.saveFile(currentFile);
    }

    /**
     * Saves shared information.
     * @param permissionLevel PermissionLevel the added user should have.
     * @param usernameToShareWith user to share the file with.
     */
    public void saveSharedInfo(PermissionLevel permissionLevel, String usernameToShareWith) {
        Permission p = new Permission(usernameToShareWith, permissionLevel, currentFile.getFileName(), currentuser.getName());
        currentFile.addPermission(p);
        DatabaseManager.saveFile(currentFile);
    }

}
