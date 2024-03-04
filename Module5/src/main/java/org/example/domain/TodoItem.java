package org.example.domain;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;
enum PRIORITY{
    high,
    medium,
    low
}
@Entity
@Table(name = "todoitem")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you want auto-generated IDs
    private int itemId; // Add an ID field for Hibernate to use

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private PRIORITY priority;

    @Column(name = "status")
    private boolean status;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;

    public TodoItem(String d, Date due, PRIORITY p, TodoList todoList) {
        this.description = d;
        this.dueDate = due;
        this.priority = p;
        this.todoList = todoList;
        this.status = false;
    }

    public TodoItem(String d, Date due, TodoList todoList) {
        this.description = d;
        this.dueDate = due;
        this.todoList = todoList;
        this.priority = PRIORITY.low;
        this.status = false;
    }

    public TodoItem(String d, TodoList todoList) {
        this.description = d;
        this.todoList = todoList;
        this.dueDate = new java.util.Date();
        this.priority = PRIORITY.low;
        this.status = false;
    }


    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
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

