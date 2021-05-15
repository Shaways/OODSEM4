
package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.model.Amount;

public class View {
    private Controller contr;
    
    /**
     * creates a new instance, that uses the specific controller for all calls to other layers.
     * @param contr The controller class where alla the calls are made.
     */
    public View (Controller contr){
        this.contr = contr;
    }
    
    /**
     *  A method with example registrations of items. It is a sample execution.
     */
    public void fakeExecution(){
        contr.startSale();
        
        System.out.println("Cashier starts new sale. \n");
        System.out.println("Items added to sale: \n");
        
        String out = contr.registerItem("Mango", new Amount(1));
        System.out.println(out);
        
        out = contr.registerItem("Sallad", new Amount(2));
        System.out.println(out);
        
        out = contr.registerItem("Ananas", new Amount(2));
        System.out.println(out);
        
        out = contr.registerItem("Ostron", new Amount(3));
        System.out.println(out);
        
 
        
        System.out.println("\nCashier display total incl taxes. \n");
        out = contr.displayTotalWithVAT();
        
        System.out.println(out);
        
        System.out.println("Cashier enter paid amount of 500.0. \n");
        out = contr.pay(new Amount(500));
        System.out.println(out);
 
    }
}
