package zea;

import zea.command.*;
import zea.task.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Parser {
    /**
     *
     * @param fullCommand - a String of the command to be parsed
     * @return a <code>Command</code> to be executed
     * @throws ParseException - if the fullCommand syntax is invalid
     */
    public static Command parse(String fullCommand) throws ParseException {
        String[] tokens = fullCommand.split(" ", 2);
        String command = tokens[0];
        try {
            switch (command) {
                case "bye":  // Exit from program
                    return new ExitCommand();
                case "list":  // Print out all commands in store
                    return new ListCommand();
                case "mark": {
                    int idx = Integer.parseInt(tokens[1]) - 1; // subtract 1 to convert list number to array idx
                    return new MarkCommand(idx);
                }
                case "unmark": {
                    int idx = Integer.parseInt(tokens[1]) - 1; // subtract 1 to convert list number to array idx
                    return new UnmarkCommand(idx);
                }
                case "todo": {
                    String description = tokens[1].strip();
                    return new TodoCommand(description);
                }
                case "deadline": {
                    String[] unformattedDeadline = tokens[1].split("/", 2);
                    if (unformattedDeadline.length != 2) {
                        throw new ParseException("Incorrect format of deadline. Please use the following format: deadline <DESCRIPTION> /by <DATE>");
                    }
                    String description = unformattedDeadline[0].strip();
                    String by = unformattedDeadline[1].split(" ", 2)[1].strip(); // idx 0 is by. The rest is the date/time
                    LocalDateTime byDateTime = LocalDateTime.parse(by, Task.formatter);
                    return new DeadlineCommand(description, byDateTime);
                }
                case "event": {
                    String[] unformattedEvent = tokens[1].split("/from"); // description, from and to
                    if (unformattedEvent.length != 2) {
                        throw new ParseException("Incorrect format of event. Please use the following format: event <DESCRIPTION> /from <DATE> /to <DATE>");
                    }
                    String description = unformattedEvent[0].strip();
                    String[] fromTo = unformattedEvent[1].split("/to");
                    if (fromTo.length != 2) {
                        throw new ParseException("Incorrect format of event. Please use the following format: event <DESCRIPTION> /from <DATE> /to <DATE>");
                    }
                    String from = fromTo[0].strip();
                    String to = fromTo[1].strip();
                    LocalDateTime fromDateTime = LocalDateTime.parse(from, Task.formatter);
                    LocalDateTime toDateTime = LocalDateTime.parse(to, Task.formatter);
                    return new EventCommand(description, fromDateTime, toDateTime);
                }
                case "delete": {
                    int idx = Integer.parseInt(tokens[1]) - 1; // subtract 1 to convert list number to array idx
                    return new DeleteCommand(idx);
                }
                default:  // TODO: handle unknown command
                    throw new ParseException("Sorry, I do not understand that command. Try the following commands:\nlist\ntodo\ndeadline\nevent");
            }
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        // this should never happen
        System.out.println("This should never happen");
        return null;
    }
}
