package demo.d2;
    /** 
     * 
     * @author meikkupyrhonen
     * @version 24.9.2021
     *
     */
public class KertomaDoWhile
{   
    /**
     * 
     * @param args = ei käytössä
     * 
     */
    public static void main(String[] args)
    {
    	System.out.printf("Luvun 0 kertoma on: %d\n", kertoma(0));
        System.out.printf("Luvun 5 kertoma on: %d\n", kertoma(5));
        System.out.printf("Luvun 10 kertoma on: %d\n", kertoma(10));
    }

    // BYCODEBEGIN
    /**
     * Aliohjelma, joka laskee luvun kertoman
     * @param n luku, jonka kertoma lasketaan
     * @return kertoma
     * @example
     * <pre name="test">
     *  kertoma(3) === 6;
     *  kertoma(5) === 120;
     *  kertoma(0) === 1;
     * </pre>
     */
    public static int kertoma(int n)
    {
        int i = n;
    	int kertoma = 1;
    	if (i > 0) {
        	do {
        		kertoma = kertoma * i;
    			i = i - 1; 
        	}
    		while (i >= 1); 
    	}
    	return kertoma;    
        // Kirjoita funktio tähän
    }
    // BYCODEEND
}


