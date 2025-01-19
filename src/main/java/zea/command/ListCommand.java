package zea.command;

import zea.Storage;
import zea.task.Tasks;
import zea.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) {
        ui.displayWithNumbering("Here are your tasks", tasks.getAllTasks());
    }
}