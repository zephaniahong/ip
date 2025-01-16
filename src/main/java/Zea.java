import java.util.ArrayList;
import java.util.Scanner;

public class Zea {
    public static void main(String[] args) {
        ArrayList<String> store = new ArrayList<>();
            String logo = "______________________\n"
                    + "Hello! I'm Zea\n"
                    + "What can I do for you?\n"
                    + "______________________\n";

            System.out.println(logo);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("bye")) { // Exit from program
                    System.out.println("----------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("----------------------");
                    break;
                } else if (command.equals("list")) { // Print out all commands in store
                    System.out.println("----------------------");
                    for (int i = 0; i < store.size(); i++) {
                        String c = store.get(i);
                        System.out.println(i+1 + ". " + c);
                    }
                    System.out.println("----------------------");
                } else { // add command to store
                    store.add(command);
                    System.out.println("----------------------");
                    System.out.println("added: " + command);
                    System.out.println("----------------------");
                }
            }
    }
}
