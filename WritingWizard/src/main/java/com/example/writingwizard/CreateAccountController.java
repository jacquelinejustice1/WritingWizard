package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class CreateAccountController {
    Manager manager = new Manager();
    @FXML
    private Label errorUsername;
    @FXML
    private Label errorPassword;
    @FXML
    private Label errorCreateAccount;
    @FXML
    private Button submitAccountButton;
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

    public void setReturnToLogIn(Button returnToLogIn) {
        this.returnToLogIn = returnToLogIn;
    }

    public void setUsernameText(TextField usernameText) {
        this.usernameText = usernameText;
    }

    public void setReenterUsernameText(TextField reenterUsernameText) {
        this.reenterUsernameText = reenterUsernameText;
    }

    public void setCreatePasswordText(PasswordField createPasswordText) {
        this.createPasswordText = createPasswordText;
    }

    public void setCreatePasswordReenterText(PasswordField createPasswordReenterText) {
        this.createPasswordReenterText = createPasswordReenterText;
    }

    public void setSubmitAccountButton(Button submitAccountButton) {
        this.submitAccountButton = submitAccountButton;
    }
    public Label getErrorUsername() {
        return errorUsername;
    }

    public void setErrorUsername(Label errorUsername) {
        this.errorUsername = errorUsername;
    }

    public Label getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(Label errorPassword) {
        this.errorPassword = errorPassword;
    }

    public Label getErrorCreateAccount() {
        return errorCreateAccount;
    }

    public void setErrorCreateAccount(Label errorCreateAccount) {
        this.errorCreateAccount = errorCreateAccount;
    }

public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public void setTextEditorScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }

    //getters
    public Button getReturnToLogIn() {
        return returnToLogIn;
    }

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

    public Button getSubmitAccountButton() {
        return submitAccountButton;
    }

    //functions

    public void submitAccountInfo(ActionEvent actionEvent) {

        if(!manager.validateUserNameCreation(getUsernameText().getText(), getReenterUsernameText().getText())){
            errorUsername.setText("Enter the same username again.");
        }
        if(!manager.validatePasswordCreation(getCreatePasswordText().getText(), getCreatePasswordReenterText().getText())){
            errorPassword.setText("Enter the same password again.");
        }
        //stage.setScene(textEditorScene);
        // stage.setTitle("Text Editor");
        //stage.show();
        }


   public void returnToLogIn(ActionEvent actionEvent) throws IOException {
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

}