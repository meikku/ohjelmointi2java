/**
 * 
 */
package demo.d7;

/**
 * @author meikk
 * @version 23.10.2021
 *
 */
public class Postimaksu {

    /**
     * Testataan suurinKirjeenPaino-metodia
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println(suurinKirjeenPaino(5.00)); // 500
        System.out.println(suurinKirjeenPaino(7.00)); // 1000  
        System.out.println(suurinKirjeenPaino(1.40)); // 100
    }


    /**
     * Kuinka painava kirje saadaan lähettää annettua maksua vastaan
     * @param maksu paljonko maksetaan kirjeen lähettämisestä
     * @return paljonko kirje saa painaa
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
  
     *  
     *  suurinKirjeenPaino(20.00) === 2000;
     *  suurinKirjeenPaino(10.00) === 2000;
     *  suurinKirjeenPaino(9.99) === 1000;
     *  suurinKirjeenPaino(6.00) === 1000;
     *  suurinKirjeenPaino(5.99) === 500;
     *  suurinKirjeenPaino(2.00) === 250;
     *  suurinKirjeenPaino(-1.00) === 0;
     *  
     *      $maksu  | $paino
     * ---------------------------------------
     *      10.00  | 2000
     *      6.00   | 1000
     *      4.00   | 500
     *      2.00   | 250
     *      1.40   | 100
     *      1.00   | 50
     *             |  0
     * </pre>
     */
    public static int suurinKirjeenPaino(double maksu) {
        double[] hinnat = { 10.00, 6.00, 4.00, 2.00, 1.40, 1.00 };
        int[] paino = { 2000, 1000, 500, 250, 100, 50 };
        
        for (int i = 0; i < hinnat.length; i++) {
            if (maksu >= hinnat[i]) return paino[i];
        }
        
        
        return 0;
        
    }
    
}   
    
// suurinKirjeenPaino if:eillä tehtynä
//
//        if (maksu >= 10.00)  return 2000;
//        if (maksu >= 6.00)   return 1000;
//        if (maksu >= 4.00)   return 500;
//        if (maksu >= 2.00)   return 250;
//        if (maksu >= 1.40)   return 100;
//        if (maksu >= 1.00)   return 50; 
//        return 0;
//    }

