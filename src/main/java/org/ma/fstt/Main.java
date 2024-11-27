package org.ma.fstt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ma.fstt.entity.Client;
import org.ma.fstt.entity.Commande;
import org.ma.fstt.entity.LignedeCommande;
import org.ma.fstt.entity.Produit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Client client = new Client();
        client.setName("evan");
        client.setPrenom("probi");
        Commande commande = new Commande();
        commande.setClient(client);
        commande.setNumCmd(124);
        commande.setDescription("uneCommande contient 2 produit  ");
        commande.setDate_commande(new Date());


        LignedeCommande ligne = new LignedeCommande();
        LignedeCommande ligne2 = new LignedeCommande();
        ligne2.setQuantite(1);
        ligne2.setPrixUnitaire(300);
        Produit produit2 = new Produit();
        produit2.setPrice(300);
        produit2.setNumProduit("produit2");
        produit2.setDescription("ahsen produit 2");



        ligne2.setProduit(produit2);
        Produit produit = new Produit();

        produit.setNumProduit("pikolo");
        produit.setDescription("a7sen produit f les produit dyoul mirikan ");
        produit.setPrice(900);

        ligne.setProduit(produit);
        ligne.setPrixUnitaire(900);
        ligne.setQuantite(2);
        List<LignedeCommande> listes = new ArrayList<>();
        listes.add(ligne);
        listes.add(ligne2);
        commande.setLignedeCommande(listes);



        em.persist(client);
        em.persist(commande);
        em.persist(produit);
        em.persist(ligne);
        em.persist(ligne2);
        em.persist(produit2);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

