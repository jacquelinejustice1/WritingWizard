package com.example.writingwizard;


import DataStructures.Permission;
import DataStructures.PermissionLevel;
import DataStructures.TextFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static java.util.Arrays.asList;


public class EditorController {

    @FXML
    private Button underlineButton;
    @FXML
    private Button strikeButton;
    @FXML
    private Button rightAlignButton;
    @FXML
    private Button leftAlignButton;
    @FXML
    private Button centerAlignButton;
    Manager manager = new Manager();
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
    private Button shareButton;
    @FXML
    private Button openFileButton;
    @FXML
    private Button newFileButton;
    @FXML
    private TextField documentName;
    private Stage stage;
    @FXML
    private TextArea docTextArea;
    private Scene loginScene;

    //share dialog variables
    ComboBox<String> sharingOptions = new ComboBox<>();
    TextField shareUsernameDialog = new TextField();
    Label shareType = new Label("View Only, Modifiable, or None");
    Label usernameOptionLabel = new Label("Share with");

    //for text editing buttons
    String selectedText;
    Font font;

    //for clear button
    Label confirm = new Label("Are you sure you would \n like to clear the text area?");
    private Scene viewOnlyScene;

    //setters
    public void setViewOnlyScene(Scene viewOnlyScene) {
        this.viewOnlyScene = viewOnlyScene;
    }
    
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

    //getters
    public TextArea getDocTextArea(){
        return docTextArea;
    };
    public TextField getDocumentName(){
        return documentName;
    }

    /**
     * Initializes the Fonts for the Text Area
     */
    public void initializeFonts(){
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(fonts);
        fontSelect.setItems(items);
    }

    /**
     * Initializes the Font Size for the Text Area
     */
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


    /**
     * Initializes the Font Color for the Text Editor
     */
    public void initializeFontColor(){

        setColor(Color.BLACK);

        fontColor.setOnAction(e -> {
            setColor(fontColor.getValue());
        });
    }

    /**
     *
     * @param actionEvent
     * When the user selects a font, the font is changes in the text area
     */
    public void changeFontSize(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.NORMAL, 11);
            getDocTextArea().setFont(font);
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() == null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font("Arial",FontWeight.NORMAL,fontSize.getValue()));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,fontSize.getValue()));
        }
    }
    public void changeFont(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.NORMAL, 11);
            getDocTextArea().setFont(font);
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() == null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,11));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.NORMAL,fontSize.getValue()));
        }
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

        Optional<ButtonType> result = dialogClear.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.APPLY) {
            docTextArea.clear();
        }

    }
    /**
     *
     * @param actionEvent
     * Changes the font color
     */
    public void changeFontColor(ActionEvent actionEvent) {
        setColor(Color.BLACK);

        fontColor.setOnAction(e -> {
            setColor(fontColor.getValue());
        });

    }
    /**
     *
     * @param color uses to change the color of text in the text editor. Converts to RGB color code
     */
    private void setColor(Color color) {
        docTextArea.setStyle("-fx-text-fill: #" + toRGBCode(color));
    }

    /**
     *
     * @param color from the color the user selects from the Color Picker
     * @return the RGB color code from the color entered
     */
    private String toRGBCode(Color color) {
        return String.format("%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    /**
     * Counts the number of paragraphs the user types
     * Counts the number of words in the text area
     */
    @FXML
    void initializeParAndWordCount() {

        docTextArea.textProperty().addListener((observable, oldValue, newValue) -> {

            updateParagraphCount();
            updateWordCount();
        });
    }

    /**
     * Updates the paragraph count with an Observable List of type Character Sequence
     */
    @FXML
    void updateParagraphCount() {
        ObservableList<CharSequence> list = docTextArea.getParagraphs();
        int par = list.size();
        counter.setText("Paragraphs: " + par);
    }

    /**
     * Updates the word count by counting the number of Strings in an array
     */
    @FXML
    void updateWordCount() {
        String text = docTextArea.getText();

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        wordCounter.setText("Word Count: " + wordCount);
    }

    /**
     *
     * @param actionEvent
     * When user clicks Bold Text button, text in the text area turns bold.
     */
    public void boldText(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontWeight.BOLD, 11);
            getDocTextArea().setFont(font);
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = getDocTextArea().getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.BOLD,fontSize.getValue()));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() == null && fontSize.getValue() != null) {
            font = getDocTextArea().getFont();
            getDocTextArea().setFont(Font.font("Arial",FontWeight.BOLD,fontSize.getValue()));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() == null) {
            font = getDocTextArea().getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontWeight.BOLD,11));
        }

    }

    /**
     *
     * @param actionEvent
     * When the user clicks the italic Text button, text in the text area turns italic
     */
    public void italicText(ActionEvent actionEvent) {
        if(fontSelect.getValue() == null && fontSize.getValue() == null){
            font = Font.font("Arial", FontPosture.ITALIC, 11);
            getDocTextArea().setFont(font);
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontPosture.ITALIC,fontSize.getValue()));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() == null && fontSize.getValue() != null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font("Arial",FontPosture.ITALIC,fontSize.getValue()));
        }
        if (!getDocTextArea().getText().isEmpty() && fontSelect.getValue() != null && fontSize.getValue() == null) {
            font = docTextArea.getFont();
            getDocTextArea().setFont(Font.font(fontSelect.getValue(),FontPosture.ITALIC,11));
        }
    }

    /**
     *
     * @param actionEvent
     * When the user clicks the Underline Text button, text in the text area is underlined
     */
    public void underlineText(ActionEvent actionEvent) {
        underlineButton.setOnAction(e ->{
            docTextArea.getStyleClass().clear();
            docTextArea.getStyleClass().add("underline-textarea");
        });
    }

    /**
     *
     * @param actionEvent
     * When the user clicks the strike button, text in the text area is struck out
     */
    public void strikeText(ActionEvent actionEvent) {
        strikeButton.setOnAction(e ->{
            docTextArea.getStyleClass().clear();
            docTextArea.getStyleClass().add("strike-out-textarea");
        });

    }

    /**
     *
     * @param actionEvent
     * Aligns text in the textarea to the right alignment
     */
    public void rightAlignment(ActionEvent actionEvent) {
        rightAlignButton.setOnAction(e ->{
            docTextArea.getStyleClass().clear();
            docTextArea.getStyleClass().add("right-aligned-textarea");
        });

    }
    /**
     *
     * @param actionEvent
     * When clicked, the text in the text area is aligned to the left
     */
    public void leftAlignment(ActionEvent actionEvent){
        leftAlignButton.setOnAction(e ->{
            docTextArea.getStyleClass().clear();
            docTextArea.getStyleClass().add("left-aligned-textarea");
        });
    }
    /**
     *
     * @param actionEvent
     * When clicked, the text in the text area is center aligned
     */
    public void centerAlignment(ActionEvent actionEvent) {
        centerAlignButton.setOnAction(e -> {
            docTextArea.getStyleClass().clear();
            docTextArea.getStyleClass().add("centered-textarea");
        });

    }

        /**
         *
         * @param actionEvent
         * When the user clicks the sign-out button, the stage is returned to the login stage
         */
    public void signOut(ActionEvent actionEvent) {
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

    /**
     *
     * @param actionEvent
     * When the user clicks the share document button, a dialog appears on the screen
     * that gives the user 2 options:
     * 1- choose view-only, modifiable, or none permission levels
     * 2- Enter the username of whom the user wishes to give the permissions to
     */
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
        sharingOptions.getItems().addAll("View Only", "Modifiable","None");
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

    public void openDocument(ActionEvent actionEvent) {
        Label selectFile = new Label("Select a file to open:");
        ComboBox<TextFile> textFileNames = new ComboBox<>();
        textFileNames.setPromptText("Document Name : Permission");
        HashMap<PermissionLevel, TextFile> filesMap = Manager.getFiles();

        for (TextFile file : filesMap.values()) {
            textFileNames.getItems().add(file);
        }

        textFileNames.setMinWidth(400);
        //setting the dialog up
        Dialog<ButtonType> openDialog = new Dialog<>();
        openDialog.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        openDialog.setTitle("Open Document");
        openDialog.setWidth(900);
        openDialog.setHeight(700);
        VBox dialogContentOpen = new VBox();
        dialogContentOpen.setSpacing(10);
        dialogContentOpen.setPadding(new Insets(10));

        dialogContentOpen.getChildren().add(selectFile);
        dialogContentOpen.getChildren().add(textFileNames);

        openDialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        openDialog.getDialogPane().setContent(dialogContentOpen);

        Optional<ButtonType> result = openDialog.showAndWait();

       // if (Manager.hasWrite()) {
            //Manager.openFile(TextFile);
       // } else {
            //Manager.openFile(TextFile);
            //view only
       // }

        if (result.isPresent() && result.get() == ButtonType.FINISH) {
            if(Manager.hasWrite()){
                Manager.openFile(textFileNames.getValue());
            }else{
                Manager.openFile(textFileNames.getValue());
                stage.setScene(viewOnlyScene);
                stage.setTitle("View Only");
                stage.show();
            }
        }
        dialogContentOpen.getChildren().clear();
    }

    public void createNewDocument(ActionEvent actionEvent) {
        Label confirmNewDoc = new Label("Would you like to create a new document?");
        Label confirmBeforeDelete = new Label("Make sure the current document is saved before proceeding.");
        Dialog<ButtonType> newDocDialog = new Dialog<>();
        newDocDialog.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        newDocDialog.setTitle("Create New Document");
        newDocDialog.setWidth(500);
        newDocDialog.setHeight(250);
        VBox dialogContentNewFile = new VBox();
        dialogContentNewFile.setSpacing(10);
        dialogContentNewFile.setPadding(new Insets(10));

        dialogContentNewFile.getChildren().add(confirmNewDoc);
        dialogContentNewFile.getChildren().add(confirmBeforeDelete);

        newDocDialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        newDocDialog.getDialogPane().setContent(dialogContentNewFile);

        Optional<ButtonType> result = newDocDialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.FINISH) {
            docTextArea.clear();
            Manager.createFile(documentName.getText(),docTextArea.getText());

        }

    }

    public void saveDocument(ActionEvent actionEvent) {
        if(getDocumentName().getText().isEmpty()){
            Dialog<ButtonType> saveDocumentName = new Dialog<>();
            TextField docNameIfEmpty = new TextField();
            docNameIfEmpty.setPromptText(("Enter document name here"));
            Label docNameEnter = new Label("The document is not named, please enter a name:");
            saveDocumentName.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            saveDocumentName.setTitle("Create New Document");
            saveDocumentName.setWidth(500);
            saveDocumentName.setHeight(250);
            VBox dialogContentSaveFile = new VBox();
            dialogContentSaveFile.setSpacing(10);
            dialogContentSaveFile.setPadding(new Insets(10));

            dialogContentSaveFile.getChildren().add(docNameEnter);
            dialogContentSaveFile.getChildren().add(docNameIfEmpty);

            saveDocumentName.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
            saveDocumentName.getDialogPane().setContent(dialogContentSaveFile);

            Optional<ButtonType> result = saveDocumentName.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.APPLY) {
                Manager.currentFile.setFileName(docNameIfEmpty.getText());
                manager.saveFile(docTextArea.getText());

            }

        }else {
            Manager.currentFile.setFileName(documentName.getText());
            manager.saveFile(docTextArea.getText());
        }
    }


}