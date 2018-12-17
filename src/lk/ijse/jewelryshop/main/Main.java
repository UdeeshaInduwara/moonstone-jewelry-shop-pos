package lk.ijse.jewelryshop.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Logger logger = Logger.getLogger("");
        FileHandler fileHandler = new FileHandler("error.log",true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        Parent root=FXMLLoader.load(this.getClass().getResource("/lk/ijse/jewelryshop/view/LogInForm.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Moonstone Jewelry Shop Management System");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
