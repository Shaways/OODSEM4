package se.kth.iv1350.sem4.model;

import se.kth.iv1350.sem4.integration.Item;

/**
 *
 * Shows what the payment is. The total cost together with the assigned VAT.
 */
public class Total {
    private Amount total;
    private Amount totalVAT;
    
    public Total(){
        this.total = new Amount(0);
        this.totalVAT = new Amount(0);
    }
  
     /**
     * Getter that takes the value of what total VAT is. 
     *
     * @return the value of that the totalVAT is.
     */
    public Amount getTotalVAT() {
        return totalVAT;
    }
    
     /**
     * Getter that takes the value of what total is.
     *
     * @return The value of what total is.
     */
    
    public Amount getTotal() {
        return total;
    }
    
     /**
     *  Combines the total with the VAT and returns it as 
     *  reference type Amount.
     *
     * @return The total together with VAT.
     */
    public Amount getTotalTogetherWithVAT(){
        return total.plus(totalVAT);
    }
    
    
    /**
     *  Basically lets out total and the totalVAT get updated together 
     *  by adding the item price to the total, 
     *  and the items VAT to the total VAT.Basically then Lets our total and totalVAT to be updated with current value.
     *
     * @param item The item object in which will will be added to total, 
     * it also has information about how many items there are, the VAT and the price. 
     * Return serves as an immidiate termination point for the method.
     */
    
    public void calculateTotal(Item item){
        if(item == null){
            return;
        }
        Amount VATforItem = item.getDescriptionOfItem().getVATrate();
        Amount itemQuantity = item.getItemQuantity();
        Amount itemPrice = item.getDescriptionOfItem().getPrice();
     
        this.totalVAT = this.totalVAT.plus(itemQuantity.multiply(VATforItem));
        this.total = this.total.plus(itemQuantity.multiply(itemPrice));
    }
    
    /**
     * Updates the total and the totalTax. By adding it with another total.
     *
     * @param total The total that will be added to this total.
     */
    public void updateTotal(Total total){
        this.total = this.total.plus(total.getTotal());
        this.totalVAT = this.totalVAT.plus(total.getTotalVAT());
    }
}
