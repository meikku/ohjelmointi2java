package demo.d5.test;
// Generated by ComTest BEGIN
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;
import demo.d5.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.10 13:12:52 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class LinjaAutoTest {



  // Generated by ComTest BEGIN
  /** testLinjaAuto21 */
  @Test
  public void testLinjaAuto21() {    // LinjaAuto: 21
    LinjaAuto pikkubussi = new LinjaAuto(8); 
    assertEquals("From: LinjaAuto line: 23", 8, pikkubussi.getTilaa()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testVahenna33 */
  @Test
  public void testVahenna33() {    // LinjaAuto: 33
    LinjaAuto pikkubussi = new LinjaAuto(8); 
    pikkubussi.lisaa(4); 
    assertEquals("From: LinjaAuto line: 36", 4, pikkubussi.getTilaa()); 
    pikkubussi.vahenna(2); 
    assertEquals("From: LinjaAuto line: 38", 6, pikkubussi.getTilaa()); 
    pikkubussi.vahenna(5); 
    assertEquals("From: LinjaAuto line: 40", 8, pikkubussi.getTilaa()); 
    pikkubussi.vahenna(10); 
    assertEquals("From: LinjaAuto line: 42", 8, pikkubussi.getTilaa()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaa59 */
  @Test
  public void testLisaa59() {    // LinjaAuto: 59
    LinjaAuto pikkubussi = new LinjaAuto(8); 
    pikkubussi.lisaa(4); 
    assertEquals("From: LinjaAuto line: 62", 4, pikkubussi.getTilaa()); 
    pikkubussi.lisaa(10); 
    assertEquals("From: LinjaAuto line: 64", 0, pikkubussi.getTilaa()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testTulosta81 */
  @Test
  public void testTulosta81() {    // LinjaAuto: 81
    ByteArrayOutputStream byteoutput = new ByteArrayOutputStream(); 
    LinjaAuto isobussi = new LinjaAuto(45); 
    isobussi.lisaa(3); 
    isobussi.tulosta(byteoutput); 
    { String _l_=byteoutput.toString(),_r_="Paikkoja: 45, matkustajia: 3, vapaita: 42\\s"; if ( !_l_.matches(_r_) ) fail("From: LinjaAuto line: 87" + " does not match: ["+ _l_ + "] != [" + _r_ + "]");}; 
  } // Generated by ComTest END
}