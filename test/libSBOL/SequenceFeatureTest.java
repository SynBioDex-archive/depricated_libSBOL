/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOL;

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
public class SequenceFeatureTest {

    public SequenceFeatureTest() {
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
     * Test of getType method, of class SequenceFeature.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        SequenceFeature instance = new SequenceFeature();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class SequenceFeature.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String Type = "";
        SequenceFeature instance = new SequenceFeature();
        instance.setType(Type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class SequenceFeature.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SequenceFeature instance = new SequenceFeature();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class SequenceFeature.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        SequenceFeature instance = new SequenceFeature();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortDescription method, of class SequenceFeature.
     */
    @Test
    public void testGetShortDescription() {
        System.out.println("getShortDescription");
        SequenceFeature instance = new SequenceFeature();
        String expResult = "";
        String result = instance.getShortDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShortDescription method, of class SequenceFeature.
     */
    @Test
    public void testSetShortDescription() {
        System.out.println("setShortDescription");
        String shortDescription = "";
        SequenceFeature instance = new SequenceFeature();
        instance.setShortDescription(shortDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}