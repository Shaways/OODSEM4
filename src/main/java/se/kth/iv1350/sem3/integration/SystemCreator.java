package se.kth.iv1350.sem3.integration;


public class SystemCreator {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
     
    /**
     * Creates the system creator.
     */
    public SystemCreator(){
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        
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
