package org.ma.fstt.service;

import org.ma.fstt.entity.Client;

import java.util.List;

public interface ClientRepo {
    Client trouverParId(Long id);
    void ajouterClient(Client client);
    void modifierClient(Long id,Client client);
    void supprimerClient(Long id);
    List<Client> listeClients();
}
