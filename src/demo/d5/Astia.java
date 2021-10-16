package demo.d5;

import fi.jyu.mit.ohj2.*;

/**
 * @author meikkupyrhonen
 * @version 10.10.2021
 *
 */
public class Astia {
    private String nimi;
    private int tilavuus;
    private int maara;

    /**
     * @param nimi mikä astia
     * @param tilavuus on astian tilavuus
     */
    public Astia(String nimi, int tilavuus) {
        this.nimi = nimi;
        this.tilavuus = tilavuus;
        this.maara = 0;
    }


    /**
     * täyttää astian täyteen vedellä
     * @return TODO
     */
    public int tayta() {
        this.maara = this.tilavuus;
        return maara;
    }


    /**
     * TODO
     * @param astiat lista käytössä olevista astioista
     */
    public static void tulostaOhje(Astia[] astiat) {
        if (astiat.length <= 0) return;
        String ja = "";
        System.out.print("Käytössäsi on ");
        for (int i = 1; i<astiat.length; i++) {
            System.out.print(ja + astiat[i].getTilavuus());
            ja = " sekä ";
            System.out.print(" litran astiat ja "
                    + "ämpäri (" + astiat[0].getTilavuus() +" l)");
        }
        
        
    }
    
    /**
     * @return astian nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param muki etsittävä astia
     * @return onko etsitty astia
     */
    public boolean oletko(String muki) {
        return getNimi().equalsIgnoreCase(muki);
    }
    /**
     * @param astiat lista astioista
     * @param astia astia jota etsitään
     * @return palautetaan indeksi josta astia löytyy
     */
    public static int etsi(Astia[] astiat, String astia) {
        for (int i = 0; i < astiat.length; i++) {
            if (astiat[i].oletko(astia)) return i;
        }
        return -1;
    }


    /**
     * @return tilavuus
     */
    public int getTilavuus() {
        return this.tilavuus;
    }


    /**
     * @return maara
     */
    public int getMaara() {
        return this.maara;
    }


    /**
     * @param astiat lista astioista
     * @param mista mistä kaadetaan
     * @param mihin mihin kaadetaan
     * 
     */
    public static void nimiOhje(Astia[] astiat, String mista, String mihin) {
        if (!"?".equals(mista)) {
            System.out.println("Nimeä ei tunneta: " + mista + " tai " + mihin);   
        }
        System.out.println("Tunnetaan nimet: ");
        for (int i = 0; i <astiat.length; i++) {
            System.out.println(astiat[i].getNimi() + " ");
            System.out.println("");
        }
    }


    /**
     * @param astia mihin kaadetaan
     * 
     */
    public void kaada(Astia astia) {
        int tilaa = astia.getTilavuus() - astia.getMaara();
        if (this.maara >= tilaa) {
           this.maara = this.maara - tilaa;
           astia.maara = astia.tilavuus;
       }
       else {
           astia.maara += this.maara;     
           this.maara = 0;
       }
    }


    /**
    * @param args ei käytössä
    */
    public static void main(String[] args) {
        Astia astiat[] = { new Astia("ä", 100), new Astia("5", 5),
                new Astia("8", 8) };
        Astia ampari = astiat[0];
        ampari.tayta();

        tulostaOhje(astiat);

        while (true) {
            for (int i = 1; i < astiat.length; i++)
                System.out.println(
                        astiat[i].getTilavuus() + " litran astiassa on "
                                + astiat[i].getMaara() + " litraa nestettä");
            String rivi = Syotto.kysy("Mistä kaadetaan ja mihin");
            if (rivi.length() == 0)
                break;

            StringBuilder sb = new StringBuilder(rivi);
            String mista = Mjonot.erota(sb);
            String mihin = Mjonot.erota(sb);
            int imista = etsi(astiat, mista);
            int imihin = etsi(astiat, mihin);

            if ((imista < 0) || (imihin < 0))
                nimiOhje(astiat, mista, mihin);
            else
                astiat[imista].kaada(astiat[imihin]);
        }
    }

}
