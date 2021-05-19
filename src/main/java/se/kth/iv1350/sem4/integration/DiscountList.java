package se.kth.iv1350.sem4.integration;

import java.util.HashMap;
import se.kth.iv1350.sem4.model.CustomerID;
import se.kth.iv1350.sem4.model.DiscountRules;


public class DiscountList {
    private HashMap<CustomerID, DiscountRules> ListOfDiscounts = new HashMap<>();
    private final double NO_DISCOUNT = 2.0;
    
    
    
    /**
     *  Creates a new instance with a discount database as its representation.
     */
    DiscountList(){
        addCustomerAndTheirDiscounts();
    }
    
  /**
     * Method goes and checks if the customer is eligeble for a discount.
     *
     * @param ID The identification of the customer.
     * @return Whether the customer is included in the record, 
     * the discount is returned; if it is not, NO DISCOUNT is returned,
     * indicating that the customer does not have a discount.
     */ 
    public DiscountRules discountRequest(CustomerID ID){

        if (ListOfDiscounts.containsKey(ID)){
            return ListOfDiscounts.get(ID);
        }
        return new DiscountRules(NO_DISCOUNT);
    }

 private void addCustomerAndTheirDiscounts(){
        ListOfDiscounts.put(new CustomerID("7304032345"), new DiscountRules(0.2));
        ListOfDiscounts.put(new CustomerID("0104023342"), new DiscountRules(0.3));
    }
}
