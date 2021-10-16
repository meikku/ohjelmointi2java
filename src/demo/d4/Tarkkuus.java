package demo.d4;

/**
 * @author meikkupyrhonen
 * @version 4.10.2021
 *
 */
public class Tarkkuus {
    
    /**
     * @param x luku
     * @param eps tarkkuus
     * @return onko luku riittävän lähellä
     * @example
     * <pre name="test">
     *  etumerkki(37-36.8, 0.3) === 0; 
     *  etumerkki(37-36.8, 0.1) === 1;
     *  etumerkki(37-36.8, 0.2) === 0;
     *  etumerkki(36.8-37, 0.2) === -1;
     *  </pre>
     */
    public static int etumerkki(double x, double eps) {
        if (x < - eps) return -1;
        else if (-eps <= x && x == eps) return 0;
        else return 1;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
    }

}
