package se.kth.iv1350.sem3.integration;

/**
 * A singleton object that initiates the systems needed for the application,
 * accounting system and inventory system.
 */

public class SystemCreator {
    private static final SystemCreator SYSTEM_CREATOR = new SystemCreator();
    private AccountingSystem accountingSystem = new AccountingSystem();
    private InventorySystem inventorySystem = new InventorySystem();
    
    /**
     * Creates the system creator.
     */
    public SystemCreator(){
    }
    
    /**
     * Retrieves the instance of SystemCreator.
     * @return the SystemCreator.
     */
    public static SystemCreator getSystemCreator(){
        return SYSTEM_CREATOR;
    }
    
    
     /**
     * Getter that retrieves the value of inventorySystem.
     *
     * @return InventorySystem value.
     */
    
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
    
    /**
     * Getter that retrieves the value of accountingSystem.
     *
     * @return AccountingSystem value.
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }
    
}
