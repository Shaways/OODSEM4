package se.kth.iv1350.sem4.integration;

import java.util.Objects;
import se.kth.iv1350.sem4.model.Amount;


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
        String string = "\nItem title: " + itemTitle + "\t" +
                "Price: " + price + "\t" +
                "VAT amount: " + VATrate + "\n";
        return string;
    }
    /**
     * Two <code>ItemDTO</code> instances are equal if all fields are equal.
     *
     * @param obj The <code>ItemDTO</code> to compare with this <code>ItemDTO</code>.
     * @return <code>true</code> if all fields in the specified <code>ItemDTO</code> are equal to
     *         corresponding fields in this <code>ItemDTO</code>, <code>false</code> if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ItemDTO other = (ItemDTO) obj;
        if (!Objects.equals(this.price, other.price)){
            return false;
        }
        if (!this.itemTitle.equals(other.itemTitle)){
            return false;
        }
        if (!Objects.equals(this.VATrate, other.VATrate)){
            return false;
        }
        return true;
    }
}

