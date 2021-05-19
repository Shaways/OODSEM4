package se.kth.iv1350.sem3.model;

import java.time.LocalDateTime;


public class Receipt {
    private Sale sale;
    
    /**
     * Makes a new instance, defining a receipt.
     *
     * @param sale The details shown on receipt.
     */
    public Receipt(Sale sale){
        this.sale = sale;
    }
    
     /**
     * Makes the instance into a <code>String</code>
     *
     * @return Tbe instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        addNewLine(str);
        appendLine(str, "----------RECEIPT----------");
        addLocalDate(str);
        appendLine(str, "           \n -ITEMS- ");
        appendLine(str, sale.toString());
        appendLine(str, "------------END------------");
        return str.toString();
    }
    
    private void addNewLine(StringBuilder str){
        str.append("\n");
    }
    
    private void appendLine(StringBuilder str, String line){
        str.append(line);
        addNewLine(str);
    }
    
     private void addLocalDate(StringBuilder str){
        LocalDateTime dateOfSale = LocalDateTime.now();
        appendLine(str, "Sale date: " + dateOfSale.toLocalDate().toString());
    }
}
