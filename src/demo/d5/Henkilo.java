package demo.d5;

import java.io.*;
import fi.jyu.mit.ohj2.*;

/**Henkilö-luokka. Henkilöllä on nimi ja syntymävuosi.
 * @author meikkupyrhonen
 * @version 7.10.2021
 *
 */
public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;


    /**
     * Alustetaan henkilön tiedot annetuilla arvoilla
     * @param etunimi henkilön uusi etunimi
     * @param sukunimi henkilön uusi sukunimi
     * @param syntymavuosi henkilön uusi syntymävuosi
     */
    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }
    /**
     * Alustetaan henkilo ilman annettuja arvoja
     * @example
     * <pre name="test">
     * Henkilo sipe = new Henkilo();
     * sipe.getNimi() === "";
     * sipe.toString() === "||0";
     * </pre>
     */
    public Henkilo() {
        this.etunimi = "";
        this.sukunimi = "";
        this.syntymavuosi = 0; // tätä ei tarvita? 
    }
    /** Selvitetään henkilön tiedot merkkijonosta 
     * @param mj saapuva merkkijono
     *@example
     * <pre name="test">
     * Henkilo katri = new Henkilo("katri|helena|1923");
     * katri.getNimi() === "katri helena";
     * katri.toString() === "katri|helena|1923";
     * </pre>
     */
    public Henkilo(String mj) {
        parse(mj); // parse(new StringBuilder(mj));
    }
    
    /**
     * @param mj merkkijono josta erotetaan etunimi, sukunimi ja syntymävuosi
     * @example
     * <pre name="test">
     *  Henkilo hlo = new Henkilo();
     *  hlo.parse("Sirkka|Liisa|1967"); hlo.toString() === "Sirkka|Liisa|1967";
     *  hlo.parse("Sirkka||1967");      hlo.toString() === "Sirkka||1967";
     *  hlo.parse("Sirkka|Liisa|");      hlo.toString() === "Sirkka|Liisa|0";
     *  
     * </pre>
     */
    public void parse(String mj) {
        StringBuffer sb = new StringBuffer(mj); 
        this.etunimi = Mjonot.erota(sb, '|'); 
        this.sukunimi = Mjonot.erota(sb, '|');
        this.syntymavuosi = Mjonot.erotaInt(sb, 0);
    }

    /**
     * @return tiedot | erotetussa muodossa
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.toString() === "Aku|Ankka|1934";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.toString() === "Pele||1940";
     * </pre>
     */
    @Override
    public String toString() {
        return etunimi + "|" + sukunimi + "|" + syntymavuosi;
    }


    /**
     * Palautetaan henkilön koko nimi
     * @return henkilön nimi muodossa etunimi sukunimi
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.getNimi() === "Aku Ankka";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.getNimi() === "Pele";
     * </pre>
     */
    public String getNimi() {
        return (etunimi + " " + sukunimi).trim();
    }


    /**
     * @return henkilön syntymävuosi
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.getSyntymavuosi() === 1934;
     * </pre>
     */
    public int getSyntymavuosi() {
        return syntymavuosi;
    }


    /**
     * Tulostetaan henkilön tiedot parametrina tuotuun tietovirtaan
     * @param os tietovirta johon tiedot tulostetaan
     * @example
     * <pre name="test">
     * #import java.io.*;
     * ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
     * Henkilo hlo = new Henkilo("Aku","Ankka",1934);
     * hlo.tulosta(byteoutput);
     * byteoutput.toString() =R= "Aku Ankka 1934\\s*"
     * </pre>
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        out.println(etunimi + " " + sukunimi + " " + syntymavuosi);
    }

    // BYCODEBEGIN
    //Kirjoita loput luokasta tähän
    // BYCODEEND

    /**
     * Testataan henkilöluokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo hlo = new Henkilo();
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(hlo);
        hlo.parse("Sepe|Susi|1933");
        hlo.tulosta(System.out);
        aku.tulosta(System.out);
        Henkilo mikki = new Henkilo("Mikki|Hiiri");
        System.out.println(mikki);
    }
}


