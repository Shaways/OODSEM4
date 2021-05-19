package se.kth.iv1350.sem3.startup;

import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.integration.ArchiveCreator;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.integration.SystemCreator;
import se.kth.iv1350.sem3.view.View;

/**
 * 
 * Starts the entire application,
 * contains the main method used to start the application.
 *
 */

/**
 * Contains the main method.
 * Performs startup of the application.
 */

public class Main {

    /**
     * main starts application.
     */
    
    public static void main(String[] args) {
        SystemCreator systemCreator = SystemCreator.getSystemCreator();
        ArchiveCreator catalogCreator = ArchiveCreator.getArchiveCreator();
        Printer printer = Printer.getPrinter();
        Controller controller = new Controller(systemCreator, catalogCreator, printer);
        View view = new View(controller);
        view.fakeExecution();
        
    }
}
