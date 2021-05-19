package se.kth.iv1350.sem4.integration;

import java.time.LocalDateTime;
import java.util.HashMap;
import se.kth.iv1350.sem4.model.Sale;

/**
 * Represents an external made up accounting system
 */
public class AccountingSystem {
    private HashMap<LocalDateTime, Sale> accounting = new HashMap();

    /**
     *  A new instance is made, representing a made up accounting system.
     */
    AccountingSystem(){ }

    /**
     *  The sale is added to the book keeping. The date/time when the sale was done to the book keeping is also added.
     *
     * @param sale The finished sale that will be added to the book keeping.
     */
    public void bookKeeping(Sale sale){
        LocalDateTime saleTime = LocalDateTime.now();
        accounting.put(saleTime, sale);
    }
}