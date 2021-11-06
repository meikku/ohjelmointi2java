package demo.d9;

/**
 * @author meikk
 * @version 6.11.2021
 *
 */
public class MerkkiJono {

    
    /**
     * Selvitetään mikä on pisin nouseva kirjainyhdistelmä, joka sanasta löytyy
     * @param mj merkkijono jota tutkitaan
     * @return pisimmän nousevan kirjainyhdistelmän pituus
     * @example
     * <pre name="test">
     *  pisinNouseva("ei") === 2;
     *  pisinNouseva("yö") === 2;
     *  pisinNouseva("uuuuu") === 5;
     *  pisinNouseva("yök") === 2;
     *  pisinNouseva("poli") === 1;
     *  pisinNouseva("ääk") === 2;
     *  pisinNouseva("maatiainen") === 3;
     *  pisinNouseva("äyskäri") === 2;
     *  pisinNouseva("saapas") === 3;
     *  pisinNouseva("ademopu") === 7;
     *  pisinNouseva("aamu") === 4;
     *  pisinNouseva("a") === 1;
     *  pisinNouseva("") === 0;
     * </pre>
     */
    public static int pisinNouseva(String mj) {
        
        if (mj.length() == 0) return 0;
        
        int pisin = 1;
        int pituus = 1;
        
        for (int i = 0; i < mj.length()-1 ; i ++) {
            if (mj.charAt(i) <= mj.charAt(i + 1)) {
                pituus++;
                if (pituus > pisin) pisin = pituus;
            }
            else pituus = 1;
        }
        return pisin;
    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
    }

}
