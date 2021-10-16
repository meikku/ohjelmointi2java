package demo.d3.fx;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.ohj2.*;
import javafx.application.Application.Parameters;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;



/**
 * @author meikkupyrhonen
 * @version 26.9.2021
 *
 */
public class HuoneGUIController implements Initializable{

    @FXML private TextField textKorkeus;

    @FXML private TextField textPituus;

    @FXML private TextField textLeveys;

    @FXML private TextField textPintaAla;

    @FXML private TextField textTilavuus;

    @FXML private void keyReleased() {
        laske();

    }
    
    @FXML private void onEnter(final ActionEvent action) {
        ((TextField)(action.getSource())).selectAll();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Platform.runLater( () -> textKartalla.requestFocus());
        laske();
    }

    // ======================================

    /**
     * Haetaan tekstikentästä luku
     * @param text kenttä jota haetaan
     * @param oletus luvun arvo jos kentästä ei saa järkevää lukua
     * @return kentästä haettu luku
     * @example
     * @example
     * <pre name="test">
     * #TOLERANCE=0.01
     * #import javafx.embed.swing.JFXPanel;
     * #import javafx.scene.control.*;
     * (new JFXPanel()).toString();
     * haeLuku(new TextField("234.233"), 44 ~~~ 234.23;
     * haeLuku(new TextField("foobar1"), 44 ~~~ 44.00;
     * haeLuku(new TextField("1foobar"), 44 ~~~ 1.00;
     * </pre>
     */
    public static double haeLuku(TextField text, double oletus) {
        double luku = Mjonot.erotaDouble(text.getText(), oletus);
        return luku;
    }
    

    /**
     * 
     * @param text teksti // TODO
     * @param luku luku // TODO
     */
    public static void naytaTulos(TextField text, double luku) {
        String tulos = String.format("%5.2f", luku);
        tulos = tulos.replace(',', '.');
        text.setText(tulos);
    }
    
     /**
     * Laskee huoneen tiedot kenttiin
     */
    protected void laske() {
     double pituus, leveys, korkeus, pinta_ala, tilavuus;
     pituus = haeLuku(textPituus,4.0);
     leveys = haeLuku(textLeveys, 3.0);
     korkeus = haeLuku(textKorkeus, 2.5);
     pinta_ala = laskePintaAla(pituus, leveys);
     tilavuus = laskeTilavuus(pinta_ala, korkeus);
     naytaTulos(textPintaAla, pinta_ala);
     naytaTulos(textTilavuus, tilavuus);
     // textPintaala.setText(muotoilePintaAla("Huoneen", pinta_ala));
     // textTilavuus.setText(muotoileTilavuus("Huoneen", tilavuus));   
     }

    
    /**
     * lasketaan huoneen pinta-ala
    * @param pituus huoneen pituus
    * @param leveys huoneen leveys
    * @return huoneen pinta-ala
    */
    public static double laskePintaAla(double pituus, double leveys) {
        return pituus * leveys;
    }
   
    /**
     * lasketaan huoneen tilavuus
     * @param pa pinta-ala
     * @param korkeus huoneen korkeus
     * @return huoneen tilavuus
     * @example
     * <pre name="test">
     * laskeTilavuus(6,2.5) ~~~ 15.0;
     * laskeTilavuus(6,0.0) ~~~ 0.0;
     * </pre>
     */
    public static double laskeTilavuus(double pa, double korkeus) {
        return pa * korkeus;
    }

    /**
     * 
     * Lasketaan arvot parametrien avulla
     * @param parameters kutsuparametrit
     */
    public void laske(Parameters parameters) {
        List<String> params = parameters.getRaw();
        if ( params.size() == 0) return;
        if ( params.size() >= 1) textPituus.setText(params.get(0));
        if ( params.size() >= 2) textLeveys.setText(params.get(1));
        if ( params.size() >= 3) textKorkeus.setText(params.get(2));
        laske();
    }


    

}