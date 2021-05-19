package se.kth.iv1350.sem4.Log;

/**
 * Handle all exceptions that will be logged and printed to the console
 */
public class ConsoleLogHandler extends LogHandler {
    private static final ConsoleLogHandler CONSOLE_LOG_HANDLER = new ConsoleLogHandler();

    private ConsoleLogHandler(){ }

    /**
     * Retrieves the singleton instance of ConsoleLogHandler.
     * @return The ConsoleLogHandler
     */
    public static ConsoleLogHandler getLogHandler() {
        return CONSOLE_LOG_HANDLER;
    }

    /**
     * Prints the message, date and the exceptions to the console.
     * 
     * @param exc the exception will be printed out.
     */
    @Override
    public void showLogException(Exception exc) {
        StringBuilder builder = new StringBuilder();
        builder.append("************ LOG *************");
        builder.append(NEW_LINE);
        builder.append(getTodaysDate());
        builder.append(", Exception has been thrown: ");
        builder.append(exc.getMessage());
        builder.append(NEW_LINE);
        System.out.println(builder.toString());
        exc.printStackTrace(System.out);
        System.out.println("******************************");
    }
}
