
package se.kth.iv1350.sem3.view;

import se.kth.iv1350.sem3.controller.Controller;

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
    System.out.println("A New sale has been started");
    // a method with example registrations of items.
    }
}
