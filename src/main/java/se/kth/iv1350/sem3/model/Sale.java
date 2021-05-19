package se.kth.iv1350.sem3.model;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import se.kth.iv1350.sem3.integration.Item;

/**
 *
 * Makes one single sale made by one single customer and payed with one total payment.
 */
public class Sale {
    private Total total;
    private HashMap<String, Item> itemsToPurchase = new HashMap<>();
    
    
    /**
     * Makes new instance.
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
      /**
     * Changes the instance into to a <code>String</code>
     *
     * @return The instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getDescriptionOfItem().toString());
            addNewLine(builder, "Quantity: " + item.getItemQuantity().toString());
        }

        addNewLine(builder, "\nTOTAL: " + total.getTotal().toString());
        addNewLine(builder, "VAT: " + total.getTotalVAT());
        return builder.toString();
    }
    
    private Iterator getEntries(){
        Set entries = itemsToPurchase.entrySet();
        return entries.iterator();
    }
    
     private Item getCurrentItem(Iterator entryIterator){
        Map.Entry mapping = (Map.Entry) entryIterator.next();
        return (Item) mapping.getValue();
    }
     
     private void addNewLine(StringBuilder str, String line){
        str.append(line);
        str.append("\n");
    }
     
}
    
