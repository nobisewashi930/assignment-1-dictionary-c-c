/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candc;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import candc.lib.Speak;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.stage.StageStyle;


public class Controller implements Initializable {


    @FXML
    private Button closeButton;
    @FXML
    Stage stage;
    @FXML
    Label label;
    @FXML
    Label eWord;
    @FXML
    TextField textInput;
    @FXML
    WebView view;
    @FXML
    ListView listSearch;

    @FXML
    private void closeWindow(MouseEvent event) {
        stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void miniWindow(MouseEvent event) {
        stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void prTranslator() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("page/Paragraph.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("ABC");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitWindow(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void changeText() {
        label.setText("Button clicked");
    }

    @FXML
    private void speak(){
        Speak.toSpeech(eWord.getText());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine webEngine = view.getEngine();
        //empty icon
        URL linkEmpty = getClass().getResource("img/empty.svg");
        File fileEmpty = new File(linkEmpty.getPath());

        String imgEmpty = "<img src=\"" + fileEmpty.toURI() + "\" width='254'>";
        String empty = "<div style=\"top:45%;left:50%;transform:translate(-50%,-50%);padding:9px; position:fixed;text-align:center \">" + imgEmpty
                + "<br><div style=\"font-family:sans-serif;margin: 12px;font-size:14px; color:#bbb\">Nhập vào ô tìm kiếm để bắt đầu tra từ ngay thôi!</div></div>";
        webEngine.loadContent(empty);
        //listSeacrh
        listSearch.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(
                            ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
                        eWord.setText(newValue);
                    }
                });
        //input onchange
        textInput.textProperty().addListener((observable, old, value) ->  {
            System.out.println(value);
        });
        //demo listview
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường siêu đẹp trai");
        listSearch.getItems().add("Cường vẫn đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Hello");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        listSearch.getItems().add("Cường đẹp trai");
        //openwindow


    }

}