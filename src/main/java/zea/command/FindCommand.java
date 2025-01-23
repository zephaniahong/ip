package zea.command;

import java.util.ArrayList;

import zea.Storage;
import zea.ZeaException;
import zea.task.Task;
import zea.task.Tasks;
import zea.ui.Ui;

/**
 * A command for finding a keyword in all the tasks
 */
public class FindCommand extends Command {

    protected String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException {
        ArrayList<Task> filteredTasks = tasks.find(this.keyword);
        ui.displayWithNumbering("Here are the tasks that match the keyword: " + this.keyword, filteredTasks);
    }
}
