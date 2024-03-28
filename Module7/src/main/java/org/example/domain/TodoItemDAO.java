package org.example.domain;

import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.domain.TodoItem;

import java.util.List;

public class TodoItemDAO {
    /**
     * Add Item
     * @param item
     */
    public void addItem(TodoItem item) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            if (!transaction.isActive()){
                transaction.begin();
            }
            // save the object
            session.save(item);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Item
     * @param item
     */
    public void updateItem(TodoItem item)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            if (!transaction.isActive()){
                transaction.begin();
            }
            // save the object
            session.update(item);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    /**
     * Delete Item
     * @param id
     */
    public void deleteItem(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            if (!transaction.isActive()){
                transaction.begin();
            }

            // Delete ietm object
            TodoItem item = session.get(TodoItem.class, id);
            if (item != null) {
                session.delete(item);
                System.out.println("item is deleted");
            }
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    /**
     * Get Item By ID
     * @param id
     * @return
     */
    public static TodoItem getItem(int id) {

        Transaction transaction = null;
        TodoItem item = null;

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            if (!transaction.isActive()){
                transaction.begin();
            }
            // get an item object
            item = session.get(TodoItem.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return item;
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List< TodoItem > getAllItems() {

//        Transaction transaction = null;
        List < TodoItem > listOfItems = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            // start a transaction
//            transaction = session.beginTransaction();
//
//            if (!transaction.isActive()){
//                transaction.begin();
//            }
            // get an item object
            System.out.println("IM HERE");
            session.beginTransaction();
            //listOfItems = session.createQuery("FROM todoitem").list();
            listOfItems = session.createQuery("FROM todoitem", org.example.domain.TodoItem.class).getResultList();
            System.out.println(listOfItems);
            // commit transaction
//            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
        return listOfItems;
    }
}
