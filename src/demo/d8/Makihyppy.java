package demo.d8;

import demo.d7.Taulukot;

/**
 * Mäkihyppy-luokka
 * @author meikk
 * @version 28.10.2021
 *
 */
public class Makihyppy {

    /**
     * Luokka yhtä mäkihypyn kierrosta varten
     */
    public static class Kierros {
        private final static int TUOMAREITA = 5;
        private double pituus; // hyppyjen pituudet metreinä
        private final double tuomarit[] = new double[TUOMAREITA];// tuomaripisteet

        /** 
         * Kierroksen alustaminen   
         */
        public Kierros() {
            //
        }


        /**
         * #import demo.d7.Taulukot;
         * Haetaan kierroksen tuomaripisteet, joista vähennetty paras ja huonoin annettu pistemäärä
         * @return tuomareiden pisteet, joista vähennetty paras ja huonoin pistemäärä
         * @example
         * <pre name="test">
         * double[] tuomarit = { 0.0, -3.5, 3.5, -6.5, 6.5, 9 };
         * Taulukot.summaHuonoinJaParasPois(tuomarit) ~~~ 6.5;
         * double[] tuomarit2 = { 0.0, -103.5, 300.5, -605.5, 896.5, 199.5 };
         * Taulukot.summaHuonoinJaParasPois(tuomarit2) ~~~ 396.5;
         * double[] tuomarit3 = { 0.0, 0, 0, 0, 0, 0 };
         * Taulukot.summaHuonoinJaParasPois(tuomarit3) ~~~ 0;
         * </pre>
         */
        public double getTulos() {
            return Taulukot.summaHuonoinJaParasPois(tuomarit);
        }


        /**
         * Asetetaan kierroksen hypyn pituus
         * @param pituus kierroksen hypyn pituus
         */
        public void setPituus(double pituus) {
            this.pituus = pituus;
        }


        /**
         * Haetaan kierroksen hypyn pituus
         * @return kierroksen hypyn pituus
         */
        public double getPituus() {
            return pituus;
        }


        /**
         * Asetetaan tuomarin pisteet
         * @param tuomari monesko tuomari
         * @param pisteet mitkä pisteet tuomari antaa
         */
        public void setTuomari(int tuomari, double pisteet) {     
             tuomarit[tuomari -1] = pisteet;
        }


        @Override
        public String toString() {

            String tulos = "";
            for (int i = 0; i < tuomarit.length; i++) {
                tulos = tulos.concat("\t" + tuomarit[i]);
            }
            return tulos;
        }

    }

    /**
     * Luokka mäkihypyn yhden kilpailijan tulosta varten.
     * Sisältää monta kierrosta.
    
     */
    public static class Tulos {
        private final static int KIERROKSIA = 2;
        private final Kierros kierros[] = new Kierros[KIERROKSIA];
        private static double K_PISTE = 60;
        private static double METRIKERROIN = 1.0;
        private int lkm = 0;

        /** Tuloksen alustaminen
        *  @example
        * <pre name="test">
        * Makihyppy.Tulos tulos = new Makihyppy.Tulos();
        * tulos.getPituus(1) ~~~ 0;  
        * </pre> 
         */
        public Tulos() {
            for (int i = 0; i < KIERROKSIA; i++) {
                kierros[i] = new Kierros();
                lkm++;
            }
        }


        /**
         * Asetetaan hypyn pituus oikealle kierrokselle
         * @param i kierroksen numero 
         * @param pituus hypyn pituus
         * @example
         * <pre name="test">
         * Makihyppy.Tulos tulos = new Makihyppy.Tulos();
         * tulos.setPituus(1, 102.5);
         * tulos.getPituus(1) ~~~ 102.5;
         * </pre>
                  */
        public void setPituus(int i, double pituus) {
            if (i < 1 || kierros.length < lkm)
                return;

            kierros[i - 1].setPituus(pituus);
        }


        /**
         * Haetaan halutun kierroksen hypyn pituus
         * @param i monesko kierros
         * @return hypyn pituus
         * @example
         * <pre name="test">
         * Makihyppy.Tulos tulos = new Makihyppy.Tulos();
         * tulos.setPituus(2, 85.5);
         * tulos.getPituus(2) ~~~ 85.5;
         * </pre>
         * Makihyppy.Tulos tulos = new Makihyppy.Tulos();
         * tulos.setPituus(2, 85.5);
         * tulos.getPituus(2) ~~~ 85.5;
         */
        public double getPituus(int i) {
            return kierros[i - 1].getPituus();
        }


        /**
         * Haetaan halutun kierroksen tulos (pituus + tuomaripisteet)
         * @param i monesko kierros
         * @return kilpailijan kokonaispistemäärä
         * @example
         * <pre name="test">
         *  Makihyppy.Tulos tulos = new Makihyppy.Tulos();
         *  tulos.setPituus(1, 105.5);
         *  tulos.setTuomari(1, 1, 20.0);
         *  tulos.setTuomari(1, 2, 18.5);
         *  tulos.setTuomari(1, 3, 15.5);
         *  tulos.setTuomari(1, 4, 19.5);
         *  tulos.setTuomari(1, 5, 16.0);
         *  tulos.getTulos(0) ~~~ 99.5;
         * </pre>
         */
        public double getTulos(int i) {
            double pisteet = kierros[i].getTulos();
            double pituus = kierros[i].getPituus();

            if (pisteet <= 0)
                return 0;

            return METRIKERROIN * pituus - K_PISTE + pisteet;
        }


        /**
         * Haetaan kilpailijan yhteispisteet kaikilta kierroksilta
        * @return kilpailijan yhteispisteet 
        * @example
        * <pre name="test">
         *  Makihyppy.Tulos tulos = new Makihyppy.Tulos();
         *  tulos.setPituus(1, 105.5);
         *  tulos.setPituus(2, 104);
         *  tulos.setTuomari(1, 1, 20.0); // ei huomioida  
         *  tulos.setTuomari(1, 2, 18.5);
         *  tulos.setTuomari(1, 3, 15.5); // ei huomioida
         *  tulos.setTuomari(1, 4, 19.5);
         *  tulos.setTuomari(1, 5, 16.0);
         *  tulos.setTuomari(2, 1, 19.5); // ei huomioida
         *  tulos.setTuomari(2, 2, 18.5);
         *  tulos.setTuomari(2, 3, 15.5);
         *  tulos.setTuomari(2, 4, 13); // ei huomioida
         *  tulos.setTuomari(2, 5, 16.0);
         *  tulos.getYhteisPisteet() ~~~ 193.5; 
        * </pre>
        */
        public double getYhteisPisteet() {
            double yhteisPisteet = 0;
            for (int i = 0; i < kierros.length; i++)
                yhteisPisteet += getTulos(i);
            return yhteisPisteet;
        }


        /**
         * Kutsuu kierros-luokan setTuomari-metodia
         * @param kierrosLuku mikä kierros
         * @param tuomari monesko tuomari
         * @param pisteet paljonko pisteitä tuomari antaa
         * 
         */
        public void setTuomari(int kierrosLuku, int tuomari, double pisteet) {
            // if ( i <= kierrosLuku && kierrosLuku <=KIERROKSIA)
            kierros[kierrosLuku - 1].setTuomari(tuomari, pisteet);
        }


        @Override
        public String toString() {
            String tulos = "";
            for (int i = 0; i < kierros.length; i++) {
                tulos = tulos.concat(
                        "\nKierros " + (i + 1) + "\t " + this.getPituus(i + 1)
                                + " m. " + " Tuomarit: " + kierros[i].toString()
                                + " = " + getTulos(i) + " pistettä");
            }

            return tulos;
        }

    }

    /**
     * Luokka yhtä mäkihypyn kilpailijaa varten.
     * Sisältää mm. tuloksen.
     */
    public static class Kilpailija { // implements Comparable<Kilpailija> { niin tietorakenteen sort osaisi järjestää
        private String nimi;
        private int nro;
        private final Tulos tulos = new Tulos();

        /**
         * Kilpailijan alustaminen
         * @param nimi kilpailijan nimi
         * @param nro kilpailijan kilpailunumero
         */
        public Kilpailija(String nimi, int nro) {
            this.nimi = nimi;
            this.nro = nro;
        }


        /**
         * Kutsutaan Tulos-luokan setPituus-metodia
         * @param kierros kierroksen numero
         * @param pituus asetettavan hypyn pituus
         */
        public void setPituus(int kierros, double pituus) {
            tulos.setPituus(kierros, pituus);
        }


        /**
         * Haetaan halutun kierroksen hypyn pituus
         * @param kierrosLuku monesko kierros
         * @return kierroksen hypyn pituus
         */
        public double getPituus(int kierrosLuku) {
            return tulos.getPituus(kierrosLuku);
        }


        /**
         * Asetetaan tuomaripisteet
         * @param kierros kierroksen numero
         * @param tuomari tuomarin numero
         * @param pisteet tuomarin antamat pisteet
         */
        public void setTuomari(int kierros, int tuomari, double pisteet) {
            tulos.setTuomari(kierros, tuomari, pisteet);
        }


        /**
         * Pyydetään kilpailijan kokonaispistemäärää tulos-luokalta
         * @return kokonaispistemäärä
         */
        public double getYhteisPisteet() {
            return tulos.getYhteisPisteet();
        }


        /**
         * Verrataan kahden kilpailijan yhteispistemäärää
         * @param kilpailija kilpailija johon verrataan
         * @return positiivinen luku, jos kutsuva kilpailija parempi, negatiivinen jos huonompi
         */
        public double compareTo(Kilpailija kilpailija) {
            return this.getYhteisPisteet() - kilpailija.getYhteisPisteet();
        }


        /** Tulostaa kilpailijan tiedot */

        public void tulosta() {
            System.out.print("  " + this.nro + ": " + this.nimi);
            System.out.println(tulos.toString());
            System.out.println(
                    "Yhteensä: \t" + this.getYhteisPisteet() + " pistettä.\n");

        }

    }

    /**
     * Tyhjä aliohjelma kilpailua varten
     */
    public void kisa() {
        Kilpailija toni = new Kilpailija("Toni", 3);
        Kilpailija matti = new Kilpailija("Matti", 7);
        toni.tulosta();
        matti.tulosta();

        toni.setPituus(1, 107); // 1. kierros, 107 m
        toni.setPituus(2, 100); // 2. kierros, 100 m
        toni.setTuomari(2, 1, 19.0); // 2. kierros, 1. tuomari, 19 p
        toni.setTuomari(2, 2, 18.0); // 2. kierros, 2. tuomari, 18 p
        toni.setTuomari(2, 3, 19.5);
        toni.setTuomari(2, 4, 18.0);
        toni.setTuomari(2, 5, 20.0);

        matti.setPituus(1, 125);
        matti.setTuomari(1, 1, 20.0);
        matti.setTuomari(1, 2, 20.0);
        matti.setTuomari(1, 3, 20.0);
        matti.setTuomari(1, 4, 20.0);
        matti.setPituus(2, 109);
        matti.setTuomari(2, 1, 20.0);
        matti.setTuomari(2, 2, 20.0);
        matti.setTuomari(2, 3, 20.0);
        matti.setTuomari(2, 4, 20.0);

        toni.tulosta();
        matti.tulosta();

        if (matti.compareTo(toni) > 1)
            System.out.println("Matti voitti!");
    }


    /**
     * Testataan luokan kääntymistä
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Makihyppy kisa = new Makihyppy();
        kisa.kisa();
    }

}