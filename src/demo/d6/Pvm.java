package demo.d6;


import fi.jyu.mit.ohj2.*;


/**
 * Alustava luokka päivämäärää varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 17.02.2003
 * @version 1.3, 11.02.2008
 */
public class Pvm {

    private int pv;
    private int kk;
    private int vv;


    /**
     *  Muuttaa päivämäärän nykypäivälle.
     *  Todo: pitää vaihtaa hakemaan päivämäärä oikeasti. 
     *  Mutta perinnässäkään ei nyt saa käyttää enempää attribuutteja kuin tässä on
     */
    public void paivays() {
        pv = 13;
        kk = 2;
        vv = 2012;
    }


    /**
     * Alustetaan päivämäärä. 0-arvot eivät muuta vastaavaa attribuuttia  
     * TODO: oikeellisuustarkistukset
     * @param ipv päivän alustus
     * @param ikk kuukauden alustus
     * @param ivv vuoden alustus
     */
    public void alusta(int ipv, int ikk, int ivv) {
        if ( ipv > 0 ) this.pv = ipv;
        if ( ikk > 0 ) this.kk = ikk;
        if ( ivv > 0 ) this.vv = ivv;
        if ( this.vv < 50 ) this.vv += 2000;
        if ( this.vv < 100 ) this.vv += 1900;
    }


    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
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
     * @param kk kuukauden oletusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon
     * @param pv päivän alustusarvo
     * @param kk kuukauden oletusarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        paivays();
        alusta(pv, kk, vv);
    } 


    /**
     * Alustetaan päivämäärä merkkijonosta
     * @param s muotoa 12.3.2008 oleva merkkijono
     */
    public Pvm(String s) {
        paivays();
        pvmParse(s);
    } 
    
    /**
     * Verrataan kumpi annetuista päivämääristä on suurempi
     * @param pv1 ensimmäinen päivämäärä
     * @param pv2 toinen päivämäärä
     * @return palauttaa 1 jos ensimmäinen pvm on suurempi, 0 jos samoja, -1 jos ensimmäinen pvm pienempi
     * @example
     * <pre name="test">
     *  Pvm pv1 = new Pvm(3, 6, 1999);
     *  Pvm pv2 = new Pvm(9, 5, 2021);
     *  Pvm pv3 = new Pvm(9, 4, 2021);
     *  Pvm pv4 = new Pvm(3, 6, 1999);
     *  compareTo(pv1, pv2) === -1;
     *  compareTo(pv2, pv3) === 1;
     *  compareTo(pv1, pv4) === 0;
     * </pre>
     * 
     * 
     */
    public static int compareTo(Pvm pv1, Pvm pv2) {
        if (pv1.getVv() > pv2.getVv()) return 1;
        else if (pv1.getVv() < pv2.getVv()) return -1;
        else if (pv1.getVv() > pv2.getVv()) return 1;
        else if (pv1.getKk() < pv2.getKk()) return -1;
        else if (pv1.getKk() > pv2.getKk()) return 1;
        else if (pv1.getPv() < pv2.getPv()) return -1;   
        else if (pv1.getPv() > pv2.getPv()) return 1;
        return 0;
    }
    
    /**
     * Verrataan onko annettu päivämäärä suurempi kuin olion oma päivämäärä
     * @param pv1 päivämäärä johon verrataan
     * @return -1 jos kutsuva päivämäärä on pienempi, 0 jos sama, 1 jos isompi
     * @example
     * <pre name="test">
     *  Pvm pv1 = new Pvm(3, 6, 1999);
     *  Pvm pv2 = new Pvm(9, 5, 2021);
     *  Pvm pv3 = new Pvm(9, 4, 2021);
     *  Pvm pv4 = new Pvm(3, 6, 1999);
     *  pv1.compareTo(pv2) === -1;
     *  pv2.compareTo(pv3) === 1;
     *  pv1.compareTo(pv4) === 0;
     * </pre>
     */
    public int compareTo(Pvm pv1) {
        if (this.vv > pv1.getVv()) return 1;
        else if (this.vv < pv1.getVv()) return -1;
        else if (this.kk < pv1.getKk()) return -1;
        else if (this.kk > pv1.getKk()) return 1;
        else if (this.pv < pv1.getPv()) return -1;   
        else if (this.pv > pv1.getPv()) return 1;
        return 0;
    }
    
    /**
     * verrataan onko annettu päivämäärä sama kuin olion oma
     * @param pv1 päivämäärä johon verrataan 
     * @return tosi tai epätosi
     * @example
     * <pre name="test">
     *  Pvm pv1 = new Pvm(3, 6, 1999);
     *  Pvm pv2 = new Pvm(9, 5, 2021);
     *  Pvm pv3 = new Pvm(9, 4, 2021);
     *  Pvm pv4 = new Pvm(3, 6, 1999);
     *  pv1.equals(pv2) === false;
     *  pv2.equals(pv3) === false;
     *  pv1.equals(pv4) === true;
     * </pre>
     * 
     */
    public Boolean equals(Pvm pv1) {
        if (this.vv == pv1.vv && this.kk == pv1.kk && this.pv == pv1.pv) {
            return true;
        }
        return false;
    }


    /**
     * Päivämäärä merkkijonona
     * @return päivämäärä muodossa 17.2.2007
     * @example
     * <pre name="test">
     *   Pvm tammi2011 = new Pvm(1,1,2011);
     *   tammi2011.toString() === "1.1.2011"
     *   Pvm helmi2011 = new Pvm(1,2,2011);
     *   helmi2011.toString() === "1.2.2011"
     *   Pvm tanaan = new Pvm(14,2,2011);
     *   tanaan.toString()    === "14.2.2011"
     *   Pvm maalis97 = new Pvm(1,3,1997);
     *   maalis97.toString()  === "1.3.1997"
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param sb tutkittava merkkijono
     */
    protected final void pvmParse(StringBuilder sb) {
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, ' ', 0);
        alusta(p, k, v);
        // tai alusta(Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0));
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param s tutkittava merkkijono
     */
    protected final void pvmParse(String s) {
        pvmParse(new StringBuilder(s));
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param s tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * pvm.parse("12");           pvm.toString() === "12.3.2003";
     * pvm.parse("..2001");       pvm.toString() === "12.3.2001";
     * pvm.parse("..2009 14:30"); pvm.toString() === "12.3.2009"; 
     * </pre>
     */
    public void parse(String s) {
        pvmParse(s);
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * Merkkijonosta otetaan pois vain se osa, jota tarvitaan.
     * @param sb tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * StringBuilder jono = new StringBuilder("12");
     * pvm.parse(jono); pvm.toString() === "12.3.2003"; jono.toString() === "";
     * jono = new StringBuilder("..2001");
     * pvm.parse(jono); pvm.toString() === "12.3.2001"; jono.toString() === "";
     * jono = new StringBuilder("..2009 14:30");
     * pvm.parse(jono); pvm.toString() === "12.3.2009"; jono.toString() === "14:30";
     * </pre>
     */
    public void parse(StringBuilder sb) {
        pvmParse(sb);
    }


    // Lisätty saantimetodit:

    /**
     * @return päivän arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getPv() === 14;
     * </pre>
     */
    public int getPv() {
        return pv;
    }


    /**
     * @return kuukauden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getKk() === 2;
     * </pre>
     */
    public int getKk() {
        return kk;
    }


    /**
     * @return vuoden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("14.2.2011");
     *   pv.getVv() === 2011;
     * </pre>
     */
    public int getVv() {
        return vv;
    }


    /**
     * Testataan päivämäärä-luokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");
        System.out.println(pvm);
        pvm.parse("15.3");
        System.out.println(pvm);
        pvm.parse("14");
        System.out.println(pvm.getPv());

    }
}