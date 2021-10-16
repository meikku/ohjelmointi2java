package demo.d4.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
* @author meikkupyrhonen
* @version 29.9.2021
*
*/

public class IkaGUIController {

    @FXML
    private TextField textSyntymavuosi;

    @FXML
    private TextField textTulos;

    @FXML
    void keyReleased() {
        int tulos = laske();
        textTulos.setText(tulos + " ");
    }
   
    /**
     * oletusvuosi
     * public jotian jotain
     */
    public static final int OLETUSVUOSI = 2021;
    // ===============================


    
    /**
     * @return vuosi joka saatiin
     */
    
    public int laske() {
        int syntymaVuosi = haeLuku();
        return (OLETUSVUOSI - syntymaVuosi);
        //
    }
    
    /**
     * @return vuosi jonka käyttäjä syötti
     */
    private int haeLuku() {
        int vuosi = Integer.parseInt(textSyntymavuosi.getText() );  
        return vuosi;
    }
}