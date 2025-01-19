public class MarkCommand extends Command{
    int idx;

    public MarkCommand(int idx) {
       this.idx = idx;
    }

    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        if (this.idx < 0 || this.idx >= tasks.getTotalTasks()) {
            throw new ZeaException("Invalid index. Please choose an index between 1 and " + tasks.getTotalTasks());
        }
        tasks.mark(this.idx);
        storage.save(tasks);
        ui.displayItem("Nice! I've marked this task as done:", tasks.getTask(idx), "");
    }
}
