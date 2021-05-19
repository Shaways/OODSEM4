package se.kth.iv1350.sem4.model;

/**
 * A class that defines a discount with specific rules.
 */

public class DiscountRules {
    private final double NO_DISCOUNT = 0.0;
    private double discountAmount;
    

     /**
     * Creates a new instance, representing a discount rule.
     *
     * @param discountAmount A discount rate defined by the created instance.
     */
    public DiscountRules(double discountAmount){
        this.discountAmount = discountAmount;
    }
     /**
     *  Creates a new instance, representing the discount amount of 0.0.
     */
    public DiscountRules(){
        this.discountAmount = NO_DISCOUNT;
    }

     /**
     * Retrieves the value of discountAmount.
     *
     * @return The value of discountAmount.
     */
    public double getDiscountAmount() {
        return discountAmount;
    }
    
}
