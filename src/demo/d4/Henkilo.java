package demo.d4;

/**
 * @author meikkupyrhonen
 * @version 3.10.2021
 * @example
 * <pre name="test">
 *  Henkilo maija = new Henkilo("Maija", "Mehiläinen", 2021);
 *  maija.toString() === "Maija|Mehiläinen|2021";
 *  maija.getNimi() === "Maija Mehiläinen";
 *  maija.getSyntymavuosi() === 2021;
 * </pre>
 */
public class Henkilo {
    private String etuNimi;
    private String sukuNimi;
    private int syntymaVuosi;

    /**
     * @param etuNimi etunimi
     * @param sukuNimi sukunimi
     * @param syntymaVuosi syntymavuosi
     */
    public Henkilo(String etuNimi, String sukuNimi, int syntymaVuosi) {
        this.etuNimi = etuNimi;
        this.sukuNimi = sukuNimi;
        this.syntymaVuosi = syntymaVuosi;
    }


    @Override
    public String toString() {
        return etuNimi + "|" + sukuNimi + "|" + syntymaVuosi;
    }


    /**
     * @return etunimi sukunimi
     */
    public String getNimi() {
        return this.etuNimi + " " + this.sukuNimi;
    }


    /**
     * @return syntymavuosi
     */
    public int getSyntymavuosi() {
        return this.syntymaVuosi;
    }
    // TODO: täydennä tarvittavat attribuuttit ja metodit. Muista suojaustasot!


    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(aku.getNimi()); // tulostaa Aku Ankka
        System.out.println(aku.getSyntymavuosi()); // tulostaa 1934
        System.out.println(aku.toString()); // tulostaa Aku|Ankka|1934
    }
}