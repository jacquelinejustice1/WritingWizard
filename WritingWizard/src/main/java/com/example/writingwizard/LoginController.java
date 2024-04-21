package com.example.writingwizard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class LoginController {

    @FXML
    private Label errorLogin;
    Manager manager = new Manager();
    @FXML
    public Button createAccount;
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

    //functions
    public void signInButton() {

     if(manager.validateLogin(usernameLogin.getText(),passwordLogin.getText())){
         stage.setScene(textEditorScene);
         stage.setTitle("Text Editor");
         stage.show();

      }else{
           errorLogin.setText("Error, please try again.");
      }
    }
  public void createNewAccount() {

      stage.setScene(createAccountScene);
      stage.setTitle("Create Account");
      stage.show();
  }
}
