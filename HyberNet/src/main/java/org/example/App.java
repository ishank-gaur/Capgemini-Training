package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure()
                .addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // 🔹 1. INSERT
        Person pr = new Person();
        pr.setId(3);
        pr.setName("rahul");

        session.persist(pr);
        System.out.println("Inserted Successfully");

        // 🔹 2. FETCH
        Person p = session.get(Person.class, 309445);
        System.out.println("Before Update: " + p);

        // 🔹 3. UPDATE
        if (p != null) {
            p.setName("Ishank bhardwaj");   // Updating name
        }

        // No need to call update() in Hibernate 6
        // Hibernate auto-detects changes

        transaction.commit();

        // 🔹 4. FETCH AFTER UPDATE
        Session newSession = sessionFactory.openSession();
        Person updatedPerson = newSession.get(Person.class, 309445);
        System.out.println("After Update: " + updatedPerson);

        newSession.close();
        session.close();
        sessionFactory.close();
    }
}