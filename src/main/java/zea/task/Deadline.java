package zea.task;

import java.time.LocalDateTime;

/**
 * A task that has a deadline
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructor of a Deadline
     * @param description - a description of the deadline
     * @param by - the datetime of the deadline
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toFileFormattedString() {
        return "D|" + (this.isDone ? "1" : "0") + "|" + this.description + "|" + this.by.format(FORMATTER);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Deadline deadline = (Deadline) o;
        return deadline.description.equals(this.description) && deadline.by.equals(this.by);
    }
}
