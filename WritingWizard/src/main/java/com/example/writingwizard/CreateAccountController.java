package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountController {
    @FXML
    private Button submitAccountButton;
    @FXML
    private TextField elementaryNameText;
    @FXML
    private TextField motherNameText;
    @FXML
    private TextField firstPetText;
    @FXML
    private PasswordField createPasswordReenterText;
    @FXML
    private PasswordField createPasswordText;
    @FXML
    private TextField reenterUsernameText;
    @FXML
    private TextField usernameText;
    @FXML
    private Button returnToLogIn;
    private Stage stage;
    private Scene loginScene;

    private Scene textEditorScene;

    //setters

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setReturnToLogIn(Button returnToLogIn){ this.returnToLogIn = returnToLogIn; }
    public void setUsernameText(TextField usernameText){this.usernameText=usernameText;}
    public void setReenterUsernameText(TextField reenterUsernameText){ this.reenterUsernameText=reenterUsernameText;}
    public void setCreatePasswordText(PasswordField createPasswordText){this.createPasswordText = createPasswordText; }
    public void setCreatePasswordReenterText(PasswordField createPasswordReenterText) {
        this.createPasswordReenterText = createPasswordReenterText; }
    public void setFirstPetText(TextField firstPetText){this.firstPetText = firstPetText; }
    public void setMotherNameText(TextField motherNameText){this.motherNameText=motherNameText;}
    public void setElementaryNameText(TextField elementaryNameText){this.elementaryNameText=elementaryNameText;}
    public void setSubmitAccountButton(Button submitAccountButton){this.submitAccountButton = submitAccountButton;}


    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setTextEditorScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }

    //getters
    public Button getReturnToLogIn(){return returnToLogIn; }
    public TextField getUsernameText(){return usernameText;}
    public TextField getReenterUsernameText(){return reenterUsernameText;}
    public PasswordField getCreatePasswordText(){return createPasswordText;}
    public PasswordField getCreatePasswordReenterText(){return createPasswordReenterText;}
    public TextField getFirstPetText(){return firstPetText;}
    public TextField getMotherNameText(){return motherNameText;}
    public TextField getElementaryNameText(){return elementaryNameText; }
    public Button getSubmitAccountButton(){ return submitAccountButton;}

    //functions

    public void createNewUsername(ActionEvent actionEvent){

    }

    //public void createUsernameReenter(ActionEvent actionEvent) {
    //}

    public void createPassword(ActionEvent actionEvent) {
    }

    public void createPasswordReenter(ActionEvent actionEvent) {
    }

    public void saveFirstPetQuestion(ActionEvent actionEvent) {
    }

    public void saveMotherName(ActionEvent actionEvent) {
    }

    public void submitAccountInfo(ActionEvent actionEvent) {

        stage.setScene(textEditorScene);
        stage.setTitle("Text Editor");
        stage.show();

    }

    public void saveSchool(ActionEvent actionEvent) {
    }

    public void returnToLogIn(ActionEvent actionEvent) throws IOException {

        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

}
