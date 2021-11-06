package demo.d8;

import java.util.Calendar;


/**
 * Päiväys koneesta
 * @author meikk
 * @version 1.11.2021
 *
 */
public class Pvm extends demo.d6.Pvm {
    // #import java.util.Calendar;

    /**
     * Otetaan päiväys koneen kalenterista
     */
    @Override
    public void paivays() {
        
        Calendar nyt = Calendar.getInstance(); 
        alusta(nyt.get(Calendar.DATE),
                nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1,
                nyt.get(Calendar.YEAR));

    }
    /**
     * Alustetaan kaikki attribuutit oletusarvoon
     */
    public Pvm() {
        this(0,0,0);
    }
    
    
    /**
     * Alustetaan kuukausi ja vuosi oletusarvoon
     * @param pv päivän alustusarvo
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
    }
    
    
    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv päivän alustusarvo
     * @param kk kuukauden alustusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }
    
    
    
    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv päivän alustusarvo
     * @param kk kuukauden alustussarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        super(pv, kk, vv);
    }
    
    




    /**
     * Alustetaan päivämäärä merkkijonosta
     * @param s muotoa 12.3.2008 oleva merkkijono
     * @example
     * <pre name="test">
     *   Calendar nyt = Calendar.getInstance();
     *   int pv = nyt.get(Calendar.DATE);
     *   int kk = nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1;
     *   int vv = nyt.get(Calendar.YEAR);
     *   Pvm pvm;
     *
     *   pvm = new Pvm($alustus); pvm.toString() === $toString;
     *
     *   | $alustus  |   $toString
     * -----------------------------------------------
     *   | 1, 1      |  "1.1."+vv
     *   | 1         |  1+"."+kk+"."+vv
     *   |           |  pv+"."+kk+"."+vv
     *   | 1, 3, 97  |  "1.3.1997"
     *   | "1.5"     |  "1.5."+vv
     *   | "1..1990" |  "1."+kk+".1990"
     *   | "..1990"  |  pv+"."+kk+".1990"
     * </pre>
     *
     */
    public Pvm(String s) {
        super(s);
    }


    /**
     * Testataan Pvm-luokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pvm marras2021 = new Pvm(1, 1); 
        Pvm maalis97 = new Pvm(1, 3, 97); 
        Pvm tanaan = new Pvm();

        System.out.println(marras2021 + " " + maalis97 + " " + tanaan);

        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");
        System.out.println(pvm);
        pvm.parse("15.2");
        System.out.println(pvm);
        pvm.parse("14");
        System.out.println(pvm);

        Pvm pv1 = new Pvm(1, 2), pv2 = new Pvm(3, 3);
        if ( compareTo(pv1, pv2) < 0 ) System.out.println(pv1 + " < " + pv2);
        if ( pv1.compareTo(pv2) != 0 ) System.out.println(pv1 + " != " + pv2);
    }
}