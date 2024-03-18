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


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            //stage.getIcons().add(new Image("WritingWizard\\Images\\Wizard2.png"));

            //"C:\Users\jjust\Documents\CSCI 4600\WritingWizard\Wizard2.png"
            Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
            //scene.getStylesheets().add("C:\\Users\\jjust\\Documents\\CSCI 4600\\WritingWizard\\WritingWizard\\src\\main\\java\\com\\example\\writingwizard\\stylesheet.css");
            stage.setTitle("Writing Wizard");
            stage.setScene(scene);
            stage.show();

        //login in
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));

        Scene scene2 = new Scene(fxmlLoader2.load(),1366, 768);
        stage.setTitle("Writing Wizard");
        stage.setScene(scene2);
        stage.show();

        //create account
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("create-account1.fxml"));

        Scene scene3 = new Scene(fxmlLoader3.load(),1366, 768);
        stage.setTitle("Writing Wizard");
        stage.setScene(scene3);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}