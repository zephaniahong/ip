package zea.command;

import zea.Storage;
import zea.ZeaException;
import zea.task.Tasks;
import zea.ui.Ui;

public class UnmarkCommand extends Command {
    int idx;

    public UnmarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        if (this.idx < 0 || this.idx >= tasks.getTotalTasks()) {
            throw new ZeaException("Invalid index. Please choose an index between 1 and " + tasks.getTotalTasks());
        }
        tasks.unmark(this.idx);
        storage.save(tasks);
        ui.displayItem("Ok, I've marked this task as not done yet:", tasks.getTask(idx), "");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return idx == ((UnmarkCommand) other).idx;
    }
}
