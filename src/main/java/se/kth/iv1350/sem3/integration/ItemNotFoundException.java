package se.kth.iv1350.sem3.integration;

/**
 * Thrown when the search for an item in the inventorysystem fails to return the searched item.
 * 
 */
public class ItemNotFoundException extends Exception {
    String itemID;
    /**
     * Makes a new instance of the exception with a descriptive message
     * @param itemID - The item identifier that could not be found.
     */
    public  ItemNotFoundException (String itemID){
        super("Item with ID: " + itemID + " not found. User must enter a VALID ID or item needs to be added to archive.");
        this.itemID = itemID;
    }
 
    public String getItemIdentiferThatDoesntExist(){
        return itemID;
    }
    
  
}
