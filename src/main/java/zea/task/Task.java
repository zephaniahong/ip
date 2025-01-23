package zea.task;

import java.time.format.DateTimeFormatter;

/**
 * An abstract Task class
 */
public abstract class Task {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task
     * @param description - a description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void done() {
        this.isDone = true;
    }

    public void undone() {
        this.isDone = false;
    }

    public abstract String toFileFormattedString();

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return description.equals(((Task) o).description) && isDone == ((Task) o).isDone;
    }
}
