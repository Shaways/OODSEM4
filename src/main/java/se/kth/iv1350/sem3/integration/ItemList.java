package se.kth.iv1350.sem3.integration;

import java.util.HashMap;
import se.kth.iv1350.sem3.model.Amount;

/**
 * A class that is representing a database
 * 
 */
public class ItemList {
    private HashMap<String, ItemDTO> itemList = new HashMap<>();
    
    /**
     *  Method that creates an instance of an item index database.
     */
    public ItemList(){
        addItem();
    }
    
     /**
     *  Checks if the itemID you're looking for is in the index.
     *
     * @param itemID The item that is looked for.
     * @return If item is there <code>true</code> else <code>false</code>
     */
    public boolean itemAvailable(String itemID){
        return itemList.containsKey(itemID);
    }
    
    /**
     * A getter for getting the item overview of the itemID put in parameter
     * tothether with the quantity amount.
     *
     * @param itemID The iD of an item.
     * @param itemQuantity The item quantity.
     * @return One item with it's description and quantity amount, or null if the id is not there.
     */
    public Item getItem(String itemID, Amount itemQuantity){
        if (itemAvailable(itemID)){
            return new Item(itemList.get(itemID),itemID, itemQuantity);
        }
        return null;
    }
    
    private void addItem(){
        itemList.put("Gurka", new ItemDTO(new Amount(20), "Gurka", new Amount(10)));
        itemList.put("Hammer", new ItemDTO(new Amount(30), "Hammer", new Amount(15)));
        itemList.put("Mango", new ItemDTO(new Amount(42), "Mango", new Amount(20)));
        itemList.put("Sausage", new ItemDTO(new Amount(5), "Sausage", new Amount(2)));
    }
    
}
