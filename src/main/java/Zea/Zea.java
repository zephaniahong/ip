package Zea;

import Zea.command.Command;
import Zea.task.Tasks;
import Zea.ui.Ui;

public class Zea {

    protected Tasks tasks;
    protected Storage storage;
    protected final Ui ui;

    public Zea(String fp) {
       this.ui = new Ui();
       this.storage = new Storage(fp);
       try {
           this.tasks = new Tasks(storage.load());
       } catch (ZeaException e) {
           ui.showLoadingError(e);
           tasks = new Tasks();
       }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                assert c != null;
                c.execute(tasks, ui, storage);
                isExit = c.getExitStatus();
            } catch (ZeaException e) {
                ui.displayError(e.getMessage());
            }
        }
        this.ui.close();
    }

    public static void main(String[] args) {
        new Zea("data/zea.txt").run();
    }
}