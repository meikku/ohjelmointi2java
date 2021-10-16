package demo.d5;

/**
 * @author meikkupyrhonen
 * @version 10.10.2021
 *
 */
public class Tietokone {

    private int muisti;
    private int kovalevynKoko;
    private double hinta;
    private String merkki;
    private String tyyppi;

    /**
     * muodostaja, jolle annetaan kaikki tiedot parametreina
     * @param muisti tietokoneen muisti GB
     * @param kovalevynKoko kovalevyn koko GB
     * @param hinta paljonko maksaa
     * @param merkki minkä merkkinen kone
     * @param tyyppi pöytäkone, kannettava vai joku muu?
     */
    public Tietokone(int muisti, int kovalevynKoko, double hinta, String merkki,
            String tyyppi) {
        this.muisti = muisti;
        this.kovalevynKoko = kovalevynKoko;
        this.hinta = hinta;
        this.merkki = merkki;
        this.tyyppi = tyyppi;
    }


    /**
     * muodostaja jolle annetaan parametrina muisti, kovalevyn koko ja vga-liitänt
     * @param muisti muistin määrä
     * @param kovalevynKoko kovalevyn koko
     */
    public Tietokone(int muisti, int kovalevynKoko) {
        this.muisti = muisti;
        this.kovalevynKoko = kovalevynKoko;
        this.hinta = 0;
        this.merkki = "";
        this.tyyppi = "";
    }


    /**
     * muodostaja ilman annettuja parametreja
     */
    public Tietokone() {
        this.muisti = 0;
        this.kovalevynKoko = 0;
        this.hinta = 0;
        this.merkki = "";
        this.tyyppi = "";
    }


    /**
     * @return muistin määrä 
     * @example
     * <pre name="test">
     * Tietokone macbookAir = new Tietokone(8, 256);
     * macbookAir.getMuisti() === 8;
     * </pre>
     */
    public int getMuisti() {
        return this.muisti;
    }


    /**
     * Palautetaan tietokoneen tyyppi (pöytäkone, kannettava...)
     * @return tietokoneen tyyppi
     * <pre name="test">
     * Tietokone macbookAir = new Tietokone();
     * macbookAir.getTyyppi() === "";
     * </pre>
     */
    public String getTyyppi() {
        return this.tyyppi;
    }


    @Override
    public String toString() {
        return "Muistia on " + muisti + " MB, kovalevyn koko on "
                + kovalevynKoko + " GB, tietokone maksaa " + hinta + "€. Se on "
                + merkki + "-merkkiä. Tietokone on tyyppiä " + tyyppi + ".";
    }


    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Tietokone macbookAir = new Tietokone(8, 256);
        System.out.println(macbookAir.toString());
        Tietokone asus = new Tietokone(32, 1024, 2299, "Asus ExpertCenter",
                "pöytätietokone");
        System.out.println(asus.toString());
        // TODO Auto-generated method stub

    }

}
