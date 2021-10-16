package demo.d6.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d6.Pvm.*;
import demo.d6.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.14 16:40:45 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class PvmTest {



  // Generated by ComTest BEGIN
  /** testCompareTo102 */
  @Test
  public void testCompareTo102() {    // Pvm: 102
    Pvm pv1 = new Pvm(3, 6, 1999); 
    Pvm pv2 = new Pvm(9, 5, 2021); 
    Pvm pv3 = new Pvm(9, 4, 2021); 
    Pvm pv4 = new Pvm(3, 6, 1999); 
    assertEquals("From: Pvm line: 107", -1, compareTo(pv1, pv2)); 
    assertEquals("From: Pvm line: 108", 1, compareTo(pv2, pv3)); 
    assertEquals("From: Pvm line: 109", 0, compareTo(pv1, pv4)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testCompareTo130 */
  @Test
  public void testCompareTo130() {    // Pvm: 130
    Pvm pv1 = new Pvm(3, 6, 1999); 
    Pvm pv2 = new Pvm(9, 5, 2021); 
    Pvm pv3 = new Pvm(9, 4, 2021); 
    Pvm pv4 = new Pvm(3, 6, 1999); 
    assertEquals("From: Pvm line: 135", -1, pv1.compareTo(pv2)); 
    assertEquals("From: Pvm line: 136", 1, pv2.compareTo(pv3)); 
    assertEquals("From: Pvm line: 137", 0, pv1.compareTo(pv4)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testEquals155 */
  @Test
  public void testEquals155() {    // Pvm: 155
    Pvm pv1 = new Pvm(3, 6, 1999); 
    Pvm pv2 = new Pvm(9, 5, 2021); 
    Pvm pv3 = new Pvm(9, 4, 2021); 
    Pvm pv4 = new Pvm(3, 6, 1999); 
    assertEquals("From: Pvm line: 160", false, pv1.equals(pv2)); 
    assertEquals("From: Pvm line: 161", false, pv2.equals(pv3)); 
    assertEquals("From: Pvm line: 162", true, pv1.equals(pv4)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testToString178 */
  @Test
  public void testToString178() {    // Pvm: 178
    Pvm tammi2011 = new Pvm(1,1,2011); 
    assertEquals("From: Pvm line: 180", "1.1.2011", tammi2011.toString());
    Pvm helmi2011 = new Pvm(1,2,2011); 
    assertEquals("From: Pvm line: 182", "1.2.2011", helmi2011.toString());
    Pvm tanaan = new Pvm(14,2,2011); 
    assertEquals("From: Pvm line: 184", "14.2.2011", tanaan.toString());
    Pvm maalis97 = new Pvm(1,3,1997); 
    assertEquals("From: Pvm line: 186", "1.3.1997", maalis97.toString());
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse225 */
  @Test
  public void testParse225() {    // Pvm: 225
    Pvm pvm = new Pvm(11,3,2003); 
    pvm.parse("12"); assertEquals("From: Pvm line: 227", "12.3.2003", pvm.toString()); 
    pvm.parse("..2001"); assertEquals("From: Pvm line: 228", "12.3.2001", pvm.toString()); 
    pvm.parse("..2009 14:30"); assertEquals("From: Pvm line: 229", "12.3.2009", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse244 */
  @Test
  public void testParse244() {    // Pvm: 244
    Pvm pvm = new Pvm(11,3,2003); 
    StringBuilder jono = new StringBuilder("12"); 
    pvm.parse(jono); assertEquals("From: Pvm line: 247", "12.3.2003", pvm.toString()); assertEquals("From: Pvm line: 247", "", jono.toString()); 
    jono = new StringBuilder("..2001"); 
    pvm.parse(jono); assertEquals("From: Pvm line: 249", "12.3.2001", pvm.toString()); assertEquals("From: Pvm line: 249", "", jono.toString()); 
    jono = new StringBuilder("..2009 14:30"); 
    pvm.parse(jono); assertEquals("From: Pvm line: 251", "12.3.2009", pvm.toString()); assertEquals("From: Pvm line: 251", "14:30", jono.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetPv264 */
  @Test
  public void testGetPv264() {    // Pvm: 264
    Pvm pv = new Pvm("14.2.2011"); 
    assertEquals("From: Pvm line: 266", 14, pv.getPv()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetKk277 */
  @Test
  public void testGetKk277() {    // Pvm: 277
    Pvm pv = new Pvm("14.2.2011"); 
    assertEquals("From: Pvm line: 279", 2, pv.getKk()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetVv290 */
  @Test
  public void testGetVv290() {    // Pvm: 290
    Pvm pv = new Pvm("14.2.2011"); 
    assertEquals("From: Pvm line: 292", 2011, pv.getVv()); 
  } // Generated by ComTest END
}