package com.example.writingwizard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loginLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene loginScene = new Scene(loginLoader.load(), 1366, 768);

        FXMLLoader createAccountLoader = new FXMLLoader(HelloApplication.class.getResource("create-account1.fxml"));
        Scene createAccountScene = new Scene(createAccountLoader.load(), 1366, 768);

        FXMLLoader textEditorLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene textEditorScene = new Scene(textEditorLoader.load(), 1366, 768);

        HelloController textEditorController = textEditorLoader.getController();
        textEditorController.setStage(stage);

        LoginController loginController = loginLoader.getController();
        loginController.setStage(stage);

        CreateAccountController createAccountController = createAccountLoader.getController();
        createAccountController.setStage(stage);

        loginController.setCreateAccountScene(createAccountScene);
        createAccountController.setLoginScene(loginScene);

        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();

        /*
        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("view-only.fxml"));

        Scene scene4 = new Scene(fxmlLoader4.load(),1366, 768);
        stage.setTitle("Writing Wizard");
        stage.setScene(scene4);
        stage.show();
        */

    }

    public static void main(String[] args) {
        launch();
    }
}