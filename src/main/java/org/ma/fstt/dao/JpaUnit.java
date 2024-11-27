package org.ma.fstt.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUnit {
    private  static EntityManagerFactory entityManagerFactory;

    // Initialisation statique (lors du chargement de la classe)
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initialisation d'EntityManagerFactory échouée : " + e.getMessage());
        }
    }

    // Méthode pour récupérer l'EntityManagerFactory
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    // Méthode pour fermer l'EntityManagerFactory (à appeler à la fin de l'application)
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}

