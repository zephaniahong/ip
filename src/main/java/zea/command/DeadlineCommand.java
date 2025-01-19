package zea.command;

import zea.Storage;
import zea.ZeaException;
import zea.task.Deadline;
import zea.task.Tasks;
import zea.ui.Ui;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeadlineCommand that = (DeadlineCommand) other;
        return Objects.equals(description, ((DeadlineCommand) other).description) && Objects.equals(this.by, that.by);
    }
}