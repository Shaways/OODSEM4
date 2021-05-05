package se.kth.iv1350.sem3.model;

public class CustomerID {
  private String customerIDNmbr;  


    /**
    * Method creates an new instance, representing the stated customer ID.
    *
    * @param customerIDNmbr The unique ID number assigned to the newly generated instance.
    */
  
    public CustomerID (String customerIDNmbr){
        this.customerIDNmbr = customerIDNmbr;
    }
/**
     * Getter that retrieves the value of customerIDNmbr.
     *
     * @return The value of costumerIDNmbr.
     */
    public String getCustomerIDNumber() {
        return customerIDNmbr;
    }

}