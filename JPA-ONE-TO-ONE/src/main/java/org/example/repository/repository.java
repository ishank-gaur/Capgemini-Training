package org.example.repository;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class repository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("jpa-one-to-one-example");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
