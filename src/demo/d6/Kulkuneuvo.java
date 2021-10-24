package demo.d6;

/**
 * @author meikk
 * @version 16.10.2021
 *
 */
public class Kulkuneuvo {
    private int nopeus;
    private int matkustajia;
    
    /**
     * alustetaan kulkuneuvon tiedot
     * @param nopeus kulkuneuvon nopeus
     * @param matkustajia montako matkustajaa kyydissä
     * @example
     * <pre name="test">
     *  Kulkuneuvo kanootti = new Kulkuneuvo(15,2);
     *  kanootti.toString() === "Kulkuneuvon nopeus on 15 km/h ja kyydissä on 2 matkustajaa.";
     * </pre>
     */
    public Kulkuneuvo(int nopeus, int matkustajia) {
        this.nopeus = nopeus;
        this.matkustajia = matkustajia;
    }
    
    
    /**
     * Kerrotaan kulkuneuvon nopeus
     * @return kulkuneuvon nopeus
     * @example
     * <pre name="test">
     *  Kulkuneuvo tandem = new Kulkuneuvo(30, 2);
     *  tandem.getNopeus() === 30;
     * </pre>
     */
    public int getNopeus() {
        return this.nopeus;
    }
    
    @Override
    public String toString() {
        return "Kulkuneuvon nopeus on " + nopeus + " km/h ja kyydissä on " + matkustajia + " matkustajaa.";
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kulkuneuvo skootteri = new Kulkuneuvo(35, 1);
        Kulkuneuvo hoyryLaiva = new Kulkuneuvo(40, 70);
        System.out.println(skootteri.getNopeus());
        System.out.println(skootteri);
        System.out.println(hoyryLaiva);
    }

}
