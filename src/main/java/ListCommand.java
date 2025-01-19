import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) {
        ui.displayWithNumbering("Here are your tasks", tasks.tasks);
    }
}
