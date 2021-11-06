package demo.d8;

/**
 * @author meikk
 * @version 31.10.2021
 *
 */
public class Postimaksu {

    /**
     * Poikkeus jos yritetään lähettää yli 2000 g painava kirje
     * @author meikk
     * @version 31.10.2021
     *
     */
    public static class EiJaksaKantaaException extends Exception {
        private static final long serialVersionUID = 1L;

        EiJaksaKantaaException(String viesti) {
            super(viesti);
        }

    }
    
    private static final double[][] hinnat2 = { { 0, 50.0, 100.0, 250.0, 500.0, 1000.0, 2000.0 }, 
            { 0, 0.6, 0.9, 1.3, 2.1, 3.5, 5.5 } };
    /*
     * Vesan esimerkissä toisinpäin:
     * {
     * {50.0, 0.6},
     * {100.0, 0.9},
     * {250.0, 1.3},
     * {500.0, 2.1}
     * }
     */
    
    
    
    /**
     * Tehdään kaksiulotteinen taulukko, jossa kirjeen maksimipaino ja postimaksun hinta
     * @param taulukko kaksiulotteinen taulukko jota tutkitaan
     * @param paino kirjeen paino
     * @return postimaksu annetulle painolle
     * @example
     * <pre name="test">
     *  double[][] postimaksu = { { 1.00, 1.40, 2.00, 4.00, 6.00, 10.00 },{ 50, 100, 250, 500, 1000, 2000 } };
     *  postimaksu2(postimaksu, 2000) ~~~ 10.0;
     *  postimaksu2(postimaksu, 140) ~~~ 2.0; 
     *  postimaksu2(postimaksu, -800) ~~~ 0; 
     *  postimaksu2(postimaksu, 756) ~~~ 6.0;
     * </pre>
     */
    public static double postimaksu2(double[][] taulukko, int paino) {
        if (paino <= 0) return 0;
        double maksu = 0;
        for (int i = 0; i < taulukko[1].length -1; i++) {
            if (paino >= taulukko[1][i]) maksu = taulukko[0][i + 1];
        }
        return maksu;
    }

    /**
     * Taulukko jossa kirjeen maksimipainot ja niitä vastaavat hinnat
     */
    private static Hinta[] hinnat = { 
            new Hinta(0, 0), 
            new Hinta(50, 0.60),
            new Hinta(100, 0.90), 
            new Hinta(250, 1.30), 
            new Hinta(500, 2.10),
            new Hinta(1000, 3.50), 
            new Hinta(2000, 5.50) 
            };

    /**
    * Hinta-luokka, jonka olioilla on hinta ja paino
    * @author meikk
    * @version 31.10.2021
    * 
    */
    public static class Hinta {
        private int paino;
        private double hinta;

        /**
         * Alustetaan hinta-olio
         * @param paino annettu kirjeen paino
         * @param hinta annettu postimaksun hinta
         * @example
         * <pre name="test">
         *  Postimaksu.Hinta edullinen = new Postimaksu.Hinta(1000, 0.20);
         *  edullinen.getPaino() === 1000;
         *  edullinen.getHinta() ~~~ 0.20;
         * </pre>
         */
        public Hinta(int paino, double hinta) {
           if (paino >= 0 && paino <= 2000)
                this.paino = paino;
           if (hinta >= 0)
                this.hinta = hinta;
        }


        /**
         * @return hinta-olion paino 
         */
        public int getPaino() {
            return paino;
        }


        /**
         * @return hinta-olion hinta
         * @example
         * <pre name="test">
         *  Postimaksu.Hinta edullinen = new Postimaksu.Hinta(1000, -0.20);
         *  edullinen.getPaino() === 1000;
         *  edullinen.getHinta() ~~~ 0;
         *  Postimaksu.Hinta suuri = new Postimaksu.Hinta(1000, 2500);
         *  suuri.getPaino() === 1000;
         *  suuri.getHinta() ~~~ 2500.00;
         * </pre>
         */
        public double getHinta() {
            return hinta;
        }

    }

    /**
     * Selvitetään kuinka painavan kirjeen saa lähettää annetulla postimaksulla
     * @param maksu kirjeen lähetystä varten
     * @return kirjeen maksimipaino annettua maksua vastaan
     * @example
     * <pre name="test">
     *  suurinKirjeenPainoIf(0) === 0;
     *  suurinKirjeenPainoIf(-6) === 0;
     *  suurinKirjeenPainoIf(1.29) === 100;
     *  suurinKirjeenPainoIf(1.3) === 250;
     *  suurinKirjeenPainoIf(1.31) === 250;
     *  suurinKirjeenPainoIf(15) === 2000;
     * </pre>
     */
    public static int suurinKirjeenPainoIf(double maksu) {
        for (int i = hinnat.length - 1; i > 0; i--) {
            if (maksu >= hinnat[i].hinta)
                return hinnat[i].paino;
        }
        return 0;
    }


    /**
     * Selvitetään paljonko tietyn painoisen kirjeen lähettäminen maksaa
     * @param kirjeenPaino kirjeen paino
     * @return kirjeen lähettämisen hinta
     * @throws EiJaksaKantaaException jos liian painava paketti
     * @example
     * <pre name="test">
     * #THROWS EiJaksaKantaaException
     *  postimaksu(-70) ~~~ 0;
     *  postimaksu(0) ~~~ 0;
     *  postimaksu(50) ~~~ 0.6; 
     *  postimaksu(100) ~~~ 0.9; 
     *  postimaksu(999) ~~~ 3.5;
     *  postimaksu(1000) ~~~ 3.5;
     *  postimaksu(1001) ~~~ 5.5;
     *  postimaksu(3000); #THROWS EiJaksaKantaaException 
     * </pre>
     */
    public static double postimaksu(int kirjeenPaino) throws EiJaksaKantaaException{
        double maksu = 0;
        if (kirjeenPaino <= 0) return 0;
        if (kirjeenPaino > 2000) throw new EiJaksaKantaaException("Liian painava, lähetä pakettina.");

        for (int i = 0; i < hinnat.length; i++) {
            if (kirjeenPaino > hinnat[i].getPaino()) 
            maksu = hinnat[i + 1].getHinta();
         }
        return maksu;
    }


    /**
     * Kokeillaan kutsua kirjeenpainoa
     * @param args ei käytössä
     */
    public static void main(String[] args) {

        int paino = suurinKirjeenPainoIf(3.60);
        System.out.println("Tällä voi lähettää " + paino + " g");
        
    }

}