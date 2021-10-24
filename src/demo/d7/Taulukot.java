package demo.d7;

/**
 * @author meikk
 * @version 24.10.2021
 *
 */
public class Taulukot {
    /**
    * @param args ei käytössä
    */
    public static void main(String[] args) {
        // pääohjelma jossa kutsut aliohjelmia
    }


    /**
    * Palauttaa taulukon suurimman luvun
    * @param pisteet taulukko josta etsitään
    * @return taulukon suurin luku
    * @example
    * <pre name="test">
    * double[] pisteet = { 19,18,19.5,18,20 };
    * paras(pisteet) ~~~ 20.0;
    * </pre>
    */
    public static double paras(double[] pisteet) {
        double paras = 0;
        for (int i = 0; i < pisteet.length; i++) {
            if (pisteet[i] > paras)
                paras = pisteet[i];
        }
        return paras;
    }


    /**
    * Etsii taulukon pienimmän arvon
    * @param pisteet taulukko josta etsitään pienintä
    * @return taulukon pienin arvo
    * @example
    * <pre name="test">
    * double[] pisteet = { 19,18,19.5,18,20 };
    * huonoin(pisteet) ~~~ 18.0;
    * </pre>
    */
    public static double huonoin(double[] pisteet) {
        double alin = 20.0;
        for (int i = 0; i < pisteet.length; i++) {
            if (pisteet[i] < alin)
                alin = pisteet[i];
        }
        return alin;
    }


    /**
    * Laskee taulukon lukujen summan
    * @param pisteet taulukko jonka summa lasketaan
    * @return taulukon lukujen summa
    * @example
    * <pre name="test">
    * double[] pisteet = { 19,18,19.5,18,20 };
    * summa(pisteet) ~~~ 94.5;
    * </pre>
    */
    public static double summa(double[] pisteet) {
        double summa = 0;
        for (int i = 0; i < pisteet.length; i++) {
            summa += pisteet[i];
        }
        return summa;
    }


    /**
    * Laskee summan taulukon luvuista, joista paras ja huonoin arvo on jätetty pois
    * @param pisteet taulukko jonka summaa lasketaan
    * @return taulukon (josta paras ja huonoin arvo poistettu) lukujen summa
    * @example
    * <pre name="test">
    * double[] pisteet = { 19,18,19.5,18,20 };
    * summaHuonoinJaParasPois(pisteet) ~~~  56.5;
    * </pre>
    */
    public static double summaHuonoinJaParasPois(double[] pisteet) {
        double summa = summa(pisteet);
        double paras = paras(pisteet);
        double huonoin = huonoin(pisteet);
        return summa - paras - huonoin;
    }
}