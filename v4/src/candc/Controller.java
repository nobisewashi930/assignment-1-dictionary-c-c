/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc;
import candc.lib.Speak;
import candc.lib.Windows;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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
    public void prTranslator() throws IOException {
        Windows w=new Windows("Paragraph");
//        System.out.println(w.getPopupstage().getClass());;
//        class FXMLControl implements Initializable{
//            @FXML
//            public TextArea inputText;
//
//            @Override
//            public void initialize(URL location, ResourceBundle resources) {
//
//            }
//        }
//        FXMLControl c=w.loader().getController();
//        System.out.println(c.inputText.getText());
    }

    @FXML
    private void info() throws IOException {
        Windows w=new Windows("About");
    }

    @FXML
    private void exitWindow(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void changeText() {
        listSearch.getItems().clear();
    }

    @FXML
    private void speak(){
        Runnable task = () -> {
            Speak.toSpeech(eWord.getText());
        };
        Thread thread = new Thread(task);
        thread.start();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        ConfigConnection configConnection = new ConfigConnection();
//        Connection conn = configConnection.getConnection(ConfigConnection.DB_URL,ConfigConnection.USER_NAME, ConfigConnection.PASSWORD);
//        DictionaryCommandline dc = new DictionaryCommandline();

        WebEngine webEngine = view.getEngine();
        //empty icon
        URL linkEmpty = getClass().getResource("img/empty.svg");
        File fileEmpty = new File(linkEmpty.getPath());

        String imgEmpty = "<img src=\"" + fileEmpty.toURI() + "\" width='254'>";
        String empty = "<div style=\"top:45%;left:50%;transform:translate(-50%,-50%);padding:9px; position:fixed;text-align:center \">" + imgEmpty
                + "<br><div style=\"font-family:sans-serif;margin: 12px;font-size:14px; color:#bbb\">Nhập vào ô tìm kiếm để bắt đầu tra từ ngay thôi!</div></div>";
        webEngine.loadContent(empty);
        //listSeacrh

        //input onchange

        textInput.textProperty().addListener((observable, old, value) -> {

//            Dictionary dict = configConnection.getData(conn,value);
            listSearch.getItems().clear();
//            for(int i =0 ;i< dict.arWords.size();i++) {
//                listSearch.getItems().add(dict.arWords.get(i).word_target);
//            }
            listSearch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {


                    eWord.setText(newValue);

//                    String result =dc.dictionarySearcher(dict,newValue);
//                    webEngine.loadContent(result);

                }
            });
        });
    }
}