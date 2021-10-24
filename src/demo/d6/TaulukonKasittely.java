package demo.d6;

/**
 * @author meikk
 * @version 17.10.2021
 *
 */
public class TaulukonKasittely {

    
    
    /**
     * Etsitään taulukosta pienin luku
     * @param i indeksi josta pienin luku löytyy
     * @param t taulukko josta etsitään
     * @return pienin luku
     * @example
     * <pre name="test">
     *  int kPituudet[] =  {31,28,31,30,31,30,31,31,30,31,30,31};
     *  pienin(1, kPituudet) === 28;
     * </pre>
     *
     */
    public static int pienin(int i, int[] t) {
        int pienin = t[i];
        return pienin;
    }
    
    /**
     * Palauttaa indeksin jossa pienin luku sijaitsee
     * @param t taulukko josta etsitään pienintä
     * @return indeksi
     *  @example
     * <pre name="test">
     *  int kPituudet[] =  {31,28,31,30,31,30,31,31,30,31,30,31};
     *  pienimmanPaikka(kPituudet) === 1;
     * </pre>
     *
     */
    public static int pienimmanPaikka(int[] t) {
        int pienin = 9999;
        int minIndex = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] < pienin) {
                minIndex = i;
                pienin = t[i];
            }
        }
        return minIndex;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        /* ta,he,ma,hu,to,ke,he,el,sy,lo,ma,jo */
        int kPituudet[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int index = pienimmanPaikka(kPituudet);
        int pienin = pienin(index, kPituudet);
        System.out.println("Pienin luku " + pienin + " löytyy indeksistä " + index + ".");
    }

}
