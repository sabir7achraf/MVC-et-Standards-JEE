package org.ma.fstt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ma.fstt.dao.ClientDao;
import org.ma.fstt.entity.Client;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/ClientController")

public class ClientController extends HttpServlet {

    private ClientDao clientDAO;
    private Client client;
    private List<Client> clients;
    public ClientController() {
        super();
        clientDAO = new ClientDao();
        clients = new ArrayList<>();
        client = new Client();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException{
        String action = req.getParameter("action");

        try {
            if (action == null) {
                // Affiche la liste des clients
                listClients(req, resp);
            } else {
                switch (action) {
                    case "edit":
                        showEditForm(req, resp);
                        break;
                    case "delete":
                        deleteClient(req, resp);
                        break;
                    default:
                        listClients(req, resp);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if (action == null) {
                listClients(req, resp);
            } else {
                switch (action) {
                    case "insert":
                        insertClient(req, resp);
                        break;
                    case "update":
                        updateClient(req, resp);
                        break;
                    default:
                        listClients(req, resp);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 1. Liste des clients
    private void listClients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clients = clientDAO.listeClients();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("ClientJsp/listeclient.jsp").forward(req, resp);
    }

    // 2. Afficher le formulaire d'édition
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Client client = clientDAO.trouverParId(id);
        req.setAttribute("client", client);
        req.getRequestDispatcher("ClientJsp/editClient.jsp").forward(req, resp);
    }

    // 3. Insérer un nouveau client
    private void insertClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String prenom = req.getParameter("prenom");
        Long tele = Long.parseLong(req.getParameter("tele"));


        Client newClient = new Client();
        newClient.setName(name);
        newClient.setPrenom(prenom);
        newClient.setTele(tele);

        clientDAO.ajouterClient(newClient);
        resp.sendRedirect("ClientController");
    }

    // 4. Mettre à jour un client
    private void updateClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String prenom = req.getParameter("prenom");
        Long tele = Long.parseLong(req.getParameter("tele"));

        Client updatedClient = new Client();
        updatedClient.setName(name);
        updatedClient.setPrenom(prenom);
        updatedClient.setTele(tele);

        clientDAO.modifierClient(id, updatedClient);
        resp.sendRedirect("ClientController");
    }

    // 5. Supprimer un client
    private void deleteClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        clientDAO.supprimerClient(id);
        resp.sendRedirect("ClientController");
    }
}


