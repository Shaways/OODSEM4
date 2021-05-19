package se.kth.iv1350.sem4.model;
/**
 * Represents the (made up) cash register.
 */
public class CashRegister {
    private Amount balance;
    
     /**
     * Creates a new cashregister instance with a zero balance.
     */
    public CashRegister(){
        this.balance = new Amount(0);
    }
    
    /**
     * Balance is updated together with the stated payment.
     *
     * @param payment The money that will be credited to the cash register's balance.
     */
    
    public void addPayment(Payment payment){
        balance = balance.plus(payment.getTotal().getTotalTogetherWithVAT());
    }
    
    /**
     * Getter that retrieves the value of balance.
     *
     * @return The value of balance.
     */
    public Amount getBalance() {
        return balance;
    }
}
