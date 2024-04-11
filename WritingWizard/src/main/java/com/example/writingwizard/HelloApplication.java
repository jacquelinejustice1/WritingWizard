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

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loginLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene loginScene = new Scene(loginLoader.load(), 1366, 768);

        FXMLLoader createAccountLoader = new FXMLLoader(HelloApplication.class.getResource("create-account1.fxml"));
        Scene createAccountScene = new Scene(createAccountLoader.load(), 1366, 768);

        FXMLLoader textEditorLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene textEditorScene = new Scene(textEditorLoader.load(), 1366, 768);

        FXMLLoader viewOnlyLoader = new FXMLLoader(HelloApplication.class.getResource("view-only.fxml"));
        Scene viewOnlyScene = new Scene(viewOnlyLoader.load(),1366,768);



        ViewOnlyController viewOnlyController = viewOnlyLoader.getController();
        viewOnlyController.setStage(stage);

        HelloController textEditorController = textEditorLoader.getController();
        textEditorController.setStage(stage);

        LoginController loginController = loginLoader.getController();
        loginController.setStage(stage);

        CreateAccountController createAccountController = createAccountLoader.getController();
        createAccountController.setStage(stage);

        loginController.setCreateAccountScene(createAccountScene);
        createAccountController.setLoginScene(loginScene);

        textEditorController.setTextEditorScene(loginScene);
        loginController.setTextEditorScene(textEditorScene);

        textEditorController.setTextEditorScene(createAccountScene);
        createAccountController.setTextEditorScene(textEditorScene);

        textEditorController.setLoginScene(loginScene);
        loginController.setTextEditorScene(textEditorScene);

        viewOnlyController.setLoginScene(loginScene);

        textEditorController.initializeFonts();
        textEditorController.initializeFontSize();
        textEditorController.initializeFontColor();

        textEditorScene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("stylesheet.css")).toExternalForm());

        textEditorController.initializeParAndWordCount();

        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");

       // stage.getIcons().add(new Image());
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}