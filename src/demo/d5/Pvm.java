package demo.d5;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Alustava luokka päivämäärää varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 09.02.2008
 */
public class Pvm {
    private int pv, kk, vv;


    /**
     * Palauttaa tämänhetkisen päiväyksen.
     * TODO: muutettava toimimaan oikein.
     */
    public void paivays() {
        pv = 30;
        kk = 1;
        vv = 2012;
    }


    /**
     * Alustetaan päivämäärä. 0-arvot eivät muuta vastaavaa attribuuttia
     * TODO: oikeellisuustarkitukset
     * @param ipv päivän alustus
     * @param ikk kuukauden alustus
     * @param iivv vuoden alustus
     */
    public final void alusta(final int ipv, final int ikk, final int iivv) {
        if (ipv > 0)        this.pv = ipv;
        if (ikk > 0)        this.kk = ikk;
        if (iivv > 0)        this.vv = iivv;
        if (this.vv < 50)  this.vv += 2000;
        if (this.vv < 100) this.vv += 1900;
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
     * Palautetaan päiväys merkkijonona
     * @return päiväys merkkijonoja
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(10,2,2008);
     * pvm.toString() === "10.2.2008";
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Alustetaan päivän arvon merkkijonosta
     * @param s jono josta pvm otetaan
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm();
     * pvm.parse("11.05.02");  pvm.toString() === "11.5.2002";
     * pvm.parse("11.05.97");  pvm.toString() === "11.5.1997";
     * pvm.parse("17.3");      pvm.toString() === "17.3.1997";
     * pvm.parse("19");        pvm.toString() === "19.3.1997";
     * </pre>
     */
    public void parse(String s) {
        StringBuffer sb = new StringBuffer(s);
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, '.', 0);
        alusta(p, k, v);
    }

    // BYCODEBEGIN
    /**
     * @return paiva
     * @example
     * <pre name="test">
     * Pvm maalis97 = new Pvm(1, 3, 97);
     * maalis97.getPaiva() === 1;
     * </pre>
     */
    public int getPaiva() {
        return this.pv;
    }
    /**
     * @return kuukausi
     * Pvm maalis97 = new Pvm(1, 3, 97);
     * maalis97.getKuukausi === 3;
     * 
     */
    public int getKuukausi() {
        return this.kk;
    }
    /**
     * @return vuosi
     * Pvm maalis97 = new Pvm(1, 3, 97);
     * maalis97.getVuosi === 97;
     */
    public int getYear() {
        return this.vv;
    }
   
    /**
     * Testataan päivämääräluokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pvm tammi2008 = new Pvm(1, 1);
        Pvm maalis97 = new Pvm(1, 3, 97);
        Pvm tanaan = new Pvm();

        System.out.println(tammi2008 + " " + maalis97 + " " + tanaan);

        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");     System.out.println(pvm);
        pvm.parse("15.3");          System.out.println(pvm);
        pvm.parse("14");            System.out.println(pvm);
    }

    // BYCODEEND
}


