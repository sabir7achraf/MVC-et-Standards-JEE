package org.ma.fstt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ma.fstt.dao.ClientDao;
import org.ma.fstt.dao.CommandeDao;
import org.ma.fstt.dao.ProduitDao;
import org.ma.fstt.entity.Commande;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/CommandeController")
public class CommandeController extends HttpServlet {

    private final CommandeDao commandeDao = new CommandeDao();
    private final ClientDao clientDao = new ClientDao();
    private final ProduitDao  produitDao = new ProduitDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    deleteCommande(req, resp);
                    break;
                case "edit":
                    editCommande(req, resp);
                    break;
                case "ligne":
                    ligneDeCommande(req, resp);
                    break;
                default:
                    listCommandes(req, resp);;
                    break;
            }
        } else {
            listCommandes(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && action.equals("save")) {
            saveCommande(req, resp);
        }
    }

    private void listCommandes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Commande> commandes = commandeDao.getCommandes();
        System.out.println("Commandes: " + commandes);
        req.setAttribute("commandes", commandes);
        req.getRequestDispatcher("CommandeJsp/listCommande.jsp").forward(req, resp);
    }

    private void deleteCommande(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id =Long.parseLong((req.getParameter("id")));
        if (commandeDao.deleteCommande(id)) {
            resp.sendRedirect("CommandeController?action=list");
        } else {
            resp.sendRedirect("CommandeController?action=list&error=delete");
        }
    }

    private void editCommande(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Commande commande = commandeDao.trouverById(id);
        req.setAttribute("commande", commande);
        req.getRequestDispatcher("CommandeJsp/editCommande.jsp").forward(req, resp);
    }

    private void saveCommande(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String description = req.getParameter("description");
        String dateString = req.getParameter("date_commande");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Format attendu
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Long clientid = Long.parseLong(req.getParameter("client"));

        Long produitId = Long.parseLong(req.getParameter("produit"));




        Commande commande = new Commande();
        commande.setDescription(description);
        commande.setDate_commande(date);
        commande.setClient(clientDao.trouverParId(clientid));

        if (produitDao.trouverById(produitId) != null) {
            if (commande.getProduits() == null) {
                commande.setProduits(new ArrayList<>());
            }
            commande.getProduits().add(produitDao.trouverById(produitId));
        }


        if (id == 0) {
            commandeDao.ajouterCommande(commande);
        } else {
            commandeDao.updateCommande(id,commande);
        }

        resp.sendRedirect("CommandeController?action=list");
    }

    private void ligneDeCommande(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Commande commande = commandeDao.trouverById(id);
        req.setAttribute("ligneCommande", commande.getLignedeCommande());
        req.getRequestDispatcher("LignedeCommandeJsp/listeLigne.jsp").forward(req, resp);


    }
}

