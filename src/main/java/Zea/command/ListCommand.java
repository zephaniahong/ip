package Zea.command;

import Zea.Storage;
import Zea.task.Tasks;
import Zea.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) {
        ui.displayWithNumbering("Here are your tasks", tasks.getAllTasks());
    }
}
