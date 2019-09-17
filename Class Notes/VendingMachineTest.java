

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendingMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendingMachineTest
{
    /**
     * Default constructor for test class VendingMachineTest
     */
    public VendingMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testFillUp()
    {
        VendingMachine testVendingMachine = new VendingMachine(0);
        int addedCans = 5;
        testVendingMachine.fillUp(addedCans);
        int totalCans = testVendingMachine.getCanCount();
        assertEquals(5, totalCans);
    }
    
    @Test
    public void testInsertToken()
    {
        VendingMachine testVendingMachine = new VendingMachine(0);
        testVendingMachine.insertToken();
        testVendingMachine.insertToken();
        int tokenCount = testVendingMachine.getTokenCount();
        int canCount = testVendingMachine.getCanCount();
        assertEquals(2, tokenCount);
        assertEquals(-2, canCount);
    }
    
    @Test
    public void testDefaultConstructor()
    {
        VendingMachine testVendingMachine = new VendingMachine();
        int tokenCount = testVendingMachine.getTokenCount();
        int canCount = testVendingMachine.getCanCount();
        assertEquals(0, tokenCount);
        assertEquals(10, canCount);
    }
    
    @Test
    public void testCanConstructor()
    {
        VendingMachine testVendingMachine = new VendingMachine(7);
        int tokenCount = testVendingMachine.getTokenCount();
        int canCount = testVendingMachine.getCanCount();
        assertEquals(0, tokenCount);
        assertEquals(7, canCount);
    }
}
