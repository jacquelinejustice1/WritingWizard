package com.example.writingwizard;

import DataStructures.Permission;
import DataStructures.TextFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ViewOnlyController {
    Manager manager = new Manager();
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
    private Scene viewOnlyScene;
    private Scene textEditorScene;

    //setters

    public void setTextEditorScene(Scene viewOnlyScene) {
        this.viewOnlyScene = viewOnlyScene;
    }
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


    public void openFileViewOnly(ActionEvent actionEvent) {
        Label selectFile = new Label("Select a file to open (view only):");
        ComboBox<String> textFileNamesVO = new ComboBox<>();
        textFileNamesVO.setPromptText("Document Name : Permission");
        HashMap<Permission[], TextFile> filesMap = manager.getFiles();

        for (TextFile file : filesMap.values()) {
            textFileNamesVO.getItems().add(file.getFileName());
        }

        textFileNamesVO.setMinWidth(400);
        //setting the dialog up
        Dialog<ButtonType> openDialog = new Dialog<>();
        openDialog.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        openDialog.setTitle("Open Document");
        openDialog.setWidth(700);
        openDialog.setHeight(700);
        VBox dialogContentOpen = new VBox();
        dialogContentOpen.setSpacing(10);
        dialogContentOpen.setPadding(new Insets(10));

        dialogContentOpen.getChildren().add(selectFile);
        dialogContentOpen.getChildren().add(textFileNamesVO);

        openDialog.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        openDialog.getDialogPane().setContent(dialogContentOpen);

        openDialog.showAndWait();

        dialogContentOpen.getChildren().clear();

    }

    public void setViewOnlyScene(Scene textEditorScene) {
        this.textEditorScene = textEditorScene;
    }
}
