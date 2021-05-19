package se.kth.iv1350.sem4.integration;

import se.kth.iv1350.sem4.model.Receipt;

/**
 * A class that defines a printer.
 */
public class Printer {
     private static final Printer PRINTER = new Printer();
     /**
     * Creates an instance, represented as a printer.
     */
    public Printer(){ 
    }
    
     /**
     * Retrieves instance of <code>Printer</code>, which is a singleton.
     * @return The <code>Printer</code>
     */
    public static Printer getPrinter(){
        return PRINTER;
    }
    /**
     * Method prints the stated receipt, this is a made up printer.
     * instead of priting to a printer it prints with <code>System.out</code>.
     * 
     * @param receipt The receipt that will be printed.
     */
    
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
