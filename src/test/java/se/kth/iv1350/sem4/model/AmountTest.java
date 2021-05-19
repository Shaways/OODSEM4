package se.kth.iv1350.sem4.model;

import se.kth.iv1350.sem4.model.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AmountTest {
    private Amount amountFive;
    
    @BeforeEach
    public void setUp() {
        amountFive= new Amount(5);
    }
    
    
    @AfterEach
    public void tearDown() {
          amountFive = null;
    }

   @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Amount instance = new Amount(0);
        double expResult = 0.0;
        double result = instance.getAmount();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testToString() {
        double posNumber = 42.0;
        Amount posAmount = new Amount(posNumber);
        String expString = Double.toString(posNumber);
        String resString = posAmount.toString();
        assertEquals(expString, resString,"String is not equal");
    }
    
    
}
