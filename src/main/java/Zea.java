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
            try {
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
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new DukeException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.mark(idx);
                        break;
                    }
                    case "unmark": { // TODO: handle invalid idx
                        int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new DukeException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.unmark(idx);
                        break;
                    }
                    case "todo": {
                        String description = commands[1].strip();
                        if (description.isEmpty()) {
                            throw new DukeException("Description cannot be empty.");
                        }
                        Todo t = new Todo(description);
                        taskStore.addTask(t);
                        break;
                    }
                    case "deadline": {
                        String[] unformattedDeadline = commands[1].split("/");
                        if (unformattedDeadline.length != 2) {
                            throw new DukeException("Incorrect format of deadline. Please use the following format: deadline <DESCRIPTION> /by <DATE>");
                        }
                        String description = unformattedDeadline[0].strip();
                        String by = unformattedDeadline[1].split(" ", 2)[1].strip(); // idx 0 is by. The rest is the date/time

                        Deadline d = new Deadline(description, by);
                        taskStore.addTask(d);
                        break;
                    }
                    case "event": {
                        String[] unformattedEvent = commands[1].split("/"); // description, from, to
                        if (unformattedEvent.length != 3) {
                            throw new DukeException("Incorrect format of event. Please use the following format: event <DESCRIPTION> /from <DATE> /to <DATE>");
                        }
                        String description = unformattedEvent[0].strip();
                        String from = unformattedEvent[1].split(" ", 2)[1].strip();
                        String to = unformattedEvent[2].split(" ", 2)[1].strip();
                        Event e = new Event(description, from, to);
                        taskStore.addTask(e);
                        break;
                    }
                    case "delete": {
                        int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new DukeException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.delete(idx);
                        break;
                    }
                    default:  // add command to store
                        throw new DukeException("Sorry, I do not understand that command. Try the following commands:\nlist\ntodo\ndeadline\nevent");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
