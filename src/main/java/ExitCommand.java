public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }
    @Override
    public void execute(Tasks tasks, Ui ui, Storage storage) {
        System.out.println("----------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------");
    }
}
