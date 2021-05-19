package se.kth.iv1350.sem3.model;

/**
 * Listener interface for getting the total when a payment is made.
 * Classes that wants to get such notifications implements this interface.
 * 
 * In order to register the class it's needed to call {@link controller.Controller#addPaymentObserver(PaymentObserver)}
 * A payment is made, that object's {@link #updateTotal(Total)} method is invoked.
 */

public interface PaymentObserver {
     /**
     * Called when a payment is made.
     * @param total the total of the made payment.
     */
    void updateTotal(Total total);
}
