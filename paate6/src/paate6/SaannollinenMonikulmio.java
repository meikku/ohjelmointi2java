package paate6;

import java.awt.*;

import fi.jyu.mit.graphics.*;



/**
 * @author meikkupyrhonen
 * @version 14.10.2021
 *
 */
public class SaannollinenMonikulmio extends BasicShape {

    private final RPoint center;
    private double r;
    private int resolution;
    private int[] sXPoints;
    private int[] sYPoints;

    /**
     * Luo uuden ympyrän
     * @param x ympyrän keskipisteen x-koordinaatti
     * @param y ympyrän keskipisteen y-koordinaatti
     * @param r ympyrän säde
     */
    public SaannollinenMonikulmio(double x, double y, double r) {
       super();
     this.center = new RPoint(x, y);
      this.r = r;
         initialize(360);
       }


    /**
           * Luo uuden ympyrän
           * @param x ympyrän keskipisteen x-koordinaatti
           * @param y ympyrän keskipisteen y-koordinaatti
           * @param z ympyrän keskipisteen z-koordinaatti
           * @param r ympyrän säde
           */
          public SaannollinenMonikulmio(double x, double y, double z, double r) {
              super();
              this.center = new RPoint(x, y, z);
              this.r = r;
              int kulmat = (int) r;
              initialize(kulmat);
          }


    /**
     * Alustaa ympyrän asetukset
     */
    private void initialize(int x) {
        this.resolution = x;
        this.sXPoints = new int[resolution];
        this.sYPoints = new int[resolution];
    }


    /**
     * Asetetaan ympyrälle uusi säde
     * @param r uusi säteen arvo
     * @return tämä olio ketjuttamista varten
     */
    public SaannollinenMonikulmio setR(double r) {
        this.r = r;
        redraw();
        return this;
    }


    /**
     * Piirretään ympyrä
     * @see fi.jyu.mit.graphics.BasicShape#drawShape(java.awt.Graphics, fi.jyu.mit.graphics.Matrix)
     */
    @Override
    protected void drawShape(Graphics g, Matrix a) {
        Vector rp = new Vector(); // NOPMD, luulee vääräksi vektoriksi
        SPoint sp = new SPoint(0, 0);
        for (int i = 0; i < resolution; i++) {
            a.transform(
                    10*this.r * Math.cos((2 * Math.PI / resolution) * i)
                            + this.center.getX(),
                    10*this.r * Math.sin((2 * Math.PI / resolution) * i)
                            + this.center.getY(),
                    this.center.getZ(), rp, sp);
            sXPoints[i] = sp.getX();
            sYPoints[i] = sp.getY();
        }
        g.drawPolygon(sXPoints, sYPoints, resolution);
    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        EasyWindow window = new EasyWindow();
        window.add(new SaannollinenMonikulmio( 50, 50,30,3));
        window.add(new SaannollinenMonikulmio(150, 50,30,4));
        window.add(new SaannollinenMonikulmio( 50,150,30,5));
        window.add(new SaannollinenMonikulmio(150,150,30,6));
        window.showWindow();
    }
}
