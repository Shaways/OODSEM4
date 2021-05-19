package se.kth.iv1350.sem3.view;

import java.time.LocalDateTime;


/**
 * Handles the error messages for the UI (user interface).
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();
    private final String NEW_LINE = "\n";

    public ErrorMessageHandler(){}
    
    /**
     * Retrieves the instance of <code>ErrorMessageHandler</code>
     * @return ErrorMessageHandler.
     */
    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    }
    
     /**
     * Prints out a message to the user interface.
     * The printout will have the date of the error and the message.
     * @param msg the message that will be printed out.
     */
    public void showErrorMsg(String msg) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n**** NOTIFICATION TO CASHIER ****");
        builder.append(NEW_LINE);
        builder.append(getDateOfToday());
        builder.append(", FAILURE ERROR!: ");
        builder.append(msg);
        builder.append(NEW_LINE);
        builder.append("******************************");
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
        
    }
     private String getDateOfToday(){
        LocalDateTime rightNow = LocalDateTime.now();
        return rightNow.toLocalDate().toString();
    }
}