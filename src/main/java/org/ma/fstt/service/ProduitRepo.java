package org.ma.fstt.service;

import org.ma.fstt.entity.Produit;

import java.util.List;

public interface ProduitRepo {
    public  Produit trouverById(Long id) ;
    public void ajouterProduit( Produit pProduit) ;
    public List<Produit> getProduits() ;
    public boolean deleteProduit(Long id);
    public boolean updateProduit(Produit produit );
}
