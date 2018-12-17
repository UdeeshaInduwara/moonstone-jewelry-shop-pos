package lk.ijse.jewelryshop.controller.utils;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Notification {

    public static void showWarningMessage(String message){
        Notifications notifications=Notifications.create()
                .title("Warning")
                .text(message)
                .graphic(new ImageView(new Image("/lk/ijse/jewelryshop/assest/Attention_40px.png")))
                .hideAfter(Duration.seconds(2))
                .position(Pos.CENTER);
        notifications.show();
    }
    public static void showFailureMessage(String message){
        Notifications notifications=Notifications.create()
                .title("Failed")
                .text(message)
                .graphic(new ImageView(new Image("/lk/ijse/jewelryshop/assest/Cancel_40px.png")))
                .hideAfter(Duration.seconds(2))
                .position(Pos.CENTER);
        notifications.show();
    }
    public static void showConformationeMessage(String message){
        Notifications notifications=Notifications.create()
                .title("Conformation")
                .text(message)
                .graphic(new ImageView(new Image("/lk/ijse/jewelryshop/assest/Ok_40px.png")))
                .hideAfter(Duration.seconds(2))
                .position(Pos.CENTER);
        notifications.show();
    }
    public static void showAttrntionMessage(String message){
        Notifications notifications=Notifications.create()
                .title("Attention")
                .text(message)
                .graphic(new ImageView(new Image("/lk/ijse/jewelryshop/assest/Info_35px.png")))
                .hideAfter(Duration.seconds(2))
                .position(Pos.CENTER);
        notifications.show();
    }
}
