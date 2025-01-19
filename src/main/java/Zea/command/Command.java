package Zea.command;

import Zea.Storage;
import Zea.ZeaException;
import Zea.task.Tasks;
import Zea.ui.Ui;

public abstract class Command {
    protected boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public boolean getExitStatus() {
        return this.isExit;
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
