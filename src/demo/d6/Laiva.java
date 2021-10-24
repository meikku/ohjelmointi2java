package demo.d6;

/**
 * Laiva-luokka joka perii Kulkuneuvon
 * @author meikk
 * @version 16.10.2021
 *
 */
public class Laiva extends Kulkuneuvo{
    
    private int purjeita;

    /**
     * Muodostaja laivalle
     * @param nopeus laivan nopeus
     * @param matkustajia matkustajien määrä
     * @param purjeita purjeiden määrä
     * @example
     */
    public Laiva(int nopeus, int matkustajia, int purjeita) {
        super(nopeus, matkustajia);
        this.purjeita = purjeita;
    }
    
    /**
     * Selvitetään onko purjelaiva
     * @return kerrotaan onko purjelaiva vai ei
     * @example
     * <pre name="test">
     * Laiva moottoriVene = new Laiva(50, 4, 0);
     * moottoriVene.getPurjeet() === "Eipä ole purjelaiva!";
     * </pre>
     */
    public String getPurjeet() {
        if (this.purjeita <= 0) return "Eipä ole purjelaiva!";
        return "Laivassa on purjeita " + this.purjeita + ".";
    }
    
 
    public static void main(String[] args) {

        Laiva purjeLaiva = new Laiva(30, 3, 3);
        purjeLaiva.toString();
        purjeLaiva.getPurjeet();
    }

}
