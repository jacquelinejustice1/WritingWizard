package com.example.writingwizard;

import DataStructures.*;
import Database.*;
import static Database.DatabaseManager.*;
import static java.util.Arrays.asList;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Manager {

    static User currentuser;
    static TextFile currentFile;
    //Create Account Functions

    public boolean createUser(String username, String password){
        if (!DatabaseManager.userExists(username)) {
            User user = new User(username, password);
            DatabaseManager.createAccount(user);
            currentuser = new User(username, password);
            return true;
        } else
            return false;
    }
    /*

     */
    //I need the following functions for alerts on the createAccount page to send to the user

    public boolean validateUserNameCreation(String username, String usernameReenter){
        return username.equalsIgnoreCase(usernameReenter);
    }

    public boolean validatePasswordCreation(String password, String reEnteredPassword){
        return password.equals(reEnteredPassword);
    }

    //Login Functions
    //To alert the user if the account is valid or not
    public boolean validateLogin(String username, String password){ //validates user log in
        if (username.isBlank() || password.isBlank())
            return false;
        else {
            if (DatabaseManager.userExists(username)) {
                if (DatabaseManager.validateAccount(username, password) != null) {
                    currentuser = new User(username, password);
                    return true;
                } else
                    return false;
            } else
                return false;
        }
    }

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
        // if not, check if they have read permissions
        // check if they have write permissions
        return PermissionLevel.none;
    }

    /*public HashMap<TextFile, Permission[]> getFiles() {
        HashMap<TextFile, Permission[]> hash = new HashMap<>();
        TextFile[] files = getUserFiles(currentuser);
        for (TextFile file: files) {
            hash.put(file, file.getPermissions());
        }
        return hash;
    }*/

    public static HashMap<PermissionLevel, TextFile> getFiles() {
        HashMap<PermissionLevel, TextFile> hash = new HashMap<>();
        TextFile[] files = getUserFiles(currentuser);
        for (TextFile file: files) {
            hash.put(checkPermissions(currentFile), file);
        }
        return hash;
    }

    public static boolean hasWrite() {
        return (checkPermissions(currentFile) == PermissionLevel.write);
    }

    //View-Only functions
     public static String openFile(TextFile file){
        return file.getContent();
        //opens text file from user that shared the text files to the document
     }

    public void createFile(String name, String content){
        currentFile = new TextFile(name, content, currentuser.getName(),
                new Permission[]{});
        //creates a file from the content in the textarea
    }

    public void saveFile(String contents) {
        currentFile.setContent(contents);
        DatabaseManager.saveFile(currentFile);
    }

    //public boolean checkIfSaved(TextFile file){
       // return fileExists(file);
    //}


}
