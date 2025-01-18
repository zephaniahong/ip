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
            taskStore.read();
        label:
        while (true) {
            String userInput = scanner.nextLine();
            String[] commands = userInput.split(" ", 2);
            try {
                Command command = Command.valueOf(commands[0].strip().toUpperCase());
                switch (command) {
                    case BYE:  // Exit from program
                        System.out.println("----------------------");
                        System.out.println("Bye. Hope to see you again soon!");
                        System.out.println("----------------------");
                        break label;
                    case LIST:  // Print out all commands in store
                        taskStore.list();
                        break;
                    case MARK: {
                        int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new ZeaException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.mark(idx);
                        taskStore.save();
                        break;
                    }
                    case UNMARK: {
                        int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new ZeaException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.unmark(idx);
                        taskStore.save();
                        break;
                    }
                    case TODO: {
                        String description = commands[1].strip();
                        if (description.isEmpty()) {
                            throw new ZeaException("Description cannot be empty.");
                        }
                        Todo t = new Todo(description);
                        taskStore.addTask(t);
                        taskStore.save();
                        break;
                    }
                    case DEADLINE: {
                        String[] unformattedDeadline = commands[1].split("/");
                        if (unformattedDeadline.length != 2) {
                            throw new ZeaException("Incorrect format of deadline. Please use the following format: deadline <DESCRIPTION> /by <DATE>");
                        }
                        String description = unformattedDeadline[0].strip();
                        String by = unformattedDeadline[1].split(" ", 2)[1].strip(); // idx 0 is by. The rest is the date/time

                        Deadline d = new Deadline(description, by);
                        taskStore.addTask(d);
                        taskStore.save();
                        break;
                    }
                    case EVENT: {
                        String[] unformattedEvent = commands[1].split("/"); // description, from, to
                        if (unformattedEvent.length != 3) {
                            throw new ZeaException("Incorrect format of event. Please use the following format: event <DESCRIPTION> /from <DATE> /to <DATE>");
                        }
                        String description = unformattedEvent[0].strip();
                        String from = unformattedEvent[1].split(" ", 2)[1].strip();
                        String to = unformattedEvent[2].split(" ", 2)[1].strip();
                        Event e = new Event(description, from, to);
                        taskStore.addTask(e);
                        taskStore.save();
                        break;
                    }
                    case DELETE: {
                        int idx = Integer.parseInt(commands[1]) - 1; // subtract 1 to convert list number to array idx
                        if (idx < 0 || idx >= taskStore.tasks.size()) {
                            throw new ZeaException("Invalid index. Please choose an index between 1 and " + taskStore.tasks.size());
                        }
                        taskStore.delete(idx);
                        taskStore.save();
                        break;
                    }
                    default:  // add command to store
                        throw new ZeaException("Sorry, I do not understand that command. Try the following commands:\nlist\ntodo\ndeadline\nevent");
                }
            } catch (ZeaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}