package org.ma.fstt.dao;

import jakarta.persistence.EntityManager;
import org.ma.fstt.entity.Produit;
import org.ma.fstt.service.ProduitRepo;

import java.util.List;

public class ProduitDao implements ProduitRepo {

    @Override
    public Produit trouverById(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Produit.class, id); // Pas besoin de transaction pour une lecture simple
        } finally {
            em.close();
        }
    }

    @Override
    public void ajouterProduit(Produit pProduit) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pProduit);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produit> getProduits() {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("FROM Produit", Produit.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteProduit(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            Produit produit = em.find(Produit.class, id);
            if (produit != null) {
                em.getTransaction().begin();
                em.remove(produit);
                em.getTransaction().commit();
                return true;
            }
            return false; // Produit non trouvé
        } finally {
            em.close();
        }
    }

    @Override
    public boolean updateProduit(Produit produit) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produit);
            em.getTransaction().commit();
            return true;
        } finally {
            em.close();
        }
    }
}
