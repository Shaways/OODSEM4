package se.kth.iv1350.sem3.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem3.integration.ArchiveCreator;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.integration.SystemCreator;
import se.kth.iv1350.sem3.model.Amount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class ControllerTest {
    private Controller controller;
    
    @BeforeEach
    public void setUp() {
        controller = new Controller(new SystemCreator(), new ArchiveCreator(), new Printer());
    }
    
    @AfterEach
    public void tearDown() {
        controller = null;
    }
    
    @Test
    public void registerItem() {
        controller.startSale();
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VATrate = new Amount(10.0);
        String result = controller.registerItem(nameOfItem, new Amount(1));
        String expResult = "Item: " + nameOfItem + "\n" +
                "price: " + price + "\n" +
                "VAT: " + VATrate + "\n" +
                ", quantity: " + new Amount(2) + ", current total: " + price;
        assertEquals(expResult, result, "String from registerItem is not equal as String with the same state.");
    }
     @Test
    public void displayTotalInclVAT() {
        controller.startSale();
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VAT = new Amount(10.0);
        controller.registerItem(nameOfItem, new Amount(3));
        String result = controller.displayTotalWithVAT();
        String expResult = "total inclusive VAT: " + price.plus(VAT);
        assertEquals(expResult, result, "Total inclusive VAT from sale is not equal to the expected result.");
    }
    @Test
    public void pay() {
        controller.startSale();
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VAT = new Amount(10.0);
        controller.registerItem(nameOfItem, new Amount(5));
        Amount amountPaid = new Amount(100);
        String expResult = "Change: " + amountPaid.minus(price.plus(VAT));
        String result = controller.pay(amountPaid);
        assertEquals(expResult, result, "Change is not equal to amount with the same amount.");
    }
}
    