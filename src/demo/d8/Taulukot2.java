package demo.d8;

import demo.d7.Taulukot;

/**
 * @author meikk
 * @version 31.10.2021
 *
 */
public class Taulukot2 {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double[][] tulokset = { { 56.78, 109.98, 77.66 }, { -1.1, -88.91, 56.71 } };
        System.out.println(summa(tulokset));
    }

    /**
     * Lasketaan summa kaksiulotteisen taulukon reaaliluvuista
     * @param matriisi kaksiulotteinen taulukko
     * @return taulukon lukujen summa
     * @example
     * <pre name="test">
     *  double[][] taulu1 = { { 1.1, 1.2, 1.3 }, { -1.1, -1.2, -1.3 } };
     *  double[][] taulu2 = { { 0.1, 0.2, 0.7, 0.8, 0.9 }, { 100.5, 200.5, 300.5 } };
     *  double[][] taulu3 = { { 4.5, 6.7, 8.9 }, { 10.11, 12.13, 14.15 } };
     *  summa(taulu1) ~~~ 0;
     *  summa(taulu2) ~~~ 604.2;
     *  summa(taulu3) ~~~ 56.49;
     * </pre>
     */
    public static double summa(double[][] matriisi) {
        double summa = 0;
        for (int i = 0; i < matriisi.length; i++) {
            summa +=Taulukot.summa(matriisi[i]);
        }
        return summa;
    }

}
