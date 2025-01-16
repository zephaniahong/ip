import java.util.ArrayList;
import java.util.Scanner;

public class Zea {
    public static void main(String[] args) {
        ArrayList<Task> store = new ArrayList<>();
            String logo = "______________________\n"
                    + "Hello! I'm Zea\n"
                    + "What can I do for you?\n"
                    + "______________________\n";
            System.out.println(logo);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                String[] commands = command.split(" ");
                if (commands[0].equals("bye")) { // Exit from program
                    System.out.println("----------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("----------------------");
                    break;
                } else if (commands[0].equals("list")) { // Print out all commands in store
                    System.out.println("----------------------");
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < store.size(); i++) {
                        Task t = store.get(i);
                        System.out.println(i+1 + ". " + t);
                    }
                    System.out.println("----------------------");
                } else if (commands[0].equals("mark")) { // TODO: handle invalid idx
                    int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                    Task t = store.get(idx);
                    t.done();
                    System.out.println("----------------------");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(t);
                    System.out.println("----------------------");
                } else if (commands[0].equals("unmark")) { // TODO: handle invalid idx
                    int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                    Task t = store.get(idx);
                    t.undone();
                    System.out.println("----------------------");
                    System.out.println("Ok, I've marked this task as not done yet:");
                    System.out.println(t);
                    System.out.println("----------------------");
                } else { // add command to store
                    Task newTask = new Task(command);
                    store.add(newTask);
                    System.out.println("----------------------");
                    System.out.println("added: " + command);
                    System.out.println("----------------------");
                }
            }
    }
}
