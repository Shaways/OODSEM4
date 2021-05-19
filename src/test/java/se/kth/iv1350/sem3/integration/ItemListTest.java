package se.kth.iv1350.sem3.integration;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author parosh
 */
public class ItemListTest {
    
    @Test
    public void testItemAvailable() {
        String sausage = "Mango";
        boolean expectedResult = true;
        ItemList itemList = new ItemList();
        boolean actualResult = itemList.itemAvailable(sausage);
        assertEquals(expectedResult, actualResult, "The expected item is not available in archive.");
    }
    @Test
    public void testItemNotAvailable() {
        String sausage = "Ham";
        boolean expectedResult = false;
        ItemList itemList = new ItemList();
        boolean actualResult = itemList.itemAvailable(sausage);
        assertEquals(expectedResult, actualResult, "The expected item is not available in archive.");
    }
    @Test
    public void testItemAvailableNullString() {
        String mango = null;
        boolean expectedResult = false;
        ItemList itemCatalog = new ItemList();
        boolean actualResult = itemCatalog.itemAvailable(mango);
        assertEquals(expectedResult, actualResult, "The expected item that is null is not available in archive.");
    }
}
