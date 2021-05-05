package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Amount;


public class ItemDTO {
    private final String itemTitle;
    private final Amount VATrate;
    private final Amount price;
    
    public ItemDTO (Amount price,String itemTitle, Amount VATrate){
        this.itemTitle = itemTitle;
        this.VATrate = VATrate;
        this.price = price;
    }
    
      /**
     * Getter for the title of itemTitle.
     *
     * @return String value of itemTitle.
     */
    public String getItemTitle() {
        return itemTitle;
    }
    /**
     * Gets the number of the price.
     *
     * @return the integer number that price is from reference Amount.
     */
    
    public Amount getPrice() {
        return price;
    }
    
     /**
     * Getter for the  value of VATrate.
     *
     * @return the double number of VATrate.
     */
    public Amount getVATrate() {
        return VATrate;
    }
    
    
    @Override
    public String toString() {
        String string = "Item title: " + itemTitle + "\n" +
                "price: " + price + "\n" +
                "tax amount: " + VATrate + "\n";
        return string;
    }
}

