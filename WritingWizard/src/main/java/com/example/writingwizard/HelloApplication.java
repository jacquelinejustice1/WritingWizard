package com.example.writingwizard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.getIcons().add(new Image("C:\\Users\\jjust\\Documents\\CSCI 4600\\WritingWizard\\Wizard2.png"));
        //"C:\Users\jjust\Documents\CSCI 4600\WritingWizard\Wizard2.png"
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        //scene.getStylesheets().add("C:\\Users\\jjust\\Documents\\CSCI 4600\\WritingWizard\\WritingWizard\\src\\main\\java\\com\\example\\writingwizard\\stylesheet.css");
        stage.setTitle("Writing Wizard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}