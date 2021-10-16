package fxAanestysRB;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


/**
 * @author meikkupyrhonen
 * @version 7.10.2021
 *
 */
public class AanestysMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AanestysGUIView.fxml"));
            // final Pane root = ldr.load();
            //final AanestysGUIController aanestysCtrl = (AanestysGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("aanestys.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Aanestys");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}