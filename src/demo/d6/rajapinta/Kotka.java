package demo.d6.rajapinta;

/**
 * Kotka-luokka
 * @author meikk
 * @version 16.10.2021
 * @example
 * <pre name="test">
 *      Kotka martti = new Kotka("Martti", 800);
 *      martti.toString() === "Martti 800.0";
 * </pre>
 *
 */
public class Kotka implements ElainRajapinta{

    private String nimi;
    private double paino;
    
    /**
     * Alustetaan kotkan nimi ja paino
     * @param nimi kotkan nimi
     * @param paino kotkan paino
     */
    public Kotka(String nimi, double paino) {
        this.nimi = nimi;
        this.paino = paino;
    }
    /*
     * Kotka ääntelee
     */
    @Override
    public void aantele() {
        System.out.println("Kriiiii");
    }

    @Override
    public String toString() {
        return nimi + " " + paino;
    }

    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        ElainRajapinta elukat[] = {
                new Koira("Musti", 18005),
                new Kissa("Mirri", 18000),
                new Koira("Pluto", 1930),
                new Kissa("Miuku", 980),
                new Kotka("Kalle", 2400)
        };

        for (int i = 0; i < elukat.length; i++) {
            elukat[i].aantele();
            System.out.println(elukat[i].toString());
        }
    } 
}
