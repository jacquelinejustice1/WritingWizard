package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountController {
    private Stage stage;
    private Scene loginScene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String createNewUsername(ActionEvent actionEvent){
        return null;
    }

    public void createUsernameReenter(ActionEvent actionEvent) {
    }

    public void createPassword(ActionEvent actionEvent) {
    }

    public void createPasswordReenter(ActionEvent actionEvent) {
    }

    public void saveFirstPetQuestion(ActionEvent actionEvent) {
    }

    public void saveMotherName(ActionEvent actionEvent) {
    }

    public void submitAccountInfo(ActionEvent actionEvent) {
    }

    public void saveSchool(ActionEvent actionEvent) {
    }

    public void returnToLogIn(ActionEvent actionEvent) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);

        stage.setScene(scene);
        stage.setTitle("Login"); // You can set a different title if needed
        stage.show();
        */

        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }
}
