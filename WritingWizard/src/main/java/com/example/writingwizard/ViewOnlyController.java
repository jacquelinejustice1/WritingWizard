package com.example.writingwizard;


import DataStructures.TextFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Optional;

public class ViewOnlyController {
    private Stage stage;
    @FXML
    private Label viewOnlyDocumentName;
    @FXML
    private TextArea docTextArea;
    @FXML
    private Label adminUsername;
    private Scene loginScene;
    private Scene viewOnlyScene;


    //setters

    public void setTextEditorScene(Scene viewOnlyScene) {
        this.viewOnlyScene = viewOnlyScene;
    }
    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }
    public void setAdminUsername(String adminUsernameString){ adminUsername.setText(adminUsernameString); }
    public void setDocTextArea(String contents){ docTextArea.setText(contents); }
    public void setViewOnlyDocumentName(String viewOnlyDocumentNameString) { viewOnlyDocumentName.setText(viewOnlyDocumentNameString); }



    //method
    public void signOutViewOnly() {
        stage.setScene(loginScene);
        stage.setTitle("Writing Wizard");
        stage.show();
    }

    public void setStage(Stage stage) { this.stage = stage;
    }



    public void openFileViewOnly(ActionEvent actionEvent) {
        Label selectFile = new Label("Select a file to open (view only):");
        ComboBox<TextFile> textFileNamesVO = new ComboBox<>();
        textFileNamesVO.setPromptText("Document Name : Permission");
        HashMap<DataStructures.PermissionLevel, TextFile> filesMap = Manager.getFiles();

        for (TextFile file : filesMap.values()) {
            textFileNamesVO.getItems().add(file);
        }

        textFileNamesVO.setMinWidth(400);
        //setting the dialog up
        Dialog<ButtonType> openDialogVO = new Dialog<>();
        openDialogVO.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        openDialogVO.setTitle("Open Document");
        openDialogVO.setWidth(700);
        openDialogVO.setHeight(700);
        VBox dialogContentOpen = new VBox();
        dialogContentOpen.setSpacing(10);
        dialogContentOpen.setPadding(new Insets(10));

        dialogContentOpen.getChildren().add(selectFile);
        dialogContentOpen.getChildren().add(textFileNamesVO);

        openDialogVO.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
        openDialogVO.getDialogPane().setContent(dialogContentOpen);

        Optional<ButtonType> result = openDialogVO.showAndWait();
        ViewOnlyController viewOnlyController = new ViewOnlyController();

        if (result.isPresent() && result.get() == ButtonType.FINISH) {
            if(Manager.hasWrite()){
                Manager.openFile(textFileNamesVO.getValue());
            }else{
                Manager.openFile(textFileNamesVO.getValue());
                viewOnlyController.setDocTextArea(textFileNamesVO.getValue().getContent());
                viewOnlyController.setAdminUsername(Manager.currentuser.getName());
                viewOnlyController.setViewOnlyDocumentName(textFileNamesVO.getValue().getFileName());
                stage.setScene(viewOnlyScene);
                stage.setTitle("View Only");
                stage.show();
                //Manager.openFile(textFileNames.getValue());
            }
        }

        dialogContentOpen.getChildren().clear();

    }

}
