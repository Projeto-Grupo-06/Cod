package org.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MenuItemService {
    private final SessionFactory sessionFactory;

    public MenuItemService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addItem(MenuItem item) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }
    }

    public MenuItem getItemById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, id);
        }
    }

    public List<MenuItem> getAllItems() {
        try (Session session = sessionFactory.openSession()) {
            Query<MenuItem> query = session.createQuery("from MenuItem", MenuItem.class);
            return query.list();
        }
    }

    public void updateItem(MenuItem item) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        }
    }

    public void deleteItem(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            MenuItem item = session.get(MenuItem.class, id);
            if (item != null) {
                session.delete(item);
            }
            transaction.commit();
        }
    }
}

