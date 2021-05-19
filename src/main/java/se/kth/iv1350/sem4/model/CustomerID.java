package se.kth.iv1350.sem4.model;

import java.util.Objects;

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
     @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final CustomerID other = (CustomerID) obj;
        if (!Objects.equals(this.customerIDNmbr, other.customerIDNmbr)) {
            return false;
        }
        return true;
    }

}