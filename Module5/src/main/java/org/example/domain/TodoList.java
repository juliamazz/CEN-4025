package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "todolist")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listID;
    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TodoItem> todoItems = new ArrayList<>();

    public TodoList() {
        todoItems = new ArrayList<>();
    }

    public void addItem(TodoItem item) {
        todoItems.add(item);
    }

    // Delete for database
    public void deleteItem(TodoItem item) {
        if (todoItems.isEmpty()) {
            System.out.println("No to-do items to delete.");
            return;
        }
        else {
            todoItems.remove(item);

            // Delete item from the database
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.delete(item);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    System.out.println("Item not found.");
                }
                e.printStackTrace();
            }
        }
    }

    // Delete for String
    public void deleteItem(String itemDescription)
    {
        if (todoItems.isEmpty()) {
            System.out.println("No to-do items to delete.");
            return;
        }
        else {
            boolean foundItem = false;
            for (int i = 0; i < todoItems.size(); i++) {
                if(todoItems.get(i).getDescription().equals(itemDescription)) {
                    todoItems.remove(todoItems.get(i));
                    foundItem = true;
                }
            }
            if(!foundItem)
            {
                System.out.println("Item not found.");
            }
        }
    }

    public void moveItem(int oldIndex, int newIndex) {
        // Move item from oldIndex to newIndex
        TodoItem item = todoItems.remove(oldIndex);
        todoItems.add(newIndex, item);
    }

    public void showTodoList() {
        for (TodoItem item : todoItems) {
            item.viewItem();
        }
    }
}

