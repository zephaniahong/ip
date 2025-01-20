package zea;

import zea.task.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Storage {
    private final String fp;

    public Storage(String fp) {
        this.fp = fp;
    }

    /**
     * Loads the tasks from the filepath into a list of <code>Task</code>
     * @return a list of <code>Task</code>
     * @throws ZeaException - if the format of the file is invalid
     */
    public ArrayList<Task> load() throws ZeaException {
        ArrayList<Task> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fp));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                switch (parts[0]) {
                case "T": {
                    if (parts.length != 3) {
                        throw new ZeaException("Invalid file format");
                    }
                    Todo todo = new Todo(parts[2]);
                    if (Objects.equals(parts[1], "1")) {
                        todo.done();
                    }
                    list.add(todo);
                    break;
                }
                case "D": {
                    if (parts.length != 4) {
                        throw new ZeaException("Invalid file format");
                    }
                    LocalDateTime byDateTime = LocalDateTime.parse(parts[3], Task.formatter);
                    Deadline deadline = new Deadline(parts[2], byDateTime);
                    if (Objects.equals(parts[1], "1")) {
                        deadline.done();
                    }
                    list.add(deadline);
                    break;
                }
                case "E": {
                    if (parts.length != 5) {
                        throw new ZeaException("Invalid file format");
                    }
                    LocalDateTime fromDateTime = LocalDateTime.parse(parts[3], Task.formatter);
                    LocalDateTime toDateTime = LocalDateTime.parse(parts[4], Task.formatter);
                    Event event = new Event(parts[2], fromDateTime, toDateTime);
                    if (Objects.equals(parts[1], "1")) {
                        event.done();
                    }
                    list.add(event);
                    break;
                }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    /**
     * Saves the tasks into a file
     * @param tasks - the <code>Tasks</code> to be saved
     */
    public void save(Tasks tasks) {
        try {
            FileWriter writer = new FileWriter(fp);
            StringBuilder sb = new StringBuilder();
            for (Task t : tasks.getAllTasks()) {
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
