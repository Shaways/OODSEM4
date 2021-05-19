package se.kth.iv1350.sem4.controller;

/**
 * This exception gets thrown when an operation goes wrong and fails, such as database server error etc. 
 * Vague failures.
 */
public class DatabaseFailedException extends Exception{
    
     /**
     * Creates a new instance with the specified message and the main reason for it.
     *
     * @param msg The exception message that is shown.
     * @param reason Exception that is the reason for this exception.
     */
    public DatabaseFailedException(String msg, Exception reason){
        super(msg, reason);
    }
}
    
    

