package se.kth.iv1350.sem4.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  A payment for a particular sale is represented by this class.
 */

public class Payment {
    private Total total;
    private Amount amountPaid;
    private List<PaymentObserver> paymentObservers = new ArrayList();
    
    /**
     * Makes a new instance defined as payment.
     *
     * @param amountPaid The amount of money the customer has handed to the cashier.
     * @param total The total that should be payed for by the customer.
     */
    public Payment(Amount amountPaid, Total total){
        this.amountPaid = amountPaid;
        this.total = total;
    }
    
    private void notifyObservers(){
        for (PaymentObserver obs : paymentObservers) {
            obs.updateTotal(total);
        }
    }
    
    /**
     * The specified observers will be notified when a payment is made.
     * @param observers The observers to notify.
     */
    public void addPaymentObservers(List<PaymentObserver> observers) {
        paymentObservers.addAll(observers);
    }
    
    Total getTotal() {
        return total;
    }
    
     /**
     * Calculates  and retrieves the change.
     *
     * @return The total change where the amountPaid has been deducted with VAT.
     */
    public Amount getChange(){
        notifyObservers();
        return amountPaid.minus(total.getTotalTogetherWithVAT());
    }


}
