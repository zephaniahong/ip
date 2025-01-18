public class Event extends Task{

    protected String to;
    protected String from;


    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormattedString() {
        return "E|" + (this.isDone ? "1":"0") + "|" + description + "|" + from + "|" + to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + from + " to: " + to + ")";
    }
}
