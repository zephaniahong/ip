import java.util.ArrayList;
import java.util.Scanner;

public class Zea {
    public static void main(String[] args) {
            String logo = "______________________\n"
                    + "Hello! I'm Zea\n"
                    + "What can I do for you?\n"
                    + "______________________\n";
            System.out.println(logo);

            Scanner scanner = new Scanner(System.in);
            Tasks taskStore = new Tasks();
        label:
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ", 2);
            switch (commands[0]) {
                case "bye":  // Exit from program
                    System.out.println("----------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("----------------------");
                    break label;
                case "list":  // Print out all commands in store
                    taskStore.list();
                    break;
                case "mark": { // TODO: handle invalid idx
                    int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx

                    taskStore.mark(idx);
                    break;
                }
                case "unmark": { // TODO: handle invalid idx
                    int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx

                    taskStore.unmark(idx);
                    break;
                }
                case "todo": {
                    String description = commands[1].strip();
                    Todo t = new Todo(description);
                    taskStore.addTask(t);
                    break;
                }
                case "deadline": {
                    String[] unformattedDeadline = commands[1].split("/");
                    String description = unformattedDeadline[0].strip();
                    String by = unformattedDeadline[1].split(" ", 2)[1].strip(); // idx 0 is by. The rest is the date/time

                    Deadline d = new Deadline(description, by);
                    taskStore.addTask(d);
                    break;
                }
                case "event": {
                    String[] unformattedEvent = commands[1].split("/"); // description, from, to
                    String description = unformattedEvent[0].strip();
                    String from = unformattedEvent[1].split(" ", 2)[1].strip();
                    String to = unformattedEvent[2].split(" ", 2)[1].strip();
                    Event e = new Event(description, from, to);
                    taskStore.addTask(e);
                    break;
                }
                default:  // add command to store
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
