package com.example.writingwizard;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Optional;


public class HelloController {


    @FXML
    private Button clearTextAreaButton;
    @FXML
    private Label counter;
    @FXML
    private Label wordCounter;
    @FXML
    private Button saveDocumentButton;
    @FXML
    private ComboBox<String> fontSelect = new ComboBox<>();
    @FXML
    private ColorPicker fontColor;
    @FXML
    private ComboBox<Integer> fontSize = new ComboBox<>();
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
    @FXML
    private TextArea docTextArea;

    private Scene loginScene;
    //share dialog variables
    ComboBox<String> sharingOptions = new ComboBox<>();
    TextField shareUsernameDialog = new TextField();
    Label shareType = new Label("View Only or Modifiable");
    Label usernameOptionLabel = new Label("Share with");

    //for text editing buttons
    String selectedText;
    Font font;

    //for clear button
    Label confirm = new Label("Are you sure you would \n like to clear the text area?");


    //setters
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setTextEditorScene(Scene textEditorScene) {
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
    public void setFontSize(ComboBox<Integer> fontSize){ this.fontSize = fontSize; }
    public void setFontColor(ColorPicker fontColor){ this.fontColor = fontColor; }
    public void setFontSelect(ComboBox<String> fontSelect){ this.fontSelect = fontSelect; }
    public void setSaveDocumentButton(Button saveDocumentButton){ this.saveDocumentButton = saveDocumentButton; }
    public void setOpenFileButton(Button openFileButton){ this.openFileButton = openFileButton; }
    public void setNewFileButton(Button newFileButton){this.newFileButton = newFileButton; }

    //getters
    public TextArea getDocTextArea(){
        return docTextArea;
    };
    public Label getCounter() {
        return counter;
    }
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
    public ComboBox<Integer> getFontSize(){ return fontSize; }
    public ColorPicker getFontColor() {return fontColor; }
    public ComboBox<String> getFontSelect(){ return fontSelect; }
    public Button getSaveDocumentButton() { return saveDocumentButton; }
    public Button getNewFileButton() { return newFileButton; }
    public Button getOpenFileButton() { return openFileButton; }


    //fonts combobox
    public void initializeFonts(){
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(fonts);
        fontSelect.setItems(items);
    }
    public void initializeFontSize(){
        ObservableList<Integer> fontSizeOptions = FXCollections.observableArrayList();
        fontSizeOptions.add(9);
        fontSizeOptions.add(10);
        fontSizeOptions.add(11);
        fontSizeOptions.add(12);
        fontSizeOptions.add(14);
        fontSizeOptions.add(16);
        fontSizeOptions.add(18);
        fontSizeOptions.add(20);
        fontSizeOptions.add(22);
        fontSizeOptions.add(24);
        fontSizeOptions.add(36);
        fontSizeOptions.add(48);
        fontSize.setItems(fontSizeOptions);

    }
    public void initializeFontColor(){

        setColor(Color.BLACK);

        fontColor.setOnAction(e -> {
            setColor(fontColor.getValue());
        });
    }

    private void setColor(Color color) {
        docTextArea.setStyle("-fx-text-fill: #" + toRGBCode(color));
    }

    private String toRGBCode(Color color) {
        return String.format("%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    @FXML
    void initializeParAndWordCount() {

        docTextArea.textProperty().addListener((observable, oldValue, newValue) -> {

            updateParagraphCount();
            updateWordCount();
        });
    }
    @FXML
    void updateParagraphCount() {
        ObservableList<CharSequence> list = docTextArea.getParagraphs();
        int par = list.size();
        counter.setText("Paragraphs: " + par);
    }
    @FXML
    void updateWordCount() {
        String text = docTextArea.getText();

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        wordCounter.setText("Word Count: " + wordCount);
    }

    //methods
    public void documentName(ActionEvent actionEvent) {
    }

    public void boldText(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.BOLD, 11);
            getDocTextArea().setFont(font);
        }
        selectedText = getDocTextArea().getSelectedText();
        if (!selectedText.isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = getDocTextArea().getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.BOLD,fontSize.getValue()));
        }

    }
    public void italicText(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontPosture.ITALIC, 11);
            getDocTextArea().setFont(font);
        }
        selectedText = getDocTextArea().getSelectedText();
        if (!selectedText.isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontPosture.ITALIC,fontSize.getValue()));
        }


    }

    public void underlineText(ActionEvent actionEvent) {

    }

    public void strikeText(ActionEvent actionEvent) {
            //CSS SHEET
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


    public void shareDocument(ActionEvent actionEvent) {
        //setting the dialog up
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        dialog.setTitle("Share Document");
        dialog.setWidth(500);
        dialog.setHeight(500);
        VBox dialogContent = new VBox();
        dialogContent.setSpacing(10);
        dialogContent.setPadding(new Insets(10));

        //adding what type of share file
        dialogContent.getChildren().add(shareType);
        sharingOptions.getItems().addAll("View Only", "Modifiable");
        dialogContent.getChildren().addAll(sharingOptions);

        //adding username
        dialogContent.getChildren().add(usernameOptionLabel);
        shareUsernameDialog.setPromptText("Enter username here");
        dialog.getDialogPane().setContent(dialogContent);
        dialogContent.getChildren().add(shareUsernameDialog);

        //buttons
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);

        dialog.showAndWait();

        //clearing when done
        dialogContent.getChildren().clear();
        sharingOptions.getItems().clear();

    }


    public void createNewFile(ActionEvent actionEvent) {
    }

    public void changeFontSize(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.NORMAL, 11);
            getDocTextArea().setFont(font);
        }
        selectedText = getDocTextArea().getSelectedText();
        if (!selectedText.isEmpty() && fontSelect.getValue() == null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font("Arial",FontWeight.NORMAL,fontSize.getValue()));
        }
        if (!selectedText.isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,fontSize.getValue()));
        }


    }
    public void changeFont(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.NORMAL, 11);
            getDocTextArea().setFont(font);
        }
        selectedText = getDocTextArea().getSelectedText();
        if (!selectedText.isEmpty() && fontSelect.getValue() != null && fontSize.getValue() == null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,11));
        }
        if (!selectedText.isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,fontSize.getValue()));
        }
    }

    public void changeFontColor(ActionEvent actionEvent) {
        setColor(Color.BLACK);

        fontColor.setOnAction(e -> {
            setColor(fontColor.getValue());
        });

    }

    public void clearTextArea(ActionEvent actionEvent) {
        Dialog<ButtonType> dialogClear = new Dialog<>();
        dialogClear.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        dialogClear.setTitle("Clear TextArea");
        dialogClear.setWidth(500);
        dialogClear.setHeight(150);
        VBox dialogContentClear = new VBox();
        dialogContentClear.setSpacing(10);
        dialogContentClear.setPadding(new Insets(10));

        dialogContentClear.getChildren().add(confirm);

        dialogClear.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
        dialogClear.getDialogPane().setContent(dialogContentClear);
        //dialogClear.showAndWait();
        Optional<ButtonType> result = dialogClear.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.APPLY) {
            docTextArea.clear();
        }

    }

    public void openDocument(ActionEvent actionEvent) {
    }

    public void createNewDocument(ActionEvent actionEvent) {
    }

    public void saveDocument(ActionEvent actionEvent) {
    }


}