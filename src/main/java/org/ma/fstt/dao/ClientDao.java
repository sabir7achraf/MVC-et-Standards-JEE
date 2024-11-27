package org.ma.fstt.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ma.fstt.entity.Client;
import org.ma.fstt.service.ClientRepo;

import java.util.List;

public class ClientDao implements ClientRepo {


    // 1. Créer un client
    public void ajouterClient(Client client) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // 2. Lire un client par ID

    public Client trouverParId(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    // 3. Lire tous les clients
    @SuppressWarnings("unchecked")
    public List<Client> listeClients() {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Client c").getResultList();
        } finally {
            em.close();
        }
    }

    // 4. Mettre à jour un client
    public void modifierClient(Long id, Client updatedClient) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Client client = em.find(Client.class, id);
            if (client != null) {
                client.setName(updatedClient.getName());
                client.setPrenom(updatedClient.getPrenom());
                client.setTele(updatedClient.getTele());
                em.merge(client);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // 5. Supprimer un client
    public void supprimerClient(Long id) {
        EntityManager em = JpaUnit.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Client client = em.find(Client.class, id);
            if (client != null) {
                em.remove(client);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }





}
