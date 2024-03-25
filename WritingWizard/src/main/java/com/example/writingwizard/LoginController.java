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
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

  private Stage stage;
  private Scene createAccountScene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void password(ActionEvent actionEvent) {
    }

    public void usernameLogin(ActionEvent actionEvent) {
    }

    public void signInButton(ActionEvent actionEvent) throws IOException {
/*
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
      //stage.getIcons().add(new Image("WritingWizard\\Images\\Wizard2.png"));

      //"C:\Users\jjust\Documents\CSCI 4600\WritingWizard\Wizard2.png"
      Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
      //scene.getStylesheets().add("C:\\Users\\jjust\\Documents\\CSCI 4600\\WritingWizard\\WritingWizard\\src\\main\\java\\com\\example\\writingwizard\\stylesheet.css");
      stage.setTitle("Writing Wizard");
      stage.setScene(scene);
      stage.show();
*/
    }

  public void createNewAccount(ActionEvent actionEvent) throws IOException {
/*
      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-account1.fxml"));
      Scene scene = new Scene(fxmlLoader.load(), 1366, 768);

      stage.setScene(scene);
      stage.setTitle("Create Account"); // You can set a different title if needed
      stage.show();
*/
      stage.setScene(createAccountScene);
      stage.setTitle("Create Account");
      stage.show();
  }

    public void setCreateAccountScene(Scene createAccountScene) {
        this.createAccountScene = createAccountScene;
    }
}
