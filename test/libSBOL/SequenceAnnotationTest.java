/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

import java.util.List;
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
public class SequenceAnnotationTest {

    public SequenceAnnotationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFeature method, of class SequenceAnnotation.
     */
    @Test
    public void testGetFeature() {
        System.out.println("getFeature");
        SequenceAnnotation instance = new SequenceAnnotation();
        List expResult = null;
        List result = instance.getFeature();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFeature method, of class SequenceAnnotation.
     */
    @Test
    public void testSetFeature() {
        System.out.println("setFeature");
        List<SequenceFeature> feature = null;
        SequenceAnnotation instance = new SequenceAnnotation();
        instance.setFeature(feature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class SequenceAnnotation.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        SequenceAnnotation instance = new SequenceAnnotation();
        String expResult = "";
        String result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class SequenceAnnotation.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        String start = "";
        SequenceAnnotation instance = new SequenceAnnotation();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStop method, of class SequenceAnnotation.
     */
    @Test
    public void testGetStop() {
        System.out.println("getStop");
        SequenceAnnotation instance = new SequenceAnnotation();
        String expResult = "";
        String result = instance.getStop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStop method, of class SequenceAnnotation.
     */
    @Test
    public void testSetStop() {
        System.out.println("setStop");
        String stop = "";
        SequenceAnnotation instance = new SequenceAnnotation();
        instance.setStop(stop);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrand method, of class SequenceAnnotation.
     */
    @Test
    public void testGetStrand() {
        System.out.println("getStrand");
        SequenceAnnotation instance = new SequenceAnnotation();
        String expResult = "";
        String result = instance.getStrand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrand method, of class SequenceAnnotation.
     */
    @Test
    public void testSetStrand() {
        System.out.println("setStrand");
        String strand = "";
        SequenceAnnotation instance = new SequenceAnnotation();
        instance.setStrand(strand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}