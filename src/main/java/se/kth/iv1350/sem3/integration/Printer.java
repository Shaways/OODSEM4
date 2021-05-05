package se.kth.iv1350.sem3.integration;

/**
 * A class that defines a printer.
 */
public class Printer {
     /**
     * Creates an instance, represented as a printer.
     */
    public Printer(){ 
    }
    
    /**
     *  Method prints the stated receipt, this is a made up printer.
     * instead of priting to a printer it prints with <code>System.out</code>.
     * 
     * @param receipt The receipt that will be printed.
     */
    
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
