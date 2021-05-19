package se.kth.iv1350.sem4.controller;

import se.kth.iv1350.sem4.controller.DatabaseFailedException;
import se.kth.iv1350.sem4.controller.Controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.sem4.integration.ArchiveCreator;
import se.kth.iv1350.sem4.integration.Printer;
import se.kth.iv1350.sem4.integration.SystemCreator;
import se.kth.iv1350.sem4.model.Amount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import se.kth.iv1350.sem4.integration.ItemNotFoundException;

public class ControllerTest {
    private Controller contr;
    
    @BeforeEach
    public void setUp() {
        contr = new Controller(SystemCreator.getSystemCreator(), ArchiveCreator.getArchiveCreator(), Printer.getPrinter());
    }
    
    @AfterEach
    public void tearDown() {
        contr = null;
    }
    
    @Test
    public void registerItem() {
        contr.startSale();
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VATrate = new Amount(10.0);
        
        try{
        String result = contr.registerItem(nameOfItem, new Amount(1));
        String expResult = "Item: " + nameOfItem + "\n" +
                "price: " + price + "\n" +
                "VAT: " + VATrate + "\n" +
                ", quantity: " + new Amount(2) + ", current total: " + price;
        assertEquals(expResult, result, "String from registerItem is not equal as String with the same state.");
        }catch (DatabaseFailedException | ItemNotFoundException e){
        }
    }
        
    @Test
    public void displayTotalInclVAT() {
        contr.startSale();
        
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VAT = new Amount(10.0);
        
        try{
        contr.registerItem(nameOfItem, new Amount(3));
       }catch (DatabaseFailedException | ItemNotFoundException e){
       }
    
       
        
        String result = contr.displayTotalWithVAT();
        String expResult = "total inclusive VAT: " + price.plus(VAT);
        assertEquals(expResult, result, "Total inclusive VAT from sale is not equal to the expected result.");
    }
    
    @Test
    public void pay() {
        contr.startSale();
        String nameOfItem = "Mango";
        Amount price = new Amount(49.9);
        Amount VAT = new Amount(10.0);
        
        try{
        contr.registerItem(nameOfItem, new Amount(5));
        }catch (DatabaseFailedException | ItemNotFoundException e){
            
        }
        Amount amountPaid = new Amount(100);
        String expResult = "Change: " + amountPaid.minus(price.plus(VAT));
        String result = contr.pay(amountPaid);
        assertEquals(expResult, result, "Change is not equal to amount with the same amount.");
    }
  }

    