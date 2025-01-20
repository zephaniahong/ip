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

    public int getTotalTasks() {
        return this.tasks.size();
    }

    public Task getTask(int idx) {
        return this.tasks.get(idx);
    }
    
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void mark(int i) {
        Task t = this.tasks.get(i);
        t.done();
    }

    public void unmark(int i) {
        Task t = this.tasks.get(i);
        t.undone();
    }

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
