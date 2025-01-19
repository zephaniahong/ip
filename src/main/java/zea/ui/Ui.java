package zea.ui;

import zea.ZeaException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Ui {
    Scanner scanner;
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Display the welcome message
     */
    public void showWelcome() {
        String logo = "______________________\n"
                + "Hello! I'm Zea.Zea\n"
                + "What can I do for you?\n"
                + "______________________\n";
        System.out.println(logo);
    }

    /**
     * Displays the loading error message to the user
     * @param e - the error to be displayed
     */
    public void showLoadingError(ZeaException e) {
        System.out.println(e.getMessage());
    }

    /**
     * Displays a single item along with a header and footer
     * @param header - a message before the item is displayed
     * @param item - the item to be displayed
     * @param footer - a message after the item is displayed
     * @param <T> - any type that can be printed
     */
    public <T>void displayItem(String header, T item, String footer) {
        System.out.println("----------------------");
        System.out.println(header);
        System.out.println(item);
        if (!Objects.equals(footer, "")) {
            System.out.println(footer);
        }
        System.out.println("----------------------");
    }

    /**
     * Displays all the items with numbering
     * @param header- a message before the item is displayed
     * @param list - a list of items to be printed
     * @param <T>- any type that can be printed
     */
    public <T> void displayWithNumbering(String header, ArrayList<T> list) {
        System.out.println("----------------------");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            System.out.println(i+1 + ". " + t);
        }
        System.out.println("----------------------");
    }

    public void displayError(String message) {
        System.out.println("----------------------");
        System.out.println(message);
        System.out.println("----------------------");
    }

    /**
     * Reads the next line of the standard input
     * @return the input given by the user via stdin
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
