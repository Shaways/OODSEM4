package se.kth.iv1350.sem4.model;

import java.util.Objects;

/**
 * A class that defines the amount of money or items.
 */
public class Amount {
    private final double amount;
    
    /**
     * Amount makes an instance, that will be the specified amount.
     *
     * @param amount Amount of the instance that is created.
     */
    public Amount(double amount){
        this.amount = amount;
    }

    /**
     * Getter to recieve the value that amount holds.
     *
     * @return  Value of amount.
     */
    
    public double getAmount() {
        return amount;
    }
   
     /**
     * Adds the stated amount.
     *
     * @param otherAmount Is the specified amount.
     * @return Sum of this amount with 
     * the other amount.
     */
    
    public Amount plus(Amount otherAmount){
        Amount plus = new Amount(this.amount + otherAmount.amount);
        return plus;
    }
    /**
     * Takes the specified specified amount and subtracts.
     *
     * @param otherAmount Is the specified amount.
     * @return Difference between this amount and the 
     * other Amount.
     */
    public Amount minus(Amount otherAmount){
        Amount minus = new Amount(this.amount - otherAmount.amount);
        return minus;
    }
    /**
     * Will multiply with the stated amount.
     *
     * @param otherAmount The stated amount.
     * @return Product of this amount and
     * the other amount.
     */
    public Amount multiply(Amount otherAmount){ 
        Amount multiply = new Amount(this.amount * otherAmount.amount);
        return multiply;
    }
    
      /**
     * Changes amount to a string object.
     *
     * @return <code>Amount</code> becomes a <code>String</code> from 
     * being a double.
     */
    @Override
    public String toString() {
        return Double.toString(amount);
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        if (getClass() != object.getClass()){
            return false;
        }
        final Amount other = (Amount) object;
        if (!Objects.equals(this.amount, other.amount)){
            return false;
        }
        return true;
    }

}
