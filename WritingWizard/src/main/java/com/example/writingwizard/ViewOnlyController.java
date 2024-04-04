package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewOnlyController {
    private Stage stage;
    @FXML
    private Label viewOnlyDocumentName;
    @FXML
    private Button signOutViewOnlyButton;
    @FXML
    private TextArea docTextArea;
    @FXML
    private Label adminUsername;
    private Scene loginScene;

    //setters
    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }
    public void setAdminUsername(Label adminUsername){ this.adminUsername = adminUsername; }
    public void setDocTextArea(TextArea docTextArea){ this.docTextArea = docTextArea; }
    public void setSignOutViewOnlyButton(Button signOutViewOnlyButton){ this.signOutViewOnlyButton = signOutViewOnlyButton; }
    public void setViewOnlyDocumentName(Label viewOnlyDocumentName) { this.viewOnlyDocumentName = viewOnlyDocumentName; }
    //getters
    public Label getAdminUsername(){return adminUsername; }
    public TextArea getDocTextArea(){return docTextArea; }
    public Button getSignOutViewOnlyButton(){return signOutViewOnlyButton; }
    public Label getViewOnlyDocumentName() { return viewOnlyDocumentName; }

    //method
    public void signOutViewOnly(ActionEvent actionEvent) throws IOException {
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

    public void setStage(Stage stage) { this.stage = stage;
    }


}
