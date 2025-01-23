package zea.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import zea.Zea;

import java.io.IOException;

/**
 * Main class to start running the GUI
 */
public class Main extends Application {
    private Zea zea = new Zea("data/zea.txt");

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane root = fxmlLoader.load();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            fxmlLoader.<MainWindow>getController().setZea(zea);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
