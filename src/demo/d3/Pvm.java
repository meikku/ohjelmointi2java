package demo.d3;


/**
 * @author meikkupyrhonen
 * @version 25.9.2021
 *
 */
public class Pvm {

    // BYCODEBEGIN
    /**
    * @param args ei käytössä
    */
    public static void main(String[] args) {
        Pvm p1 = new Pvm(21, 1, 2015);
        Pvm p2 = new Pvm(12, 12, 2012);
        Pvm p3 = new Pvm(19, 8, 1990);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    private int pp = 0, kk = 0, vv = 0;

    /**
     * @param pp = päivä
     * @param kk = kuukausi
     * @param vv = vuosi
     */
    public Pvm(int pp, int kk, int vv) {
        this.pp = pp;
        this.kk = kk;
        this.vv = vv;
    }
    /**
     * @return aika merkkijonona muodossa 12:05
     * @example
     * <pre name="test">
     * new Pvm(1,1,1900).toString() === "1.1.1900";
     * new Pvm(25,9,2021).toString() === "25.9.2021";
     * </pre>
     */
    @Override
    public String toString() {
        return String.format(pp + "." + kk + "." + vv);
    }




    // TODO: kirjoita ainakin muodostaja ja toString-metodi

    // BYCODEEND
}
