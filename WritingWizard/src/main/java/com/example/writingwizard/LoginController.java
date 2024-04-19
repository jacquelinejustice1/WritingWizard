package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label errorLogin;
    Manager manager = new Manager();
    @FXML
    public Button createAccount;
    @FXML
    private Button signInButton;
    @FXML
    private TextField usernameLogin;
    @FXML
    private PasswordField passwordLogin;
    private Stage stage;
  private Scene createAccountScene;

  private Scene textEditorScene;


  //setters

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setCreateAccountScene(Scene createAccountScene) {
        this.createAccountScene = createAccountScene;
    }

    public void setTextEditorScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }

    public void setPasswordLogin(PasswordField passwordLogin){ this.passwordLogin = passwordLogin; }

    public void setUsernameLogin(TextField usernameLogin){this.usernameLogin = usernameLogin; }
    public void setSignInButton(Button signInButton){this.signInButton = signInButton;}
    public void setCreateAccount(Button createAccount){this.createAccount= createAccount;}

    //getters

    public PasswordField getPasswordLogin(){ return passwordLogin; }
    public TextField getUsernameLogin(){return usernameLogin; }
    public Button getSignInButton() {return signInButton; }
    public Button getCreateAccount() {return createAccount; }

    //functions

    public void signInButton(ActionEvent actionEvent) throws IOException {
        /*
     if(manager.validateLogin(usernameLogin.getText(),passwordLogin.getText())){

         */
         stage.setScene(textEditorScene);
         stage.setTitle("Text Editor");
         stage.show();
         /*
     }else{
         errorLogin.setText("Error, please try again.");
     }

          */

    }

  public void createNewAccount(ActionEvent actionEvent) throws IOException {

      stage.setScene(createAccountScene);
      stage.setTitle("Create Account");
      stage.show();
  }


}
