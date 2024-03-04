package org.example;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.domain.TodoViewer;

public class App {

    public static void main(String[] args) {

        TodoViewer frontEnd = new TodoViewer();
        frontEnd.start();
    }
}
