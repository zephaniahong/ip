package zea.command;

import zea.Storage;
import zea.ZeaException;
import zea.task.Tasks;
import zea.task.Todo;
import zea.ui.Ui;

import java.util.Objects;

public class TodoCommand extends Command {
    String description;

    public TodoCommand(String description) {
       this.description = description;
    }

    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        if (description.isEmpty()) {
            throw new ZeaException("Description cannot be empty.");
        }
        Todo t = new Todo(description);
        tasks.addTask(t);
        storage.save(tasks);
        ui.displayItem("Got it. I've added this task:", t, "Now you have " + tasks.getTotalTasks() + " tasks in the list");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return Objects.equals(this.description, ((TodoCommand) other).description);
    }
}
