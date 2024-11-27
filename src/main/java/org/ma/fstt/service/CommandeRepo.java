package org.ma.fstt.service;

import org.ma.fstt.entity.Commande;

import java.util.List;

public interface CommandeRepo {
    public void ajouterCommande( Commande commande);
    public List<Commande> getCommandes();
    public boolean deleteCommande(Long id);
    public void updateCommande(Long id, Commande commande );
    public Commande trouverById(Long id);
}
