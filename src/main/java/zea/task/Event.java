package zea.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime to;
    protected LocalDateTime from;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormattedString() {
        return "E|" + (this.isDone ? "1":"0") + "|" + description + "|" + from.format(formatter) + "|" + to.format(formatter);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return event.description.equals(this.description) && event.to.equals(this.to) && event.from.equals(this.from);
    }
}
