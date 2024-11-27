package org.ma.fstt.service;

import org.ma.fstt.entity.LignedeCommande;

import java.util.List;

public interface LignedeCommandeRepo {
    public LignedeCommande trouverById(Long id) ;
    public void ajouterLignedeCommande( LignedeCommande  lignedecommande);
    public List<LignedeCommande> getLignedeCommandes() ;
    public boolean deleteLignedeCommande(Long id);
    public boolean updateLignedeCommande(LignedeCommande lignedecommande );
}
