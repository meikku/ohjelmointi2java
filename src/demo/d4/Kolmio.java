package demo.d4;

/**
 * @author meikkupyrhonen
 * @version 3.10.2021
 * Lasketaan kolmion pinta-ala ja hypotenuusan pituus
 *
 */
public class Kolmio {

    /**
    * @param kateetti1 kateetin pituus
     * @param kateetti2 toisen kateetin pituus
     * @return kolmion pinta-ala
     * @example
    * <pre name="test">
    * kolmionAla(3,4) ~~ 6,0;
    * kolmionAla(0,9) ~~ 0,0;
    * kolmionAla(5,6) ~~ 15,0;
    * </pre>
    */
    public static double kolmionAla(int kateetti1, int kateetti2){
        double ala = (kateetti1 * kateetti2)/2;
        return Math.round(ala);
    }


    /**
    * @param kateetti1 kateetin pituus
     * @param kateetti2 toisen kateetin pituus
     * @return hypotenuusan pituus
     * @example
    * <pre name="test">
    * hypotenuusa(1,3) ~~~ 3,16;
    * hypotenuusa(0,8) ~~~0,0;
    * hypotenuusa(10,5) ~~~11,18;
    * </pre>
    */
    public static double hypotenuusa(int kateetti1, int kateetti2){
        double tulos = Math.sqrt(kateetti1*kateetti1 + kateetti2*kateetti2);
        return Math.round(tulos);
    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
    }
}