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



    }

  public void createNewAccount(ActionEvent actionEvent) throws IOException {

      stage.setScene(createAccountScene);
      stage.setTitle("Create Account");
      stage.show();
  }

    public void setCreateAccountScene(Scene createAccountScene) {
        this.createAccountScene = createAccountScene;
    }
}
