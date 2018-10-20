/*
 * @author Kieu Chi Cong
 * @author Tran Manh Cuong
 */

package candc.lib;

public class Alert {
    public static void ErrorNetwork(){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setContentText("Can't connect to server. Please check you connection!");
        alert.showAndWait();
    }
}
