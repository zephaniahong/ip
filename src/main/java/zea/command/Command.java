package zea.command;

import zea.Storage;
import zea.ZeaException;
import zea.task.Tasks;
import zea.ui.Ui;

/**
 * An abstract class for Commands
 */
public abstract class Command {
    protected boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public boolean getExitStatus() {
        return this.isExit;
    }

    public abstract void execute(Tasks tasks, Ui ui, Storage storage) throws ZeaException;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }
}
//LIST,
//TODO,
//EVENT,
//DEADLINE,
//MARK,
//UNMARK,
//DELETE,
//BYE;
