package se.kth.iv1350.sem4.integration;

/**
 * Is thrown when there is something wrong while performing operations in <code>ItemList</code>
 */

public class ItemListException extends RuntimeException {
  
     /**
     * A new instance is made that indicates the condition described in the specified message.
     *
     * @param msg A message that describes what went wrong.
     */
    
     public ItemListException(String msg){
        super(msg);
    }

}
    
