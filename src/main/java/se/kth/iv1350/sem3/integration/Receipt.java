package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Sale;


public class Receipt {
    private Sale sale;
    
    /**
     * Creates a new instance, representing a receipt.
     *
     * @param sale The details shown on receipt.
     */
    public Receipt(Sale sale){
        this.sale = sale;
    }
}
