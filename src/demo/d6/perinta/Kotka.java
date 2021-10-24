package demo.d6.perinta;


/**
 * Kotka joka laajentaa eläimen ominaisuudet
 * @author meikk
 * @version 16.10.2021
 * @example
 * <pre name="test">
 *  Kotka martti = new Kotka("Martti", 800);
 *  martti.toString() === "Martti 800.0";
 * </pre>
 *
 */
public class Kotka extends Elain {

    /**
     * Alustetaan kotkan tiedot
     * @param nimi kotkan nimi
     * @param paino kotkan paino
     */
    public Kotka(String nimi, double paino) {
        super(nimi, paino);
    }
    

    /**
     * Kotkan ääntely
     */
    @Override
    public void aantele() {
        System.out.println("kriiiiiiiiii");
    }


    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kotka martti = new Kotka("Martti", 18000);
        martti.aantele();
        System.out.println(martti);

        Kotka irma = new Kotka("Irma", 930);
        irma.aantele();
        System.out.println(irma);
    }

}
