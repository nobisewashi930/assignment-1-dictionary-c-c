/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc.lib;

import candc.Pragraph;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class Windows extends Window {
    private static Stage stage;
    private static FXMLLoader fxmlLoader;
    public Windows(String page) throws IOException {
        final double[] xOffset = {0};
        final double[] yOffset = {0};
//        Parent root = FXMLLoader.load(getClass().getResource("../page/"+page+".fxml"));
//        .setLocation(getClass().getResource("second.fxml"));
        fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../page/"+page+".fxml"));
        Pane frame = fxmlLoader.load();

        stage=new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);

        frame.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset[0] = event.getSceneX();
                yOffset[0] = event.getSceneY();
            }
        });

        frame.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset[0]);
                stage.setY(event.getScreenY() - yOffset[0]);

            }
        });

        Scene scene = new Scene(frame);
        stage.setScene(scene);
        stage.show();

        Pragraph c = (Pragraph) fxmlLoader.getController();
        c.inputText.setText("344");
    }

    public static void setStage(Stage stage) {
        Windows.stage = stage;
    }

    public FXMLLoader loader(){
        return fxmlLoader;
    }

    public Stage getPopupstage() {
        return stage;
    }
}