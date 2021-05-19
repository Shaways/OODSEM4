
package se.kth.iv1350.sem4.view;

import se.kth.iv1350.sem4.model.PaymentObserver;
import se.kth.iv1350.sem4.model.Total;


/**
 * Displays the total cash revenue when a payment has been made.
 */
public class TotalRevenueView implements PaymentObserver{
    private Total totalRevenue;

    /**
     * Makes an instance of <code>TotalRevenueView</code>
     */
    public TotalRevenueView(){
        totalRevenue = new Total();
    }

    /**
     * Updates the total revenue.
     * @param total the total that will be added to this <code>totalRevenue</code>
     */
    @Override
    public void updateTotal(Total total) {
        totalRevenue.updateTotal(total);
        printCurrentRevenue();
    }

    private void printCurrentRevenue(){
        System.out.println("****** DISPLAY ******");
        System.out.println("*** TOTAL REVENUE ***");
        System.out.println("   Amount: " + totalRevenue.getTotalTogetherWithVAT().toString());
        System.out.println("*********************\n");
    }

}