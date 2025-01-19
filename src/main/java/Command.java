import java.util.ArrayList;

public abstract class Command {
    protected boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public abstract void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException;
}
//LIST,
//TODO,
//EVENT,
//DEADLINE,
//MARK,
//UNMARK,
//DELETE,
//BYE;
