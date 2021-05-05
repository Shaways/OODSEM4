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

public class Main {
 /**
     * Starts the whole program.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        SystemCreator systemCreator = new SystemCreator();
        ArchiveCreator archCreator = new ArchiveCreator();
        Printer print = new Printer();
        Controller contr = new Controller(systemCreator, archCreator, print);
        View view = new View(contr);
        view.fakeExecution();
    }
}
