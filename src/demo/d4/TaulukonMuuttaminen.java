package demo.d4;

import java.util.Arrays;
/**
 * @author meikkupyrhonen
 * @version 29.9.2021
 *
 */
public class TaulukonMuuttaminen {
    /**
     * @param args ei käytössä
     */
    public static void main(String args[])
    {
        int[] t = { 23, 45, 12, 9, 3, 7 };
        System.out.println("Aluksi : " + Arrays.toString(t));
        KasitteleTaulukko(t);
        System.out.println("Lopuksi: " + Arrays.toString(t));
    }


    /**
     * Aliohjelmalla käsitellään taulukko sovitulla tavalla
     * @param t taulukko joka käsitellään
     * @example
     * #import java.util.Arrays;
     * <pre name="test">
     *  int[] t; 
     *  t = new int[]{$t1}; KasitteleTaulukko(t); Arrays.toString(t) === "[$t2]";
     *
     *  $t1                |   $t2
     * ------------------------------------------------
    *    55, 44, 33, 2, 5, 9 | 60, 49, 38, 7, 10, 14
    *    23, 45, -12, 9, 0, -5 | 28, 50, -7, 14, 5, 0
     * </pre>
     */
    public static void KasitteleTaulukko1(int[] t)
    {
        int lisattava = 5;
        for (int i = 0; i <t.length; i++) 
        {
            t[i] += lisattava;
        }
    }
    /**
     * @param t taulukko jota käsitellään
     * @example
     * @example
     * <pre name="test">
     *  int[] t;
     *  t = new int[]{$t1}; KasitteleTaulukko(t); Arrays.toString(t) === "[$t2]";
     *  
     *  $t1                |   $t2
     * ------------------------------------------------
     * 5, 4, 6, 2, 9, 1    | 9, 0, 8, 0, 10, 0
     * 12, 3, 5, -5, 7, 10 | 15, 0, 0, 0, 17, 0
     * </pre>
     */
    public static void KasitteleTaulukko(int[] t)
    {
        for (int i = 0; i <t.length; i +=2) 
        {
           //
           t[i] = t[i] + t[i + 1];
           t[i + 1] = 0;
        }   
    }
} 
