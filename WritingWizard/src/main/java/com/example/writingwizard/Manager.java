package com.example.writingwizard;

import javafx.scene.control.TextField;

public class Manager {

    User currentuser;
    String username;
    String password;
    //Create Account Functions
    public String createUser(){
        // ??
    }

    //I need the following functions for alerts on the createAccount page to send to the user

    public boolean validateUserNameCreation(String username, String usernameReenter){
        if (username.equalsIgnoreCase(usernameReenter)) {
            if (!DatabaseManager.userExists(username)) {
                this.username = username;
                return true
            } else
                return false
        } else {
            return false
        }
    }

    public boolean validatePasswordCreation(String password, String reEnteredPassword){
        if (password.equals(reEnteredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    //Login Functions
    //To alert the user if the account is valid or not
    public boolean validateLogin(String username, String password){ //validates user log in
        if (DatabaseManager.userExists(username)) {
            if (DatabaseManager.checkPassword(username, password))
                return true;
            else
                return false;
        } else
            return false;

    }

    //View-Only functions
     public static String openFile(File filePath, TextArea document){
        //opens text file from user that shared the text files to the document
     }

    //Main text editor functions
    public static String openFile(File filePath, TextArea document){
        //opens a user's already made documents into the textarea to edit
    }

    public static void createFile(File filepath, TextArea document){
        //creates a file from the content in the textarea
    }

    public boolean checkIfSaved(???){
        //check to see if the document is saved
        //if saved return true
        //if not saved return false
    }


    //share screen




}
