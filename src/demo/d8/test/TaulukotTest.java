package demo.d8.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d8.Taulukot.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.31 19:22:32 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaulukotTest {



  // Generated by ComTest BEGIN
  /** testMatriisinSuurin24 */
  @Test
  public void testMatriisinSuurin24() {    // Taulukot: 24
    double matriisi1[][] = { { 0.9, 5.6, -1.3, -11.2 } , { 9.8, 16.7, -0.2, 88 } } ; 
    assertEquals("From: Taulukot line: 26", 88, matriisinSuurin(matriisi1), 0.000001); 
    double matriisi2[][] = { { -100, -1.1, -1.3, -11.2 } , { -9.8, -16.7, -0.2, -88 } } ; 
    assertEquals("From: Taulukot line: 28", -0.2, matriisinSuurin(matriisi2), 0.000001); 
    double matriisi3[][] = { { 0.0, 1.1, -1.3, -1.2 } , { 0.8, 0.7, -0.2, 0.8 } } ; 
    assertEquals("From: Taulukot line: 30", 1.1, matriisinSuurin(matriisi3), 0.000001); 
    double matriisi4[][] = { { 900.9, 100.6, -1000.3, -1100.2 } , { 9000.8, 1600.7, -1000.2, 880 } } ; 
    assertEquals("From: Taulukot line: 32", 9000.8, matriisinSuurin(matriisi4), 0.000001); 
  } // Generated by ComTest END
}