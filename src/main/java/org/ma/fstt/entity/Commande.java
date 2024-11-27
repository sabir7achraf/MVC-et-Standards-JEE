package org.ma.fstt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long id;
    public long numCmd;
    public String description;
    public Date date_commande;

    @ManyToOne(fetch = FetchType.EAGER)
    public Client client;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produit> produits;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    private List<LignedeCommande> lignedeCommande;

}
