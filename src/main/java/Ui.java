import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Ui {
    Scanner scanner;
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = "______________________\n"
                + "Hello! I'm Zea\n"
                + "What can I do for you?\n"
                + "______________________\n";
        System.out.println(logo);
    }

    public void showLoadingError(ZeaException e) {
        System.out.println(e.getMessage());
    }

    public <T>void displayItem(String header, T item, String footer) {
        System.out.println("----------------------");
        System.out.println(item);
        if (!Objects.equals(footer, "")) {
            System.out.println(footer);
        }
        System.out.println("----------------------");
    }

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

    public String readCommand() {
        return this.scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
