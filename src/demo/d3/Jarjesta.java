package demo.d3;

import fi.jyu.mit.ohj2.*;

/**
 * @author meikkupyrhonen
 * @version 28.9.2021
 *
 */
public class Jarjesta {
    /**
     * Palauttaa jonon kaksi ensimmäistä sanaa aakkosjärjestyksessä
     * @param jono merkkijono, jonka kaksi ensimmäistä sanaa järjestetään
     * @return jono jossa kaksi ensimmäistä sanaa aakkosjärjestyksessä
     * 
     * @example
     * <pre name="test">
     *  jarjesta1ja2("Ankka Aku") === "Aku Ankka";
     *  jarjesta1ja2("Aku Ankka") === "Aku Ankka";
     *  jarjesta1ja2("Ankka Aku") === "Aku Ankka";
     *  jarjesta1ja2("Palo Jukka Pekka") === "Jukka Palo";
     *  jarjesta1ja2("Aku")              === "Aku";
     *  jarjesta1ja2("")                 === "";
     *  jarjesta1ja2(null)               === null; #THROWS NullPointerException  
     *</pre>  
     */
    public static String jarjesta1ja2(String jono) {
        StringBuilder sbjono = new StringBuilder(jono);
        String eka = Mjonot.erota(sbjono);
        String toka = Mjonot.erota(sbjono);
        if (toka.length() == 0)
            return eka;
        if (eka.compareToIgnoreCase(toka) <= 0)
            return eka + " " + toka;
        return toka + " " + eka;
    }
    private static int jarjesta12testi(String jono, String odotettuTulos) {
        String tulos = jarjesta1ja2(jono);
        if (tulos.equals(odotettuTulos))
            return 0;
        System.out.println("Jono: => " + tulos + " piti tulla: " + odotettuTulos);
        return 1;
    }
    /**
     * Testataan kahden ensimmäisen sanan järjestämistä
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int v = 0;
        v += jarjesta12testi("Ankka Aku", "Aku Ankka");
        v += jarjesta12testi("Aku Ankka", "Aku Ankka");
        v += jarjesta12testi("Palo Jukka Pekka", "Jukka Palo");
        v += jarjesta12testi("Aku", "Aku");
        v += jarjesta12testi("", "");
        System.out.printf("Virheitä: %d", v);       
    }
}
