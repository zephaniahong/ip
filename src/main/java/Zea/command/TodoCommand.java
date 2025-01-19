package Zea.command;

import Zea.Storage;
import Zea.ZeaException;
import Zea.task.Tasks;
import Zea.task.Todo;
import Zea.ui.Ui;

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
}
