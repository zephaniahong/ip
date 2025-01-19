package zea;

import org.junit.jupiter.api.Test;

import zea.command.*;
import zea.task.Task;
import zea.task.Tasks;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void byeTest() {
        try {
            Command c = Parser.parse("bye");
            assertEquals(c, new ExitCommand());
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void listTest() {
        try {
            Command c = Parser.parse("list");
            assertEquals(c, new ListCommand());
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void markTest() {
        try {
            Command c = Parser.parse("mark 1");
            assertEquals(c, new MarkCommand(0));
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void unmarkTest() {
        try {
            Command c = Parser.parse("unmark 2");
            assertEquals(c, new UnmarkCommand(1));
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void todoTest() {
        try {
            Command c = Parser.parse("todo buy chicken rice");
            assertEquals(c, new TodoCommand("buy chicken rice"));
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void deadlineTest() {
        try {
            Command c = Parser.parse("deadline sell house /by 01/02/2025 10:30");
            assertEquals(c, new DeadlineCommand("sell house", LocalDateTime.parse("01/02/2025 10:30", Task.formatter)));
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void eventTest() {
        try {
            Command c = Parser.parse("event wedding dinner /from 01/02/2025 10:30 /to 05/02/2025 18:00");
            assertEquals(c, new EventCommand("wedding dinner", LocalDateTime.parse("01/02/2025 10:30", Task.formatter), LocalDateTime.parse("05/02/2025 18:00", Task.formatter)));
        } catch (ParseException e) {
            fail();
        }
    }

    @Test
    public void unknownCommandTest() {
        assertThrows(ParseException.class, () -> Parser.parse("gibberish"));
    }
}

