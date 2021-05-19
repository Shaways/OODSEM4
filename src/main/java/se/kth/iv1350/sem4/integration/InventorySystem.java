package se.kth.iv1350.sem4.integration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import se.kth.iv1350.sem4.model.Amount;
import se.kth.iv1350.sem4.model.Sale;

/**
 * A class that is made up and makes calls to an external inventory system.
 */
public class InventorySystem {
     private HashMap<String, Item> inventory = new HashMap();
     
     /**
     * Makes a new instance of a made up inventory system.
     */
    InventorySystem(){
        addItem();
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
     
       private void addItem(){
        inventory.put("Mango", new Item(new ItemDTO(new Amount(11), "Mango", new Amount(5)), "Mango", new Amount(Integer.MAX_VALUE)));
        inventory.put("Ananas", new Item(new ItemDTO(new Amount(12), "Ananas", new Amount(6)), "Ananas", new Amount(Integer.MAX_VALUE)));
        inventory.put("Sallad", new Item(new ItemDTO(new Amount(23), "Sallad", new Amount(11)), "Sallad", new Amount(Integer.MAX_VALUE)));
        inventory.put("Ostron", new Item(new ItemDTO(new Amount(2), "Ostron", new Amount(1)), "Ostron", new Amount(Integer.MAX_VALUE)));
        
       
    }
      
    
}

