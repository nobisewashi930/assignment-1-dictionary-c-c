/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc;

//use JSON https://github.com/douglascrockford/JSON-java
//use Audio Player https://github.com/wihoho/java-google-translate-text-to-speech

import candc.lib.A;
import candc.lib.Recognize;
import candc.lib.Translate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;
import java.util.Set;

public class Pragraph extends A {
    private long recordThread = 0;
    @FXML
    Stage stage;

    @FXML
    private void closeWindow(MouseEvent event) {
        stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public TextArea inputText;
    @FXML
    TextArea outputText;

    @FXML
    Label slLabel;
    @FXML
    Label tlLabel;

    @FXML
    Button recordBtn;
    @FXML
    ImageView micLoad;

    @FXML
    private void transaltor() throws UnsupportedEncodingException {

        outputText.setText("Translating....");

        String sl = slLabel.getText().substring(0, 2).toLowerCase();
        String tl = tlLabel.getText().substring(0, 2).toLowerCase();

        String text = URLEncoder.encode(inputText.getText(), "UTF-8");

        String result = Translate.getAPI(sl, tl, text);

        outputText.setText("");
        outputText.appendText(result);
    }

    @FXML
    private void speak() throws UnsupportedEncodingException {
        String tl = tlLabel.getText().substring(0, 2).toLowerCase();
        String text = URLEncoder.encode(outputText.getText(), "UTF-8");

        Translate.speakAPI(tl, text);
    }

    @FXML
    private void speakAPI() throws FileNotFoundException {
//        if(recordThread!=null){
//            System.out.println(recordThread.getName());
//        }


        if (recordThread != 0) {
            System.out.println("Done");
            Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
            for (Thread threadItem : setOfThread)
                if (threadItem.getId() == recordThread) {
                    threadItem.stop();
                    System.out.println("kill");
                }
            recordThread=0;
            //done
            inputText.setPromptText("Type in here....");
            recordBtn.setStyle("-fx-background-color: #1976D2");

            micLoad.setImage(new Image("candc/img/microphone.png"));
            return;
        }


        inputText.setText("");
        inputText.setPromptText("Listening you...");
        recordBtn.setStyle("-fx-background-color: #1a2746");

        micLoad.setImage(new Image("candc/img/loading.gif"));


        String sl = slLabel.getText().substring(0, 2).toLowerCase();

        Runnable task = () -> {

            Recognize.run(inputText, sl);

            //done
            inputText.setPromptText("Type in here....");
            recordBtn.setStyle("-fx-background-color: #1976D2");

            micLoad.setImage(new Image("candc/img/microphone.png"));

            recordThread=0;

            try {
                transaltor();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        };

        Thread thread = new Thread(task);
        recordThread=thread.getId();
        thread.start();

        System.out.println(thread.getId());

        System.out.println("hi ");
    }

    public void addText(String text) {
        inputText.appendText(text);
    }

    @FXML
    private void swapLang() {
        String swap = slLabel.getText();
        //swap language
        slLabel.setText(tlLabel.getText());
        tlLabel.setText(swap);
        //swap content
        swap = inputText.getText();
        inputText.setText(outputText.getText());
        outputText.setText(swap);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputText.setWrapText(true);
        outputText.setWrapText(true);

        slLabel.setText("English");
        tlLabel.setText("Vietnamese");
    }

}