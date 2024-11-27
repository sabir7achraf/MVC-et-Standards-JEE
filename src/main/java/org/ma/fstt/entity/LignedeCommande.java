package org.ma.fstt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LignedeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private int quantite;

    private double prixUnitaire;
}
