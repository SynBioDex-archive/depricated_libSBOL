/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOL;


import org.biojavax.bio.seq.RichSequence;
import org.biojavax.SimpleNamespace;
import java.io.BufferedReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgaldzic
 */
public class PartTest {

private Part tp;
private RichSequence rs;
    public PartTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        // input for test
        String testfileString = "B0015.ape";
        //stuff needed for Rich Sequence intialization a precondition of this test
        BufferedReader br = null;
        SimpleNamespace ns = null;
        ns = new SimpleNamespace("bioJavaNS");
        rs = SBOLutils.readinGBfile(testfileString);
        //A Test Part
        tp = new Part(); //test part
        //tp.setUri("http://sbolstandard.org/sbpkb/B0015");
        //tp.setId("B0015");
        tp.setName("B0015");
        tp.setShortDescription("B0015");
        tp.setLongDescription("Very popular transcriptional terminator");
        //tp.setDate("11-Aug-2009");
        tp.setAuthor("");
        tp.setType("terminator");
        tp.setNickname("B0015");
        tp.setDnaSequence("ccaggcatcaaataaaacgaaaggctcagtcgaaagactgggcctttcgttttatctgttgtttgtcggtgaacgctctctactagagtcacactggctcaccttcgggtgggcctttctgcgtttata");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readRichSequence method, of class Part.
     * This test doesn't do anything particularly useful because the Part p.equals() method is weak
     */
    @Test
    public void testReadRichSequence() {
        System.out.println("readRichSequence");
        Part instance = new Part();
        instance.readRichSequence(rs);
        Part result = instance;

        Part expResult = tp;
                
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

/**    @Test
    public void testGetAnnotation() {
        System.out.println("getAnnotation");
        Part instance = new Part();
        Part expResult = tp;
        List result = instance.getAnnotation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testSetAnnotation() {
        System.out.println("setAnnotation");
        List newannotation = null;
        Part instance = new Part();
        instance.setAnnotation(newannotation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddAnnotation() {
        System.out.println("addAnnotation");
        SequenceAnnotation newannotation = null;
        Part instance = new Part();
        instance.addAnnotation(newannotation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Part instance = new Part();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Part instance = new Part();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDnaSequence() {
        System.out.println("getDnaSequence");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getDnaSequence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDnaSequence() {
        System.out.println("setDnaSequence");
        String dnaSequence = "";
        Part instance = new Part();
        instance.setDnaSequence(dnaSequence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Part instance = new Part();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLongDescription() {
        System.out.println("getLongDescription");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getLongDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLongDescription() {
        System.out.println("setLongDescription");
        String longDescription = "";
        Part instance = new Part();
        instance.setLongDescription(longDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Part instance = new Part();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNickname() {
        System.out.println("setNickname");
        String nickname = "";
        Part instance = new Part();
        instance.setNickname(nickname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOwner_id() {
        System.out.println("getOwner_id");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getOwner_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOwner_id() {
        System.out.println("setOwner_id");
        String owner_id = "";
        Part instance = new Part();
        instance.setOwner_id(owner_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPrincipal_investigator() {
        System.out.println("getPrincipal_investigator");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getPrincipal_investigator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPrincipal_investigator() {
        System.out.println("setPrincipal_investigator");
        String principal_investigator = "";
        Part instance = new Part();
        instance.setPrincipal_investigator(principal_investigator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetShortDescription() {
        System.out.println("getShortDescription");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getShortDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetShortDescription() {
        System.out.println("setShortDescription");
        String shortDescription = "";
        Part instance = new Part();
        instance.setShortDescription(shortDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Part instance = new Part();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetSubClassOf() {
        System.out.println("getSubClassOf");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getSubClassOf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetSubClassOf() {
        System.out.println("setSubClassOf");
        String subClassOf = "";
        Part instance = new Part();
        instance.setSubClassOf(subClassOf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetType() {
        System.out.println("getType");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Part instance = new Part();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUri() {
        System.out.println("getUri");
        Part instance = new Part();
        String expResult = "";
        String result = instance.getUri();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUri() {
        System.out.println("setUri");
        String uri = "";
        Part instance = new Part();
        instance.setUri(uri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 **/
}
