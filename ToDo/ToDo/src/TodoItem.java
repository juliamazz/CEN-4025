import java.util.Date;

enum PRIORITY{
    high,
    medium,
    low
}

public class TodoItem {
    String description;
    Date dueDate;
    PRIORITY priority;
    boolean status; // True = complete, False = incomplete
    public TodoItem(String d, Date due, PRIORITY p) {
        this.description = d;
        this.dueDate = due;
        this.priority = p;
        this.status = false;
    }

    public TodoItem(String d, Date due) {
        this.description = d;
        this.dueDate = due;
        this.priority = PRIORITY.low;
        this.status = false;
    }

    public TodoItem(String d) {
        this.description = d;
        this.dueDate = new java.util.Date();
        this.priority = PRIORITY.low;
        this.status = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void viewItem()
    {
        System.out.println(description + " Due: " + dueDate + " Priority: " + priority);
    }
}

