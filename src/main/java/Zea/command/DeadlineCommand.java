package Zea.command;

import Zea.Storage;
import Zea.ZeaException;
import Zea.task.Deadline;
import Zea.task.Tasks;
import Zea.ui.Ui;

import java.time.LocalDateTime;

public class DeadlineCommand extends Command {
    private String description;
    private LocalDateTime by;

    public DeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        Deadline d = new Deadline(this.description, this.by);
        tasks.addTask(d);
        storage.save(tasks);
        ui.displayItem("Great! I've created a new deadline for you!", d, "You now have " + tasks.getTotalTasks() + " tasks");
    }
}
