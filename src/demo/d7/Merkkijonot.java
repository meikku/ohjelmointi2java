/**
 * 
 */
package demo.d7;

/**
 * @author meikk
 * @version 23.10.2021
 *
 */
public class Merkkijonot {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        String kissa = "kissa";
        String k = "aik";
        System.out.println(onkoMuitaKirjaimia(kissa, k));
        k = "aiks";
        System.out.println(onkoMuitaKirjaimia(kissa, k));
        System.out.println(
                viimeinenKenoViiva("C:\\mytemp\\ohj2\\vesal\\Koe.java"));
        System.out.println(loytyykoKirjaimia(kissa, "ibm"));
        System.out.println(loytyykoKirjaimia(kissa, "pc"));
        System.out.println(onkoSama("matti*", "Matti Nykänen"));
        System.out.println(paljonkoMerkkeja("Kissa istuu puussa"));

    }


    /**
     * Tutkitaan sisältyykö merkkijonoon muita kirjaimia kuin toinen annettu merkkijono
     * @param a merkkijono josta etsitään
     * @param b merkkijono jonka kirjaimia tutkitaan
     * @return totta vai ei
     * @example
     * <pre name="test">
     *  String kissa = "kissa";
     *  String asia = "asssssia";
     *  String b = "b";
     *  String aik  = "AIK";
     *  String kaivinKone = "kaivinkone";
     *  onkoMuitaKirjaimia(kissa, asia) === true;
     *  onkoMuitaKirjaimia(kissa, asia) === true;
     *  onkoMuitaKirjaimia(kissa, b) === true;
     *  onkoMuitaKirjaimia(kissa, aik) === true;
     *  onkoMuitaKirjaimia(kissa, kaivinKone) === true;
     *  onkoMuitaKirjaimia(kissa, "a") === true;
     *  onkoMuitaKirjaimia(kissa, "asiakas") === false;
     * </pre>
     */
    public static boolean onkoMuitaKirjaimia(String a, String b) {

        for (int i = 0; i < a.length(); i++) {

            if (!b.contains(a.substring(i, i + 1)))
                return true;

        }
        return false;
    }


    /**
     * Selvitetään viimeisen \-merkin paikka
     * @param a merkkijono josta etsitään kenoviivaa
     * @return indeksi josta viimeinen \ löytyy
     * @example
     * <pre name="test">
     *  viimeinenKenoViiva("\\test") === 0;
     *  viimeinenKenoViiva("test\\test") === 4;
     *  viimeinenKenoViiva("/viivoja\\joka/suuntaan\\") === 22;
     *  viimeinenKenoViiva("&%\"#!\\") === 5;
     *  viimeinenKenoViiva("porkkana") === -1;
     *  viimeinenKenoViiva("\\j\\test\"") === 2;
     *  viimeinenKenoViiva("\\\\test") === 1;
     * </pre>
     */
    public static int viimeinenKenoViiva(String a) {
        int viimeinen = -1;
        
        for (int i = 0; i < a.length(); i++) {
           
            if (a.substring(i, i + 1).equals("\\")) viimeinen = i;

        }
        return viimeinen;
    }
    
    
    
    /**
     * Selvitetään löytyykö joku kirjaimista merkkijonosta
     * @param a merkkijono josta etsitään
     * @param b merkkijono jonka kirjaimia etsitään
     * @return totta jos joku kirjaimista löytyy
     * loytyykoKirjaimia("kissa", "mac") === true;
     * loytyykoKirjaimia("kissa", "MAC") === true;
     * loytyykoKirjaimia("kissa", "koira") === true;
     * loytyykoKirjaimia("kissa", "hylje") === false;
     * loytyykoKirjaimia("kissa", "s") === true;
     * loytyykoKirjaimia("kissa", "j") === false;
     * 
     */
    public static boolean loytyykoKirjaimia(String a, String b) {
        
        for (int i = 0; i < b.length(); i++) {

            if (a.contains(b.substring(i, i + 1)))
                return true;

        }
        return false;
    }
    /**
     * @param a merkkijono johon verrataan
     * @param b merkkijono jota verrataan
     * @return onko samat
     * @example
     * <pre name="test">
     * onkoSama(" matti* ", "Matti Nykänen") === true;
     * </pre>
     */
    public static boolean onkoSama(String a, String b) {
        String eka = a.trim().toLowerCase();
        String toka = b.trim().toLowerCase();
        /**
         *  Vesan esimerkki:
         *  b = b.replaceAll("\\.","\\\\.");
         *  b = b.replaceAll("\\*", ".*");
         *  return a.matches(b);
         */
        
        String[] ekaJono = eka.split("\\*");  
        
        
        if (toka.contains(ekaJono[0])) return true;

        return false;
    }
    
    
    /**
     * Vesan esimerkki:
     * paljonkoMerkkejä(String a, String merkit)
     * Pattern maski = Pattern.compile("[" + merkit + "]");
     * for (int i = 0; i < a.length(); i++) {
     *  Matcher merkki = maski.matcher("" + jono.charAt(i));
     *  if (merkki.matches()) count++;
     */
    /**
     * 
     * @param a merkkijono jota tutkitaan
     * @return montako merkkiä löytyy
     * @example
     * <pre name="test">
     * paljonkoMerkkeja("Kissa istuu puussa") === 14;
     * </pre>
     */
    
    public static int paljonkoMerkkeja(String a) {
        int count = 0;
        char[] merkit = {'a', 'b','c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'r','s','t','u','v','w'};
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < merkit.length; j++) {
                    if (merkit[j]== a.charAt(i)) count++;
                }
            
        }
            return count;
    }
    
    
    
    /**
     * Selvitetään onko annettu merkkijono palindromi
     * @param a merkkijono jota tutkitaan
     * @return onko totta vai ei
     * @example
     * <pre name="test">
     * palindromi("saippuakauppias") === true;
     * palindromi("saippuakivikauppias") === true;
     * palindromi("eye") === true;
     * palindromi("ukko") === false;
     * palindromi("akka") === true;
     * </pre>
     */
    public static boolean palindromi(String a) {

        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length()-1 - i)) return false;
        }
        return true;
    }
}
