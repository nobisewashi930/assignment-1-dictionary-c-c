/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc.lib;

import candc.Pragraph;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSecondaryController extends Pragraph {
    private long recordThread = 0;

    @FXML
    private TextArea inputText;

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(inputText);
    }
}