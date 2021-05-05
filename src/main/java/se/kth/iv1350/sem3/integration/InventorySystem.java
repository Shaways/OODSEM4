
package se.kth.iv1350.sem3.integration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import se.kth.iv1350.sem3.model.Amount;
import se.kth.iv1350.sem3.model.Sale;

/**
 * A class that makes calls to an external inventory system.
 */
public class InventorySystem {
     private HashMap<String, Item> inventory = new HashMap();
     
     /**
     * Creates a new instance of a dummy inventory system.
     */
    InventorySystem(){
        addItems();
    }
    
     /**
     * Modifies the quantity of goods in inventory.
     *
     * @param sale Details about the sale, also includes details on the products.
     */
    public void updateInventory(Sale sale){
        HashMap<String, Item> products = sale.getItems();
        
        Set entries = products.entrySet();

        for (Object entry : entries) {
            Item item = getCurrentItem(entry);

            if (itemExistsInInventory(item)) {
                decreaseQuantityOfItem(item);
            }
        }
    }
    
      private Item getCurrentItem(Object entry){
        Map.Entry mapp = (Map.Entry) entry;
        return (Item) mapp.getValue();
    }
    private boolean itemExistsInInventory(Item item){
        return inventory.containsKey(item.getItemID());
    }
    
     private void decreaseQuantityOfItem(Item item){
        Item oldItem = inventory.get(item.getItemID());
        oldItem.decreasesQuantity(item.getItemQuantity());
        inventory.put(oldItem.getItemID(), oldItem);
    }
     
       private void addItems(){
        inventory.put("Mango", new Item(new ItemDTO(new Amount(20), "mango", new Amount(10)), "Mango", new Amount(Integer.MAX_VALUE)));
        inventory.put("Ananas", new Item(new ItemDTO(new Amount(30), "Ananas", new Amount(15)), "Ananas", new Amount(Integer.MAX_VALUE)));
        inventory.put("Salladslök", new Item(new ItemDTO(new Amount(42), "Salladslök", new Amount(20)), "Salladslök", new Amount(Integer.MAX_VALUE)));
        inventory.put("Ostron", new Item(new ItemDTO(new Amount(5), "Ostron", new Amount(2)), "Ostron", new Amount(Integer.MAX_VALUE)));
    }
      
    
}

