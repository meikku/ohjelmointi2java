package demo.d6.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d6.TaulukonKasittely.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.17 10:27:52 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaulukonKasittelyTest {



  // Generated by ComTest BEGIN
  /** testPienin18 */
  @Test
  public void testPienin18() {    // TaulukonKasittely: 18
    int kPituudet[] =  { 31,28,31,30,31,30,31,31,30,31,30,31} ; 
    assertEquals("From: TaulukonKasittely line: 20", 28, pienin(1, kPituudet)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testPienimmanPaikka34 */
  @Test
  public void testPienimmanPaikka34() {    // TaulukonKasittely: 34
    int kPituudet[] =  { 31,28,31,30,31,30,31,31,30,31,30,31} ; 
    assertEquals("From: TaulukonKasittely line: 36", 1, pienimmanPaikka(kPituudet)); 
  } // Generated by ComTest END
}