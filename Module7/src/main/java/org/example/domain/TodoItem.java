package org.example.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "todoitem")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you want auto-generated IDs
    private int id; // Add an ID field for Hibernate to use

    @Column(name = "description")
    private String description;

    @Column(name = "duedate")
    private String dueDate;

    @Column(name = "status")
    private boolean status;

    public TodoItem(int id, String d, String due, Boolean s ) {
        this.id = id;
        this.description = d;
        this.dueDate = due;
        this.status = s;
    }
    public TodoItem(String d, String due, Boolean s ) {
        this.description = d;
        this.dueDate = due;
        this.status = s;
    }

    public TodoItem(String d, String due) {
        this.description = d;
        this.dueDate = due;
        this.status = false;
    }


    public TodoItem(String d) {
        this.description = d;
        this.dueDate = new java.util.Date().toString();
        this.status = false;
    }

    public TodoItem() {
        this.description = "Default";
        this.dueDate = new java.util.Date().toString();
        this.status = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

