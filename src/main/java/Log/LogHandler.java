package Log;

import java.time.LocalDateTime;

/**
 * Handles all the exceptions that will be logged.
 */
public abstract class LogHandler {
    protected final String NEW_LINE = "\n";

    /**
     * Will print out a log, that shows the exception that was thrown.
     * @param e the exception will be printed out.
     */
    public abstract void showLogException(Exception e);

    /**
     * Gets the date of today.
     * @return The date of today.
     */
    protected String getTodaysDate(){
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate().toString();
    }
}