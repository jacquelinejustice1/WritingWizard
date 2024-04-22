package com.example.writingwizard;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateAccountController {
    Manager manager = new Manager();
    @FXML
    private Label errorUsername;
    @FXML
    private Label errorPassword;
    @FXML
    private Label errorCreateAccount;
    @FXML
    private PasswordField createPasswordReenterText;
    @FXML
    private PasswordField createPasswordText;
    @FXML
    private TextField reenterUsernameText;
    @FXML
    private TextField usernameText;
    private Stage stage;
    private Scene loginScene;

    private Scene textEditorScene;

    //setters

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setTextEditorScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }

    //getters

    public TextField getUsernameText() {
        return usernameText;
    }

    public TextField getReenterUsernameText() {
        return reenterUsernameText;
    }

    public PasswordField getCreatePasswordText() {
        return createPasswordText;
    }

    public PasswordField getCreatePasswordReenterText() {
        return createPasswordReenterText;
    }

    //functions

    public void submitAccountInfo() {
        boolean successful = true;

        if(!manager.validateUserNameCreation(getUsernameText().getText(), getReenterUsernameText().getText())){
            errorUsername.setText("Enter the same username again.");
            successful = false;
        }
        if(!manager.validatePasswordCreation(getCreatePasswordText().getText(), getCreatePasswordReenterText().getText())){
            errorPassword.setText("Enter the same password again.");
            successful = false;
        }

        if(successful){
            errorUsername.setText("");
            errorPassword.setText("");
            boolean account = manager.createUser(getUsernameText().getText(),getCreatePasswordText().getText());
            if(account){
                usernameText.clear();
                createPasswordReenterText.clear();
                reenterUsernameText.clear();
                createPasswordText.clear();
                stage.setScene(textEditorScene);
                stage.setTitle("Text Editor");
                stage.show();

            }else{
                errorCreateAccount.setText("Username taken. Try Again");
            }

        }


    }


   public void returnToLogIn(){
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

}