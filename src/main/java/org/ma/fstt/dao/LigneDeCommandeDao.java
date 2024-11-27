package org.ma.fstt.dao;

import jakarta.persistence.EntityManager;
import org.ma.fstt.entity.LignedeCommande;
import org.ma.fstt.service.LignedeCommandeRepo;

import java.util.List;

public class LigneDeCommandeDao implements LignedeCommandeRepo {
    @Override
    public LignedeCommande trouverById(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(LignedeCommande.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void ajouterLignedeCommande(LignedeCommande lignedecommande) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(lignedecommande);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<LignedeCommande> getLignedeCommandes() {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("FROM LignedeCommande", LignedeCommande.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteLignedeCommande(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            LignedeCommande ligne = em.find(LignedeCommande.class, id);
            if (ligne != null) {
                em.getTransaction().begin();
                em.remove(ligne);
                em.getTransaction().commit();
                return true;
            }
            return false; // Ligne de commande non trouvée
        } finally {
            em.close();
        }
    }

    @Override
    public boolean updateLignedeCommande(LignedeCommande lignedecommande) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(lignedecommande);
            em.getTransaction().commit();
            return true;
        } finally {
            em.close();
        }
    }
}