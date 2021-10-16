package demo.d5;

import java.io.*;


/**
 * @author meikkupyrhonen
 * @version 9.10.2021
 *
 */
public class LinjaAuto {
    
    private int paikkoja;
    private int vapaita;
    
    
    /**
     * muodostaja, jolle kerrotaan montako paikkaa autossa on
     * @param paikkoja paikkojen määrä
     * @example
     * <pre name="test">
     * LinjaAuto pikkubussi = new LinjaAuto(8);
     * pikkubussi.getTilaa() === 8;
     * </pre>
     */
    public LinjaAuto(int paikkoja) {
        this.paikkoja = paikkoja;
        vapaita = paikkoja;
    }   
    /**
     * @param ulos poistuvien matkustajien määrä
     * @return paljonko vajausta eli paljonko enemmän poistuvia kuin kyydissä matkustajia
     *  <pre name="test">
     * LinjaAuto pikkubussi = new LinjaAuto(8);
     * pikkubussi.lisaa(4);
     * pikkubussi.getTilaa() === 4;
     * pikkubussi.vahenna(2);
     * pikkubussi.getTilaa() === 6;
     * pikkubussi.vahenna(5);
     * pikkubussi.getTilaa() === 8;
     * pikkubussi.vahenna(10);
     * pikkubussi.getTilaa() === 8;
     * </pre>
     */
    public int vahenna(int ulos) {
        int kyydissa = this.paikkoja - this.vapaita;
        
        if (ulos > kyydissa) {
            this.vapaita = this.paikkoja;            
        }
        
        else this.vapaita += ulos; 
        return kyydissa - ulos;
    }
    
    /**
     * @param sisaan kyytiin nousevien matkustajien määrä
     * @return paljonko matkustajia jää yli
     * <pre name="test">
     * LinjaAuto pikkubussi = new LinjaAuto(8);
     * pikkubussi.lisaa(4);
     * pikkubussi.getTilaa() === 4;
     * pikkubussi.lisaa(10);
     * pikkubussi.getTilaa() === 0;
     * </pre>
     */
    public int lisaa(int sisaan) {
        if (this.vapaita < sisaan) 
            {
            int yli = sisaan - this.vapaita;
            this.vapaita = 0;
            return  yli;
            }
        this.vapaita -= sisaan;
        return 0;
    }
    
    /**
     * @param os tietovirta johon tiedot tulostetaan
     * @example
     * <pre name="test">
     * #import java.io.*;
     * ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
     * LinjaAuto isobussi = new LinjaAuto(45);
     * isobussi.lisaa(3);
     * isobussi.tulosta(byteoutput); 
     * byteoutput.toString() =R= "Paikkoja: 45, matkustajia: 3, vapaita: 42\\s";
     * </pre>
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        int matkustajia = this.paikkoja - this.vapaita;
        out.println("Paikkoja: " + this.paikkoja + ", matkustajia: " + matkustajia + ", vapaita: " + this.vapaita);
    }
    
    /**
     * @return montako vapaata paikkaa on
     */
    public int getTilaa() {
        return this.vapaita;
    }
    
    /**
     * @return onko bussissa tilaa (true / false)
     */
    public Boolean tilaa() {
        return vapaita > 0;
    }
    
    
    /**
     * @param args ei käytössä
     */ 
    public static void main(String[] args) {
        LinjaAuto pikkubussi = new LinjaAuto(10);
        LinjaAuto isobussi = new LinjaAuto(45);
        pikkubussi.lisaa(4);    pikkubussi.tulosta(System.out); // 10,4,6
        isobussi.lisaa(30);     isobussi.tulosta(System.out);   // 45,30,15
        int yli = pikkubussi.lisaa(15);
        isobussi.lisaa(yli);
        pikkubussi.tulosta(System.out);                         // 10,10,0
        isobussi.tulosta(System.out);                           // 45,39,6
        if ( pikkubussi.getTilaa() > 0 )
            System.out.println("Pieneen bussiin mahtuu!");   // ei tulosta
        if ( isobussi.tilaa() )
            System.out.println("Isoon bussiin mahtuu!");     // tulostaa
        int vajaa = pikkubussi.vahenna(12);                  // vajaa = -2
        System.out.println("vajaa = " + vajaa);
        if ( vajaa < 0 )
            System.out.println("Pikkubussissa ei edes ole näin montaa!");
        pikkubussi.tulosta(System.out);                         // 10,0,10
   }
}
