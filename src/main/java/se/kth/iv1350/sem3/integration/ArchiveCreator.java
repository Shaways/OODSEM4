
package se.kth.iv1350.sem3.integration;


public class ArchiveCreator {
    private ItemList itemList;
    private DiscountList discountList;
   
    
    /**
     * Makes and creates new instance.
     */
    public ArchiveCreator(){
        itemList = new ItemList();
        discountList = new DiscountList();
    }
    
     /**
     * A getter that retrieves the value that itemList holds.
     * @return  returns value of itemList.
     */
    public ItemList getItemList() {
        return itemList;
    }
    
     /**
     * Gets the number that is in discountList.
     *
     * @return  returns whatever discountList holds.
     */
    public DiscountList getListOfDiscount() {
        return discountList;
    }
    
    
}
