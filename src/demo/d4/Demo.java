/**
 * 
 */
package demo.d4;

/**
 * @author meikkupyrhonen
 * @version 4.10.2021
 *
 */
public class Demo {

    /**
     * Lasketaan demohyvitys
    * @param pisteet palautettujen tehtävien pisteet 
    * @param maksimi tehtävistä saatava maksimipistemäärä
     * @return hyvityspisteet
     * @example
    * <pre name="test">
    *  demohyvitys(1, 60) === 0;
    *  demohyvitys(50, 60) === 5;
    *  demohyvitys(66, 60) === 6;
    *  demohyvitys(60, 1) === 0;
    *  demohyvitys(44, 60) === 4;
    * </pre>
    */
    public static int demohyvitys(double pisteet, double maksimi) {
            double prosentti = pisteet / maksimi;
            if (prosentti >=0.9) return 6;
            if (prosentti >=0.8) return 5;
            if (prosentti >=0.7) return 4;
            if (prosentti >=0.6) return 3;
            if (prosentti >=0.5) return 2;
            if (prosentti >=0.4) return 1;
            return 0;
    }


    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println(demohyvitys(29.7, 60));
    }

}
