package se.kth.iv1350.sem4.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.sem4.integration.AccountingSystem;
import se.kth.iv1350.sem4.integration.ArchiveCreator;
import se.kth.iv1350.sem4.integration.DiscountList;
import se.kth.iv1350.sem4.integration.InventorySystem;
import se.kth.iv1350.sem4.integration.Item;
import se.kth.iv1350.sem4.integration.ItemList;
import se.kth.iv1350.sem4.integration.ItemListException;
import se.kth.iv1350.sem4.integration.ItemNotFoundException;
import se.kth.iv1350.sem4.integration.Printer;
import se.kth.iv1350.sem4.model.Receipt;
import se.kth.iv1350.sem4.integration.SystemCreator;
import se.kth.iv1350.sem4.model.Amount;
import se.kth.iv1350.sem4.model.CashRegister;
import se.kth.iv1350.sem4.model.Payment;
import se.kth.iv1350.sem4.model.PaymentObserver;
import se.kth.iv1350.sem4.model.Sale;

/**
 * This is the application's only controller where all calls to the model is passed through.
 * 
 */
public class Controller {
    private Sale sale;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer print;
    private DiscountList discountList;
    private final ItemList itemList;
    private CashRegister cashRegister;
    private List<PaymentObserver> paymentObservers = new ArrayList();
    
     /**
     * A new instance is created, and is defined as a controller.
     * The sales only controller where all calls to the model is passed through.
     *
     * @param system     To retrieve all the classes that deals with external system calls.
     * @param archCreator    To retrieve all the classes that deals with data base calls.
     * @param print           Printer.
     */
    
    public Controller(SystemCreator system, ArchiveCreator archCreator, Printer print){
        this.print = print;
        this.itemList = archCreator.getItemList();
        this.discountList = archCreator.getListOfDiscount();
        this.accountingSystem = system.getAccountingSystem();
        this.inventorySystem = system.getInventorySystem();
        this.cashRegister = new CashRegister();
        
    }
    
/**
 * Starts a new sale. This method must be called before doing anything else during a sale.
 */
    public void startSale(){
        this.sale = new Sale();
    }
    
     /**
     * Shows the total with VAT added. 
     *
     * @return The result as a String, of the total with VAT.
     */
    public String displayTotalWithVAT() throws IllegalStateException{
        controlIfSaleIsNull("displayTotalWithVAT");
        return "Total cost inclusive VAT: " + sale.getTotal().getTotalTogetherWithVAT().toString();
    }
    
    private String displayTotal(){
        return sale.getTotal().getTotal().toString();
    }
    
    /**
     * If the item ID is available, we'll connect it to the item's
     * selling and return details and display the total.Otherwise,
     * w'ell just display the current total.
     *
     * @param itemID The item as a string, that we are going to add to the sale due to its ID.
     * @param itemQuantity The quantity of the item.
     * @return If the scanned item is there we return a string containing
     * details about the item and the current total,
     * if not, then we return a string with the running total.
     * @throws IllegalStateException If this method is called before <code>startSale</code>
     * @throws DatabaseFailedException If unable to register item identifier other than it doesn't exist.
     * @throws ItemNotFoundException If the item identifier doesn't exist.
     * 
     */

    public String registerItem(String itemID, Amount itemQuantity) throws DatabaseFailedException, ItemNotFoundException{
      
        controlIfSaleIsNull("registerItem");
        
        try {
            Item item = itemList.getItem(itemID, itemQuantity);
            
            return sale.updateCurrentSale(item) + ", quantity: " + itemQuantity.toString() +
                    ", running total: " + displayTotal();
            
        }catch (ItemListException e){
            
            throw new DatabaseFailedException("Could not get the item.", e);
        }

    }
    
    /**
     * Goes ahead and makes a payment with the given paidAmount. cashRegister will add ths amount to its balance. 
     * External system will then be updated, and a receipt is then made and printed by a printer.
     *
     * @param paidAmount The amount of money given by the customer.
     * @return The total change that will be given to the customer.
     * @throws IllegalStateException If this method is called before <code>startSale</code>
     */
    public String pay(Amount paidAmount) throws IllegalStateException{
        controlIfSaleIsNull("pay");
        Payment payment = new Payment(paidAmount, sale.getTotal());
        payment.addPaymentObservers(paymentObservers);
        cashRegister.addPayment(payment);
        accountingSystem.bookKeeping(sale);
        inventorySystem.updateInventory(sale);
        Receipt receipt = new Receipt(sale);
        print.printReceipt(receipt);
        sale = null;
        return "Change back: " + payment.getChange().toString();
    }
    
 /**
     * When a payment have been made, the specified observer will be notified of the total .
     * Notifications will only be there after this method is called.
     *
     * @param paymentObserver Is the observer to notify.
     */
    public void addPaymentObserver(PaymentObserver paymentObserver){
        paymentObservers.add(paymentObserver);
    }
    
    private void controlIfSaleIsNull(String saleMethod){
        if (sale == null){
            throw new IllegalStateException("The call to " + saleMethod + " has been executed before initiating a new sale.");
        }

 }
}
   


