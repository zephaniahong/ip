package zea.task;

/**
 * A task of type Todo
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String toFileFormattedString() {
        return "T|" + (this.isDone ? "1" : "0") + "|" + this.description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return super.equals(o);
    }
}
