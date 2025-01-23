package zea;

import zea.command.Command;
import zea.task.Tasks;
import zea.ui.Ui;

/**
 * Zea
 */
public class Zea {

    protected Tasks tasks;
    protected Storage storage;
    protected final Ui ui;

    /**
     * Creates a new instance of Zea
     *
     * @param fp - The filepath of where existing todos are stored
     */
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

    public String getResponse(String input) {
        return "Zea heard: " + input;
    }

    /**
     * Runs the program
     */
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
            } catch (ZeaException | ParseException e) {
                ui.displayError(e.getMessage());
            }
        }
        this.ui.close();
    }

    public static void main(String[] args) {
        new Zea("data/zea.txt").run();
    }
}
