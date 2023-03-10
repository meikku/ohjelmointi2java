package demo.d5.test;
// Generated by ComTest BEGIN
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;
import demo.d5.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.10.08 14:26:20 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class HenkiloTest {



  // Generated by ComTest BEGIN
  /** testHenkilo31 */
  @Test
  public void testHenkilo31() {    // Henkilo: 31
    Henkilo sipe = new Henkilo(); 
    assertEquals("From: Henkilo line: 33", "", sipe.getNimi()); 
    assertEquals("From: Henkilo line: 34", "||0", sipe.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testHenkilo45 */
  @Test
  public void testHenkilo45() {    // Henkilo: 45
    Henkilo katri = new Henkilo("katri|helena|1923"); 
    assertEquals("From: Henkilo line: 47", "katri helena", katri.getNimi()); 
    assertEquals("From: Henkilo line: 48", "katri|helena|1923", katri.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse58 */
  @Test
  public void testParse58() {    // Henkilo: 58
    Henkilo hlo = new Henkilo(); 
    hlo.parse("Sirkka|Liisa|1967"); assertEquals("From: Henkilo line: 60", "Sirkka|Liisa|1967", hlo.toString()); 
    hlo.parse("Sirkka||1967"); assertEquals("From: Henkilo line: 61", "Sirkka||1967", hlo.toString()); 
    hlo.parse("Sirkka|Liisa|"); assertEquals("From: Henkilo line: 62", "Sirkka|Liisa|0", hlo.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testToString76 */
  @Test
  public void testToString76() {    // Henkilo: 76
    Henkilo aku = new Henkilo("Aku","Ankka",1934); 
    assertEquals("From: Henkilo line: 78", "Aku|Ankka|1934", aku.toString()); 
    Henkilo pele = new Henkilo("Pele","",1940); 
    assertEquals("From: Henkilo line: 80", "Pele||1940", pele.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetNimi93 */
  @Test
  public void testGetNimi93() {    // Henkilo: 93
    Henkilo aku = new Henkilo("Aku","Ankka",1934); 
    assertEquals("From: Henkilo line: 95", "Aku Ankka", aku.getNimi()); 
    Henkilo pele = new Henkilo("Pele","",1940); 
    assertEquals("From: Henkilo line: 97", "Pele", pele.getNimi()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetSyntymavuosi108 */
  @Test
  public void testGetSyntymavuosi108() {    // Henkilo: 108
    Henkilo aku = new Henkilo("Aku","Ankka",1934); 
    assertEquals("From: Henkilo line: 110", 1934, aku.getSyntymavuosi()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testTulosta122 */
  @Test
  public void testTulosta122() {    // Henkilo: 122
    ByteArrayOutputStream byteoutput = new ByteArrayOutputStream(); 
    Henkilo hlo = new Henkilo("Aku","Ankka",1934); 
    hlo.tulosta(byteoutput); 
    { String _l_=byteoutput.toString(),_r_="Aku Ankka 1934\\s*"; if ( !_l_.matches(_r_) ) fail("From: Henkilo line: 127" + " does not match: ["+ _l_ + "] != [" + _r_ + "]");}
  } // Generated by ComTest END
}