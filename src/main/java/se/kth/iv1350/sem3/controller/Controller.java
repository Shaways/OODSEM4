package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.integration.AccountingSystem;
import se.kth.iv1350.sem3.integration.ArchiveCreator;
import se.kth.iv1350.sem3.integration.DiscountList;
import se.kth.iv1350.sem3.integration.InventorySystem;
import se.kth.iv1350.sem3.integration.Item;
import se.kth.iv1350.sem3.integration.ItemList;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.integration.Receipt;
import se.kth.iv1350.sem3.integration.SystemCreator;
import se.kth.iv1350.sem3.model.Amount;
import se.kth.iv1350.sem3.model.CashRegister;
import se.kth.iv1350.sem3.model.Payment;
import se.kth.iv1350.sem3.model.Sale;

/**
 * This is the application's only controller. All Calls to the model pass through this class.
 */
public class Controller {
    private Sale sale;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private Printer print;
    private DiscountList discountList;
    private ItemList itemList;
    private CashRegister cashRegister;
    
     /**
     * A new instance is made, and is defined as a controller.
     *
     * @param system     To retrieve all the classes that deals with external system calls.
     * @param archCreator    To retrieve all the classes that deals with data base calls.
     * @param print           Interface to printer.
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
    public String displayTotalWithTax(){
        return "total cost inclusive VAT: " + sale.getTotal().getTotalTogetherWithVAT().toString();
    }
    
    private String displayTotal(){
        return sale.getTotal().toString();
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
     */
    

    public String registerItem(String itemID, Amount itemQuantity){
        
        if (itemList.itemAvailable(itemID)){
            
            Item item = itemList.getItem(itemID, itemQuantity);
            return sale.updateCurrentSale(item) + ", Item quantity: " + itemQuantity.toString() +
                    ", current total: " + displayTotal();
        }
        return "current total: " + displayTotal();
    }
    
     /**
     * The assigned Amount is used to make a payment.
     * Will be credited to the cashRegister's balance.
     * The printer can produce and print receipt, after
     * the external system has been updated.
     *
     * @param paidAmount Money that the customer gives to cashier.
     * @return change back which is an amount that will be given back to the customer.
     */
    public String pay(Amount paidAmount){
        Payment totalPayment = new Payment(paidAmount, sale.getTotal());
        cashRegister.addPayment(totalPayment);
        accountingSystem.bookKeep(sale);
        inventorySystem.updateInventory(sale);
        Receipt receipt = new Receipt(sale);
        print.printReceipt(receipt);
        sale = null;
        return "Change back: " + totalPayment.getChange().toString();
    }

}
   


