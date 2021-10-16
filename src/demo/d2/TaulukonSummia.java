package demo.d2;

/**
 * Lasketaan yhteen taulukon alkioita
 * @author vesal
 * @version 17.1.2014 
 */
public class TaulukonSummia {

    /**
     * Kokeillaan summa-funktiota
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int[] t = {32, 32, 76, 62, 31, 86};
        int s = summa6(t);
        System.out.println("Lukujen summa = " + s);
        
        s = summaParillisissaPaikoikoissa6(t);
        System.out.println("Lukujen summa parillisissa paikoissa = " + s);
    }

    
    /**
     * Lasketaan parillisissa paikoissa olevien taulukon alkioiden summa
     * @param t taulukko jonka luvut lasketaan (vain 6 paikkainen)
     * @return parillisissa paikoissa olevien lukujen summa
     * @example
     * <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summaParillisissaPaikoikoissa6(t) === 9;
     *   summaParillisissaPaikoikoissa6(new int[]{1,1,1,1,1,1}) === 3;
     * </pre>
     */
    @SuppressWarnings("unused")
    public static int summaParillisissaPaikoikoissa6(int[] t) {
    	int summa = 0;
    	for (int i = 0; i < t.length; i += 2 ) {
    		summa += t[i];
    	}
        // TODO: kopioi tähän Taunon tekemä koodi ilman int[] t = -riviä
        // TODO: korvaa vielä rivin return 0 niin että siinä on sinun apumuuttujasi nimi
        return summa;
    }


    /**
     * Lasketaan yhteen taulukon kaikki luvut
     * @param t taulukko jonka luvut lasketaan (vain 6 paikkainen)
     * @return lukujen summa
     * @example
     * <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summa6(t) === 21;
     *   summa6(new int[]{1,1,1,1,1,1}) === 6;
     * </pre>
     */
    @SuppressWarnings("unused")
    public static int summa6(int[] t) {
    	int sum = 0;
    	for (int i: t) {
    		sum+= i;
    	}
        // TODO: kopioi tähän Taunon tekemä koodi ilman int[] t = -riviä
        // TODO: korvaa vielä rivin return 0 niin että siinä on sinun apumuuttujasi nimi
        return sum;
    }

}