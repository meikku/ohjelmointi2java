package demo.d6;

/**
 * Lentokone-luokka joka perii Kulkuneuvon
 * @author meikk
 * @version 16.10.2021
 *
 */
public class Lentokone extends Kulkuneuvo {
    
    private int lentoKorkeus;
    /**
     * @param nopeus lentokoneen nopeus
     * @param matkustajia matkustajien määrä
     * @param lentoKorkeus koneen tyypillinen lentokorkeus
     * @example
     * <pre name="test">
     *  Lentokone boeing = new Lentokone(300, 200, 9000);
     *  boeing.getLentoKorkeus() === 9000;
     *  boeing.toString() === "Kulkuneuvon nopeus on 300 km/h ja kyydissä on 200 matkustajaa.";
     * </pre>
     */
    public Lentokone(int nopeus, int matkustajia, int lentoKorkeus) {
        super(nopeus, matkustajia);
        this.lentoKorkeus = lentoKorkeus;
    }
    
    /**
     * Selvitetään mikä on koneen lentokorkeus
     * @return koneen lentokorkeus
     */
    public int getLentoKorkeus() {
        return lentoKorkeus;
    }
    public static void main(String[] args) {
        Lentokone vesiTaso = new Lentokone(70, 4, 400);
        System.out.println(vesiTaso.toString());
        System.out.println(vesiTaso.getLentoKorkeus());
    }
}
