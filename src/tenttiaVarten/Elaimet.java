/**
 * 
 */
package tenttiaVarten;

/**
 * @author meikk
 * @version 27.10.2021
 *
 */
public class Elaimet {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        String[] elaimet = {"kissa", "koira", "ankka"};
        for(String elain : elaimet){
           elain = elain + "13";
          }
      System.out.println(elaimet[0]); //pitäisi tulostua: kissa13
      System.out.println(elaimet[1]); //koira13
      System.out.println(elaimet[2]); //ankka13
      
      for(int i = 0; i < elaimet.length; i++) {
          String otus = elaimet[i];
          otus = elaimet[i] + "13";
          otus.charAt(i); // valitukset pois
      }
      System.out.println(elaimet[0]); //pitäisi tulostua: kissa13
      System.out.println(elaimet[1]); //koira13
      System.out.println(elaimet[2]); //ankka13
      
    
    }
    
    

}
