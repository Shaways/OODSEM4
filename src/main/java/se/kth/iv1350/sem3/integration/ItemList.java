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
     * @return One item with it's description and quantity amount.
     * @throws ItemNotFoundException when item ID is not available in database.
     */
    public Item getItem(String itemID, Amount itemQuantity)throws ItemNotFoundException, ItemListException{
        if (!itemAvailable(itemID)){
            throw new ItemNotFoundException(itemID);
        }
       Item newItem = new Item(itemList.get(itemID), itemID, itemQuantity);
        if (newItem.getItemID() != itemID){
            throw new ItemListException("The wrong item from database has been recieved");
        }
        if (newItem.getItemID() == "FAILURE"){
            throw new ItemListException("The wrong item from database has been recieved");
        }
        return newItem;
    }
    
    
    private void addItem(){
        itemList.put("Mango", new ItemDTO(new Amount(11), "Mango", new Amount(10)));
        itemList.put("Sallad", new ItemDTO(new Amount(12), "Sallad", new Amount(15)));
        itemList.put("Ananas", new ItemDTO(new Amount(23), "Ananas", new Amount(20)));
        itemList.put("Ostron", new ItemDTO(new Amount(2), "Ostron", new Amount(2)));
        itemList.put("FAILURE", new ItemDTO(new Amount(0), "FAILURE", new Amount(0)));            
    }
    
}
