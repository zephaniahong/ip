package zea.command;

import zea.Storage;
import zea.ZeaException;
import zea.task.Event;
import zea.task.Tasks;
import zea.ui.Ui;

import java.time.LocalDateTime;

public class EventCommand extends Command {
    private String description;
    private LocalDateTime from;
    private LocalDateTime to;

    public EventCommand(String description, LocalDateTime from, LocalDateTime to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }
    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        Event e = new Event(this.description, this.from, this.to);
        tasks.addTask(e);
        storage.save(tasks);
        ui.displayItem("Great! I've added a new event for you:", e, "You now have " + tasks.getTotalTasks() + " task(s)");
    }
}
