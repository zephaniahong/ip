package zea.task;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Tasks {
    ArrayList<Task> tasks;

    public Tasks() {
        this.tasks = new ArrayList<>();
    }

    public Tasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     *
     * @return the total number of tasks
     */
    public int getTotalTasks() {
        return this.tasks.size();
    }

    public Task getTask(int idx) {
        return this.tasks.get(idx);
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     *
     * @param i - 1-based index of the task to be marked as complete
     */
    public void mark(int i) {
        Task t = this.tasks.get(i);
        t.done();
    }

    /**
     *
     * @param i - 1-based index of the task to be unmarked
     */
    public void unmark(int i) {
        Task t = this.tasks.get(i);
        t.undone();
    }

    /**
     *
     * @param i - 1-based index of the task to be deleted
     */
    public void delete(int i) {
        this.tasks.remove(i);
    }

    public ArrayList<Task> getAllTasks() {
        return this.tasks;
    }

    public ArrayList<Task> find(String keyword) {
        return this.tasks.stream().filter(t -> t.description.contains(keyword)).collect(Collectors.toCollection(ArrayList::new));
    }
}
