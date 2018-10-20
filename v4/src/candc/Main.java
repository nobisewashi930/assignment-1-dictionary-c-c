/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);


        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });



        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println(event.getY()-yOffset);
                if(event.getTarget().toString().equals("AnchorPane[id=resize]")){
                    primaryStage.setWidth(event.getScreenX() - primaryStage.getX());
                    primaryStage.setHeight(event.getScreenY() - primaryStage.getY());
                }else if(event.getTarget().toString().indexOf("ImageView")!=0){
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            }
        });



        Scene scene = new Scene(root);
        scene.setFill(Color.rgb(255, 255, 255, 0));
        primaryStage.setMinHeight(576);
        primaryStage.setMinWidth(852);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
