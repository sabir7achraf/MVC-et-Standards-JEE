package org.ma.fstt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id ;
    public String name ;
    public String prenom ;
    public long tele;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Commande> commandes ;

}
