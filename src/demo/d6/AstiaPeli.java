package demo.d6;
import demo.d5.Astia;
import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;


/**
 * Tuodaan Astia-luokan metodeja AstiaPeliin
 * @author meikk
 * @version 18.10.2021
 *
 */
public class AstiaPeli {
    
    // #import demo.d5.Astia;
    // #import fi.jyu.mit.ohj2.Suuntaaja;
    
    private static final int MAXLKM = 10;
    
    /** Taulukko astioista */
    private Astia astiat[] = new Astia[MAXLKM];
    private int lkm = 0;
    
    
    /**
     * astiapelin alustus. Ämpäri aina mukaan.
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.etsi("ä").getTilavuus()~~~100.0;
     * </pre>
     */
    public AstiaPeli() {  
        lisaaAstia("ä", 100);
        getAmpari().tayta();
    }
    
    
    /** 
     * Palauttaa ämpärin
     * @return viite ämpäriin
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.getAmpari().getTilavuus() ~~~ 100.0;
     * </pre>
     */
    public final Astia getAmpari() {
        return astiat[0];
    }
    
    /**
     * Palautetaan astioiden lukumäärä pelissä
     * @return astioiden lukumäärä
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.getLkm() === 1;
     * </pre>
     */
    public int getLkm() {
        return lkm;
    }
    
    
    /**
     * Lisätään uusi astia peliin. Luodaan tätä varten uusi astia.
     * @param nimi lisättävän astian nimi
     * @param tilavuus lisättävän astian tilavuus
     * @return lisätty astia tai null, jos ei mahdu
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.getLkm() === 1;
     * peli.lisaaAstia("5", 5);
     * peli.getLkm() === 2;
     * peli.lisaaAstia("8",8);
     * peli.getLkm() === 3;
     * </pre>
     */
    public final Astia lisaaAstia(String nimi, double tilavuus) {
        if (lkm >= MAXLKM) return null;
        Astia astia = new Astia(nimi, tilavuus);
        astiat[lkm] = astia;
        lkm++;
        return astia;
    }
    
    
    /**
     * Palautetaan i:s astia joukosta
     * @param i monesko astia
     * @return i:s astia
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.anna(0).getNimi() === "ä";
     * peli.lisaaAstia("5",5);
     * peli.anna(1).getNimi() === "5"; 
     * </pre>
     */
    public Astia anna(int i) {
        return astiat[i];
    }
    
    
    /**
     * Etsii astian annetulla nimellä
     * @param nimi etsittävän astian nimi
     * @return astian viite tai null jos ei löydy
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli(); peli.lisaaAstia("5",5); peli.lisaaAstia("8",8);
     * peli.etsi("ä").oletko("ä") === true;
     * peli.etsi("Ä").oletko("ä") === true;
     * peli.etsi("5").getTilavuus() ~~~ 5.0;
     * peli.etsi("8").getTilavuus() ~~~ 8.0;
     * peli.etsi("9") === null;
     * </pre>
     */
    public Astia etsi(String nimi) {
        for (int i = 0; i < lkm; i++)
            if (anna(i).oletko(nimi)) return anna(i);
        return null;
    }
    
    /**
     * Tulostaa ohjeet astioiden nimistä
     * @param mista mistä yritettiin kaataa
     * @param mihin mihin yritettiin kaataa
     * @example
     * <pre name="test">
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * AstiaPeli peli = new AstiaPeli(); peli.lisaaAstia("5",5); peli.lisaaAstia("8",8);
     * peli.nimiOhje("4", "6");
     * String tulos = "Nimeä ei tunneta: 4 tai 6\n" +
     *                 "Tunnetaan nimet: \n" +
     *                 "ä 5 8 \n";
     * so.ero(tulos) === null;
     * peli.nimiOhje("?", "6");
     *         tulos = "Tunnetaan nimet: \nä 5 8 \n";
     * so.ero(tulos) === null;
     * so.palauta();                
     * </pre>
     */
    public void nimiOhje(String mista, String mihin) {
        if (!"?".equals(mista))
            System.out.println("Nimeä ei tunneta: " + mista + " tai " + mihin);
        System.out.println("Tunnetaan nimet: ");
        for (int i = 0; i <lkm; i++) 
            System.out.print(anna(i).getNimi() + " ");
        System.out.println("");
      
    }
    
    /**
     * Tulostetaan pelin ohje
     * 
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  AstiaPeli peli = new AstiaPeli(); peli.lisaaAstia("5",5); peli.lisaaAstia("8",8);
     *  peli.tulostaOhje();
     *  so.ero("Käytössäsi on 5.0 sekä 8.0 litran astiat ja Ämpäri (100.0 l)\n") === null;
     *  so.palauta(); 
     * </pre>
     * 
     */
    public void tulostaOhje() {
        if (lkm <= 0)return;
        String ja = "";
        System.out.println("Käytössäsi on: ");
        for (int i = 1; i <lkm; i++) {
            System.out.print(ja + anna(i).getTilavuus());
            ja = " sekä";
        }
        System.out.println(" litran astiat ja Ämpäri (" + 
                getAmpari().getTilavuus() + " l)");
       
    }
    
    
    /**
     * Tulostetaan astioissa olevat nestemäärät
     * @example
     * <pre name="test">
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * String tulos = 
     * "5.0 litran astiassa on 5.0 litraa  nestettä\n" +
     * "8.0 litran astiassa on 3.0 litraa nestettä\n";
     * 
     * AstiaPeli peli = new AstiaPeli();
     * Astia ampari = peli.getAmpari();
     * Astia a5 = peli.lisaaAstia("5",5);
     * Astia a8 = peli.lisaaAstia("8",8);
     * ampari.kaada(a8);
     * a8.kaada(a5);
     * peli.tulostaMaarat();
     * 
     * so.ero(tulos) === null;
     * so.palauta();
     * </pre>
     * 
     */
    public void tulostaMaarat() {
        for (int i = 1; i <lkm; i++) {
            System.out.println(anna(i).getTilavuus() + " litran astiassa on " +
                    anna(i).getMaara() + " litraa nestettä");
        }
    }
    /**
     * Käynnistetään peli. Peli loppuu kun käyttäjä syöttää tyhjän rivin.
     * @example
     * <pre name="test">
     * Suuntaaja.StringInput si = new Suuntaaja.StringInput("");
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * si.input("ä 8\n8 5\n4 5\n\n");
     * String tulos = 
     * "Käytössäsi on 5.0 sekä 8.0 litran astiat ja Ämpari (100.0 l)\n"+
     * "5.0 litran astiassa on 0.0 litraa nestettä\n" +
     * "8.0 litran astiassa on 0.0 litraa nestettä\n" +
     * "Mistä kaadetaan ja mihin >"                   +  
     * "5.0 litran astiassa on 0.0 litraa nestettä\n" +
     * "8.0 litran astiassa on 8.0 litraa nestettä\n" +
     * "Mistä kaadetaan ja mihin >"                   +
     * "5.0 litran astiassa on 5.0 litraa nestettä\n" +
     * "8.0 litran astiassa on 3.0 litraa nestettä\n" +
     * "Mistä kaadetaan ja mihin >"                   +
     * "Nimeä ei tunneta: 4 tai 5\n"                  +
     * "Tunnetaan nimet: \n"                          +
     * "ä 5 8 \n"                                     +
     * "5.0 litran astiassa on 5.0 litraa nestettä\n" +
     * "8.0 litran astiassa on 3.0 litraa nestettä\n" +
     * "Mistä kaadetaan ja mihin >";
     * 
     * AstiaPeli peli = new AstiaPeli();
     *   peli.lisaaAstia("5",5);
     *   peli.lisaaAstia("8",8);
     *   peli.tulostaOhje();
     *   peli.pelaa();
     * 
     * so.ero(tulos) === null;
     * si.palauta(); so.palauta();
     * </pre>
     */
    public void pelaa() {
        
        while(true) {
           tulostaMaarat();
           
           String rivi = Syotto.kysy("Mistä kaadetaan ja mihin");
           if ( rivi.length() == 0) break;
           StringBuilder sb = new StringBuilder(rivi);
           String smista = Mjonot.erota(sb);
           String smihin = Mjonot.erota(sb);
           Astia mista = etsi(smista);
           Astia mihin = etsi(smihin);

           if ( (mista == null) || (mihin == null) )
               nimiOhje(smista, smihin);
           else mista.kaada(mihin);
        }
           
    }
    
    
    /**
     * AstiaPelin pääohjelma
     * @param args ei käytössä
     */
    public static void main(String args[]) {
        AstiaPeli peli = new AstiaPeli();
        
        peli.lisaaAstia("5",5);
        peli.lisaaAstia("8",8);
        peli.tulostaOhje();
        peli.pelaa();
      }
}
