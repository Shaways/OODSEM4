package Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Handles all the exceptions that will be logged and printed out to a file.
 */
public class FileLogHandler extends LogHandler {
    private static final FileLogHandler FILE_LOG_HANDLER = new FileLogHandler();
    private PrintWriter printWriter;
    private final String FILE_NAME = "Failure-Log.txt";

    private FileLogHandler(){
        try {
            printWriter = new PrintWriter(new FileWriter(FILE_NAME), true);
            
        }catch (IOException e){
            System.out.println("Not possible to create the FileLoggerHandler");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the singleton instance of FileLogHandler.
     * @return The FileLogHandler.
     */
    public static FileLogHandler getLogHandler() {
        return FILE_LOG_HANDLER;
    }

    /**
     * Prints to the console.Includes the message of exception, date and also the exceptions.
     * @param e exception will be printed out.
     */
    @Override
    public void showLogException(Exception e){
        StringBuilder builder = new StringBuilder();
        builder.append("************ LOG *************");
        builder.append(NEW_LINE);
        builder.append(getTodaysDate());
        builder.append(", an Exception has been thrown: ");
        builder.append(e.getMessage());
        builder.append(NEW_LINE);
        printWriter.println(builder.toString());
        e.printStackTrace(printWriter);
        printWriter.println("******************************");
    }
}