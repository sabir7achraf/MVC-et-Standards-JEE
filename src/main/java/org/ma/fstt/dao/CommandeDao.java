package org.ma.fstt.dao;

import jakarta.persistence.EntityManager;
import org.ma.fstt.entity.Commande;
import org.ma.fstt.service.CommandeRepo;

import java.util.List;

public class CommandeDao implements CommandeRepo {



    @Override
    public void ajouterCommande(Commande commande) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(commande);
            em.getTransaction().commit();

        }
        finally {
            em.close();
        }
    }

    @Override
    public List getCommandes() {
       EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            List<Commande> commandes = em.createQuery("SELECT c FROM Commande c", Commande.class).getResultList();
            em.getTransaction().commit();
            return commandes;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }


    @Override
    public boolean deleteCommande(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Commande commande= em.find(Commande.class, id);
            if (commande != null) {
                em.remove(commande);
                em.getTransaction().commit();
                return true;
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public void updateCommande(Long id , Commande updateCommande) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Commande commande = em.find(Commande.class, id);
            if (commande != null) {
                commande.setNumCmd(updateCommande.getNumCmd());
                commande.setDescription(updateCommande.getDescription());
                commande.setDate_commande(updateCommande.getDate_commande());
                em.merge(commande);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Relancez l'exception ou loggez-la
        } finally {
            em.close();
        }
    }

    @Override
    public Commande trouverById(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.find(Commande.class, id);
            em.getTransaction().commit();
            return em.find(Commande.class, id);
        }finally {
            em.close();
        }
    }
}
