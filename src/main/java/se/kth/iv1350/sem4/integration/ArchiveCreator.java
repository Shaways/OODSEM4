package se.kth.iv1350.sem4.integration;

/**
 * A creator that consists of an archive of archives.
 * Note that it is made as a singleton.
 */

public class ArchiveCreator {
    private static final ArchiveCreator ARCHIVE_CREATOR = new ArchiveCreator();
    private ItemList itemList = new ItemList();
    private DiscountList discountList = new DiscountList() ;
    
   
    public ArchiveCreator(){
    }
    
     public static ArchiveCreator getArchiveCreator(){
        return ARCHIVE_CREATOR;
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
