package demo.d3.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * Lasketaan tietoja huoneesta
 * @author meikkupyrhonen
 * @version 26.9.2021
 *
 */
public class HuoneMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("HuoneGUIView.fxml"));
            final Pane root = ldr.load();
            final HuoneGUIController huoneCtrl = (HuoneGUIController) ldr.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("huone.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Huone");
            primaryStage.show();
            huoneCtrl.laske(getParameters());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Käynnistetään huone-ohjelma
     * @param args huoneen mitat järjestyksessä pituus, leveys, korkeus
     */
    public static void main(String[] args) {
        launch(args);
    }
}