package se.kth.iv1350.sem3.model;

import java.time.LocalTime;
import java.util.HashMap;
import se.kth.iv1350.sem3.integration.Item;

/**
 *
 * Makes one single sale made by one single customer and payed with one total payment.
 */
public class Sale {
    private HashMap<String, Item> itemsToPurchase = new HashMap<>();
    private Total total;
    
    
    /**
     * Creates new instance.
     */
    public Sale() {
        total = new Total();
    }
   
    
    /**
     * Gets items from the HashMap.
     *
     * @return The items from the HashMap.
     */
    public HashMap<String, Item> getItems(){
        return itemsToPurchase;
    }
    
    public Total getTotal(){
        return total;
    }
    
    /**
     * The sale that is currently ongoing is updated. It will Update the quantity items and the total cost.
     * Will not be possible to take in items that are null with nothing in it.
     *
     * @param item Is an item (as an object) that is added to the process of sale.
     * @return itemDescription as a string.
     */
    
    public String updateCurrentSale(Item item){
        if (listOfItemsContains(item)) {
            ItemTotalAndAmountUpdate(item);
        } else {
            addItemsThenUpdateTotal(item);
        }
        return item.getDescriptionOfItem().toString();
    }
    
    private void addItemsThenUpdateTotal(Item item){
        itemsToPurchase.put(item.getItemID(), item);
        total.calculateTotal(item);
    } 
    private boolean listOfItemsContains(Item item){
        return itemsToPurchase.containsKey(item.getItemID());
    }
    
     private void ItemTotalAndAmountUpdate(Item item){
        Item olderItems = itemsToPurchase.get(item.getItemID());
        olderItems.increaseQuantity(item.getItemQuantity());
        itemsToPurchase.put(olderItems.getItemID(), olderItems);
        total.calculateTotal(item);
    }
     
}
    
