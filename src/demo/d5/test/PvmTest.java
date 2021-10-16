package demo.d5.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import demo.d5.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.09 17:10:38 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class PvmTest {



  // Generated by ComTest BEGIN
  /** testToString83 */
  @Test
  public void testToString83() {    // Pvm: 83
    Pvm pvm = new Pvm(10,2,2008); 
    assertEquals("From: Pvm line: 85", "10.2.2008", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse98 */
  @Test
  public void testParse98() {    // Pvm: 98
    Pvm pvm = new Pvm(); 
    pvm.parse("11.05.02"); assertEquals("From: Pvm line: 100", "11.5.2002", pvm.toString()); 
    pvm.parse("11.05.97"); assertEquals("From: Pvm line: 101", "11.5.1997", pvm.toString()); 
    pvm.parse("17.3"); assertEquals("From: Pvm line: 102", "17.3.1997", pvm.toString()); 
    pvm.parse("19"); assertEquals("From: Pvm line: 103", "19.3.1997", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetPaiva118 */
  @Test
  public void testGetPaiva118() {    // Pvm: 118
    Pvm maalis97 = new Pvm(1, 3, 97); 
    assertEquals("From: Pvm line: 120", 1, maalis97.getPaiva()); 
  } // Generated by ComTest END
}