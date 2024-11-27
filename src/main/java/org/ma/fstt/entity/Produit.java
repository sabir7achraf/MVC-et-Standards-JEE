package org.ma.fstt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String numProduit;
    public float price;
    public String description ;

    @ManyToOne(fetch = FetchType.EAGER)
    LignedeCommande lignedeCommandes;

}
