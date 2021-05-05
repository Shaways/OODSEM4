
package se.kth.iv1350.sem3.integration;

import java.time.LocalDateTime;
import java.util.HashMap;
import se.kth.iv1350.sem3.model.Sale;

/**
 * Defines an accounting system.
 */
public class AccountingSystem {
    private HashMap<LocalDateTime, Sale> accounting = new HashMap();
    
    /**
     *  A new instance is created that defines an accounting System.
     */
    AccountingSystem(){ }
    
    /**
     * Adds the sale to the book keeping,
     * also to the book keeping, it adds the period that the transaction was completed.
     *
     * @param sale The total and finished sale that will be put and 
     * registered in to book keeping.
     */
    public void bookKeep(Sale sale){
        LocalDateTime timeOfSale = LocalDateTime.now();
        accounting.put(timeOfSale, sale);
    }
}
