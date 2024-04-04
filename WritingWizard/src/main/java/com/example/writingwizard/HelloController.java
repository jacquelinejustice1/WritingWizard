package com.example.writingwizard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class HelloController {

    @FXML
    private Button saveDocumentButton;
    @FXML
    private ComboBox<Font> fontSelect;
    @FXML
    private ColorPicker fontColor;
    @FXML
    private ComboBox<FontWeight> fontSize;
    @FXML
    private Button signOutButton;
    @FXML
    private Button shareButton;
    @FXML
    private Button openFileButton;
    @FXML
    private Button newFileButton;
    @FXML
    private Button boldText;
    @FXML
    private Button italicText;
    @FXML
    private Button underlineText;
    @FXML
    private Button strikeText;
    @FXML
    private Button centerAlignment;
    @FXML
    private Button leftAlignment;
    @FXML
    private Button rightAlignment;
    @FXML
    private TextField documentName;
    private Stage stage;
    private Scene textEditorScene;
    @FXML
    private TextArea docTextArea;

    private Scene loginScene;

    //setters
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setTextEditorScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }
    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }
    public void setDocTextArea(TextArea docTextArea){
        this.docTextArea = docTextArea;
    }
    public void setDocumentName(TextField documentName){ this.documentName = documentName; }
    public void setRightAlignment(Button rightAlignment){ this.rightAlignment = rightAlignment; }
    public void setLeftAlignment(Button leftAlignment){ this.leftAlignment = leftAlignment; }
    public void setCenterAlignment(Button centerAlignment){ this.centerAlignment = centerAlignment; }
    public void setStrikeText(Button strikeText){ this.strikeText = strikeText; }
    public void setUnderlineText(Button underlineText){ this.underlineText = underlineText; }
    public void setItalicText(Button italicText){ this.italicText = italicText; }
    public void setBoldText(Button boldText){ this.boldText = boldText; }
    public void setShare(Button shareButton){ this.shareButton = shareButton; }
    public void setSignOutMenuButton(Button signOutButton){this.signOutButton = signOutButton; }
    public void setFontSize(ComboBox<FontWeight> fontSize){ this.fontSize = fontSize; }
    public void setFontColor(ColorPicker fontColor){ this.fontColor = fontColor; }
    public void setFontSelect(ComboBox<Font> fontSelect){ this.fontSelect = fontSelect; }
    public void setSaveDocumentButton(Button saveDocumentButton){ this.saveDocumentButton = saveDocumentButton; }

    //getters
    public TextArea getDocTextArea(){
        return docTextArea;
    };
    public TextField getDocumentName() { return documentName; }
    public Button getRightAlignment() { return rightAlignment; }
    public Button getLeftAlignment() { return leftAlignment; }
    public Button getCenterAlignment() { return centerAlignment; }
    public Button getStrikeText() {return strikeText; }
    public Button getUnderlineText(){ return underlineText; }
    public Button getItalicText() { return italicText; }
    public Button getBoldText() {return boldText;}
    public Button getShareButton(){ return shareButton; }
    public Button getSignOutButton(){return signOutButton; }
    public ComboBox<FontWeight> getFontSize(){ return fontSize; }
    public ColorPicker getFontColor() {return fontColor; }
    public ComboBox<Font> getFontSelect(){ return fontSelect; }
    public Button getSaveDocumentButton() { return saveDocumentButton; }


    //methods
    public void documentName(ActionEvent actionEvent) {
    }

    public void boldText(ActionEvent actionEvent) {
    }

    public void italicText(ActionEvent actionEvent) {
    }

    public void underlineText(ActionEvent actionEvent) {
    }

    public void strikeText(ActionEvent actionEvent) {
    }

    public void rightAlignment(ActionEvent actionEvent) {
    }

    public void leftAlignment(ActionEvent actionEvent) {
    }

    public void centerAlignment(ActionEvent actionEvent) {
    }

    public void signOut(ActionEvent actionEvent) {
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

    public void share(ActionEvent actionEvent) {
    }

    public void createNewFile(ActionEvent actionEvent) {
    }

    public void changeFontSize(ActionEvent actionEvent) {
    }

    public void changeFontColor(ActionEvent actionEvent) {
    }

    public void shareDocument(ActionEvent actionEvent) {
    }

    public void openDocument(ActionEvent actionEvent) {
    }

    public void createNewDocument(ActionEvent actionEvent) {
    }

    public void saveDocument(ActionEvent actionEvent) {
    }
}