/**
 * A class that models a vending machine which can exchange tokens for cans of soda. Cans of soda can be added to the vending machine.
 * @author ztan
 * @version 17 Sept 2019
 */
public class VendingMachine
{
    /*
     * Methods to add:
     * Insert token: adds 1 token to the vending machine and drops a can
     * Add cans: adds specified # of cans to vending machine
     * Get tokens: returns # of tokens in vending machine
     * Get cans: returns # of tokens in vending machihne
     */
    
    private int tokensInMachine;
    private int cansInMachine;
    
    /**
     * Default constructor for the VendingMachine class.
     * Initializes tokens in the machine to 0 and cans in the machine to 10.
     */
    
    public VendingMachine()
    {
        this.tokensInMachine = 0;
        this.cansInMachine = 10;
    }
    
    /**
     * Creates a new vending machine with a specified amount of tokens and cans in the machine.
     */
    
    public VendingMachine(int cans)
    {
        this.cansInMachine = cans;
    }
    
    /**
     * Adds a specified number of cans to the vending machine
     * @param cans The number of cans to be added to the machine
     */
    public void fillUp(int cans)
    {
        this.cansInMachine = this.cansInMachine + cans;
    }
    
    /**
     * Inserts one token into the vending machine in exchange for one can of soda.
     */
    public void insertToken()
    {
        this.tokensInMachine++;
        this.cansInMachine--;
        
    }
    
    /**
     * Returns the number of tokens in the vending machine.
     */
    public int getTokenCount()
    {
        return this.tokensInMachine;
    }
    
    /**
     * Returns the number of cans of soda in the vending machine.
     */
    public int getCanCount()
    {
        return this.cansInMachine;
    }
    
}