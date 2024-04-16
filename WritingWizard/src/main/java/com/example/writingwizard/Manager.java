package com.example.writingwizard;

import DataStructures.*;
import Database.*;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.File;

public class Manager {

    User currentuser;
    //Create Account Functions

    public boolean createUser(String username, String password){
        if (DatabaseManager.userExists(username)) {
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
        if (DatabaseManager.userExists(username)) {
            if (DatabaseManager.validateAccount(username, password) != null) {
                currentuser = new User(username, password);
                return true;
            } else
                return false;
        } else
            return false;
    }

    public PermissionLevel checkPermissions(TextFile file) {
        // check if currentuser is owner
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
/*
    //View-Only functions
     public static String openFileView(File filePath, TextArea document){
        //opens text file from user that shared the text files to the document
     }

    //Main text editor functions
    public static String openFileEdit(File filePath, TextArea document){
        //opens a user's already made documents into the textarea to edit
    }

    public static void createFile(File filepath, TextArea document){
        //creates a file from the content in the textarea
    }

    public boolean checkIfSaved(){
        //check to see if the document is saved
        //if saved return true
        //if not saved return false
    }

*/
}
