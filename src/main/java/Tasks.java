import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Tasks {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final String fp = "./data/zea.txt";

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

    public void delete(int i) {
        Task t = this.tasks.get(i);
        this.tasks.remove(i);
        System.out.println("----------------------");
        System.out.println("Sad to see this task go:");
        System.out.println(t);
        System.out.println("Now you have " + this.tasks.size() + " tasks in the list");
        System.out.println("----------------------");
    }

    public void read() {
        try {
           BufferedReader reader = new BufferedReader(new FileReader(fp));
           String line;
           while ((line = reader.readLine()) != null ) {
               String[] parts = line.split("\\|");
               switch (parts[0]) {
                   case "T": {
                       if (parts.length != 3) {
                           throw new ZeaException("Invalid file format");
                       }
                      Todo todo = new Todo(parts[2]);
                      todo.isDone = Objects.equals(parts[1], "1");
                      this.tasks.add(todo);
                      break;
                   }
                   case "D": {
                       if (parts.length != 4) {
                           throw new ZeaException("Invalid file format");
                       }
                       LocalDateTime byDateTime = LocalDateTime.parse(parts[3], formatter);
                       Deadline deadline = new Deadline(parts[2], byDateTime);
                       deadline.isDone = Objects.equals(parts[1], "1");
                       this.tasks.add(deadline);
                       break;
                   }
                   case "E": {
                       if (parts.length != 5) {
                           throw new ZeaException("Invalid file format");
                       }
                       LocalDateTime fromDateTime = LocalDateTime.parse(parts[3], formatter);
                       LocalDateTime toDateTime = LocalDateTime.parse(parts[4], formatter);
                       Event event = new Event(parts[2], fromDateTime, toDateTime);
                       event.isDone = Objects.equals(parts[1], "1");
                       this.tasks.add(event);
                       break;
                   }
               }
           }
        } catch (IOException | ZeaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save()  {
        try {
            FileWriter writer = new FileWriter(fp);
            StringBuilder sb = new StringBuilder();
            for (Task t : this.tasks) {
               sb.append(t.toFileFormattedString());
               sb.append("\n");
            }
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
