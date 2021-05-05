package se.kth.iv1350.sem3.model;

/**
 *  A payment for a particular sale is represented by this class.
 */

public class Payment {
    private Total total;
    private Amount amountPaid;
    
    /**
     * Creates a new instance defined as payment.
     *
     * @param amountPaid The amount of money the customer have handed to cashier.
     * @param total The total that should be payed for by the customer.
     */
    public Payment(Amount amountPaid, Total total){
        this.amountPaid = amountPaid;
        this.total = total;
    }
    
    /**
     * Retrieves the total cost to pay.
     *
     * @return Total cost.
     */
    
    Total getTotal() {
        return total;
    }
    
     /**
     *  Calculates  and retrieves the change.
     *
     * @return The total change where the amountPaid has been deducted with VAT.
     */
    public Amount getChange(){
        return amountPaid.minus(total.getTotalTogetherWithVAT());
    }


}
