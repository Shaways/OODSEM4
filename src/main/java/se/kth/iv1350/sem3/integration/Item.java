package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Amount;


public class Item {
    private Amount itemQuantity;
    private ItemDTO itemDescription;
    private String itemID;
    
    /**
     * Makes a new instance that is represented as Item.
     * 
     * @param itemQuantity The quantity of Items.
     * @param itemDescription Info about Item.
     * @param itemID ID of Item.
     * 
     */
    
    public Item (ItemDTO itemDescription, String itemID, Amount itemQuantity) {
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
        this.itemID = itemID;
    }
   
     /**
     * The amount of items is increased.
     *
     * @param addedQuantity How much is added to the current quantity.
     */
    public void increaseQuantity(Amount addedQuantity){
        this.itemQuantity = this.itemQuantity.plus(addedQuantity);
        
    }
    
    /**
     * The amount of items is decreased.
     *
     * @param addedQuantity  will be subtracted from the amount of quantity.
     */
    public void decreasesQuantity(Amount addedQuantity){
        this.itemQuantity = this.itemQuantity.minus(addedQuantity);
    }
    
  
    public Amount getItemQuantity() {
        return itemQuantity;
    }
    
    public ItemDTO getDescriptionOfItem() {
        return itemDescription;
    }
    
    public String getItemID() {
        return itemID;
    }
    
    @Override
    public String toString() {
        String string = ("Item ID: " + itemID) +
                ("Item quantity: " + itemQuantity.toString()) +
                ("Item description: " + itemDescription.toString());
        return string;
    }
    /**
     * Two item instances are equal if all fields are equal exclusive the quantity.
     *
     * @param obj Is the item to compare with this item.
     * @return <code>true</code> if all fields in the specified <code>Item</code> are equal to
     *         corresponding fields in this <code>Item</code> except quantity, <code>false</code> if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Item other = (Item) obj;
        if (!this.itemDescription.equals(other.itemDescription)){
            return false;
        }
        if (!this.itemID.equals(other.itemID)){
            return false;
        }
        return true;

    }
}
