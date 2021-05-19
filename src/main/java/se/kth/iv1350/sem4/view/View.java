
package se.kth.iv1350.sem4.view;


import Log.ConsoleLogHandler;
import Log.LogHandler;

import se.kth.iv1350.sem4.controller.Controller;
import se.kth.iv1350.sem4.controller.DatabaseFailedException;
import se.kth.iv1350.sem4.integration.ItemNotFoundException;
import se.kth.iv1350.sem4.model.Amount;

public class View {
    private Controller contr;
    private ErrorMessageHandler errorMessageHandler = ErrorMessageHandler.getErrorMessageHandler();
    private LogHandler logHandler = ConsoleLogHandler.getLogHandler();
   
    /**
     * Makes a new instance, that uses the specific controller for all calls to other layers.
     * @param contr The controller class where alla the calls are made.
     */
    
    public View (Controller contr){
        this.contr = contr;
        contr.addPaymentObserver(new TotalRevenueView());
    }
    /**
     *  Constructs a fake execution of the whole application.
     */
  
    public void fakeExecution(){
        String out;
        System.out.println("Cashier starts sale.\n");
        contr.startSale();
        System.out.println("Cashier enter items. \n");
        
        registerItem("Mango", new Amount(4));
        registerItem("Ananas",new Amount(3));
        registerItem("OstFEL", new Amount(2));
        registerItem("FAILURE", new Amount(0));
       

        try{
            System.out.println("Cashier displays the total with VAT. \n");
            out = contr.displayTotalWithVAT();
            System.out.println(out + "\n");
        }catch (IllegalStateException exc){
            handleException("Have to start new sale first.", exc);
        }

        try {
            System.out.println("Cashier enters the paid amount of 500.0 \n");
            out = contr.pay(new Amount(500.0));
            System.out.println(out);
        }catch (IllegalStateException exc){
            handleException("Have to start new sale first.", exc);
        }

    }
    
     private void registerItem(String itemID, Amount amount){
        String out;
        try {
            out = contr.registerItem(itemID, amount);
            System.out.println(out);
        }catch (ItemNotFoundException e) {
            handleException("Item identifier " + itemID +  " does not exist in system, please try again.", e);
        }catch (DatabaseFailedException e) {
            handleException("Failure with registering the item, try again.", e);
        }catch (IllegalStateException e){
            handleException("Have to start new sale.", e);
        }
    }
        
     private void handleException (String msg, Exception e){
        errorMessageHandler.showErrorMsg(msg);  
        logHandler.showLogException(e);
           

           
    }
    
}
