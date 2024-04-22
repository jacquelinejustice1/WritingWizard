package com.example.writingwizard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loginLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene loginScene = new Scene(loginLoader.load(), 1366, 768);

        FXMLLoader createAccountLoader = new FXMLLoader(MainApplication.class.getResource("create-account1.fxml"));
        Scene createAccountScene = new Scene(createAccountLoader.load(), 1366, 768);

        FXMLLoader textEditorLoader = new FXMLLoader(MainApplication.class.getResource("text-editor.fxml"));
        Scene textEditorScene = new Scene(textEditorLoader.load(), 1366, 768);

        FXMLLoader viewOnlyLoader = new FXMLLoader(MainApplication.class.getResource("view-only.fxml"));
        Scene viewOnlyScene = new Scene(viewOnlyLoader.load(),1366,768);

        ViewOnlyController viewOnlyController = viewOnlyLoader.getController();
        viewOnlyController.setStage(stage);

        EditorController textEditorController = textEditorLoader.getController();
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

        textEditorController.setViewOnlyScene(viewOnlyScene);
        viewOnlyController.setTextEditorScene(textEditorScene);

        viewOnlyController.setLoginScene(loginScene);
        viewOnlyController.setViewOnlyScene(textEditorScene);
        textEditorController.setTextEditorScene(viewOnlyScene);

        textEditorController.initializeFonts();
        textEditorController.initializeFontSize();
        textEditorController.initializeFontColor();
        textEditorController.initializeParAndWordCount();

        textEditorScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}