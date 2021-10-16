package fxAanestysRB;

import java.net.URL;
import java.util.ResourceBundle;
import fi.jyu.mit.fxgui.Chooser;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;



/**
 * Kontrolleri äänestykselle
 * @author meikkupyrhonen
 * @version 7.10.2021
 *
 */
public class AanestysGUIController implements Initializable  {
    @FXML private Label labelValittu;
    @FXML private Chooser<String> valinta;

    @FXML void handleAanesta() { aanesta(); 
    }
    
    int[] tulos = new int [4];
    private String vaihtoEhdot;
    private String[] vaihtoEhto;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valinta.addSelectionListener((e) -> nayta());
        labelValittu.setText("");
        vaihtoEhdot = valinta.getRivit();  
        System.out.println(vaihtoEhdot);// getObjects().toString(); 
        vaihtoEhto = vaihtoEhdot.split("\n");
       
    }
    
    
    private void nayta() {
        String s = valinta.getSelectedText();
        if ( s == null ) return;
        labelValittu.setText("Valittu: " + s);
    }


    private void aanesta() {
        // String kohde = valinta.getSelectedText();
        int i = valinta.getSelectedIndex();
        tulos[i] = tulos[i] + 1;
        Dialogs.showMessageDialog("Vastasit: " + vaihtoEhto[i] 
                + "\n Tilanne: \n" 
                + vaihtoEhto[0] + ": " + tulos[0] + " \n" 
                + vaihtoEhto[1] + ": " + tulos[1] + " \n" 
                + vaihtoEhto[2] + ": " + tulos[2] + " \n" 
                + vaihtoEhto[3] + ": " + tulos[3]);
    }

}
