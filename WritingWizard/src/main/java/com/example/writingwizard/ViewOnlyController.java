package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ViewOnlyController {
    @FXML
    private Button signOutViewOnlyButton;
    @FXML
    private TextArea docTextArea;
    @FXML
    private Label adminUsername;

    //setters
    public void setAdminUsername(Label adminUsername){ this.adminUsername = adminUsername; }
    public void setDocTextArea(TextArea docTextArea){ this.docTextArea = docTextArea; }
    public void setSignOutViewOnlyButton(Button signOutViewOnlyButton){ this.signOutViewOnlyButton = signOutViewOnlyButton; }
    //getters
    public Label getAdminUsername(){return adminUsername; }
    public TextArea getDocTextArea(){return docTextArea; }
    public Button getSignOutViewOnlyButton(){return signOutViewOnlyButton; }

    //method
    public void signOutViewOnly(ActionEvent actionEvent) {
    }
}
