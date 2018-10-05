package candc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import java.io.IOException;


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
                if(!event.getTarget().toString().equals("AnchorPane[id=resize]")){
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }else{
                    primaryStage.setWidth(event.getScreenX() - primaryStage.getX());
                    primaryStage.setHeight(event.getScreenY() - primaryStage.getY());
                }
            }
        });



        Scene scene = new Scene(root);
        scene.setFill(Color.rgb(255, 255, 255, 0));
        primaryStage.setMinHeight(460);
        primaryStage.setMinWidth(724);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
