import java.util.ArrayList;

public class Tasks {
    ArrayList<Task> tasks;

    public Tasks() {
        this.tasks = new ArrayList<>();
    }
    
    public void addTask(Task task) {
        this.tasks.add(task);

        System.out.println("----------------------");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + this.tasks.size() + " tasks in the list");
        System.out.println("----------------------");
        ;
    }

    public void list() {
        System.out.println("----------------------");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.tasks.size(); i++) {
            Task t = this.tasks.get(i);
            System.out.println(i+1 + ". " + t);
        }
        System.out.println("----------------------");
    }

    public void mark(int i) {
        Task t = this.tasks.get(i);
        t.done();
        System.out.println("----------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(t);
        System.out.println("----------------------");
    }

    public void unmark(int i) {
        Task t = this.tasks.get(i);
        t.undone();
        System.out.println("----------------------");
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println(t);
        System.out.println("----------------------");
    }
}
