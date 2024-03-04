package org.example.domain;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class TodoViewer {
    private Scanner scanner;

    public TodoViewer() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            TodoList todoList = new TodoList();
            session.persist(todoList);
            transaction.commit();

            System.out.println("Welcome to ToDo!");

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Add a to-do item");
                System.out.println("2. Delete a to-do item");
                System.out.println("3. View to-do items");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        transaction = session.beginTransaction();
                        System.out.println("Please enter item's description:");
                        String description = scanner.nextLine();
                        TodoItem item = new TodoItem(description, todoList);
                        todoList.addItem(item);
                        session.persist(item);
                        transaction.commit();
                        break;
                    case 2:
                        System.out.println("Please enter item's description:");
                        String toDelete = scanner.nextLine();
                        todoList.deleteItem(toDelete);
                        break;
                    case 3:
                        todoList.showTodoList();
                        break;
                    case 4:
                        System.out.println("Exiting program. Goodbye!");
                        transaction.commit();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}