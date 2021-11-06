package demo.d8;

/**
 * @author meikk
 * @version 31.10.2021
 *
 */
public class Taulukot {
    

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        
        //
    }

    /**
     * Etsii kaksiulotteisesta reaalilukumatriisista suurimman arvon
     * @param matriisi kaksiulotteinen taulukko, josta etsitään
     * @return matriisin suurin  reaaliluku
     * @example
     * <pre name="test">
     *  double matriisi1[][] = { {0.9, 5.6, -1.3, -11.2 }, { 9.8, 16.7, -0.2, 88 } };
     *  matriisinSuurin(matriisi1) ~~~ 88;
     *  double matriisi2[][] = { {-100, -1.1, -1.3, -11.2 }, { -9.8, -16.7, -0.2, -88 } };
     *  matriisinSuurin(matriisi2) ~~~ -0.2;
     *  double matriisi3[][] = { {0.0, 1.1, -1.3, -1.2 }, { 0.8, 0.7, -0.2, 0.8 } };
     *  matriisinSuurin(matriisi3) ~~~ 1.1;
     *  double matriisi4[][] = { {900.9, 100.6, -1000.3, -1100.2 }, { 9000.8, 1600.7, -1000.2, 880 } };
     *  matriisinSuurin(matriisi4) ~~~ 9000.8;
     * </pre>
     */
    public static double matriisinSuurin(double[][] matriisi) {
        double suurin = -Double.MAX_VALUE;
        for(int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j <matriisi[i].length; j++) {
                if (matriisi[i][j] > suurin) suurin = matriisi[i][j];
            }
        }
        return suurin;
    }
}
