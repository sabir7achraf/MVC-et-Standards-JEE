package org.ma.fstt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ma.fstt.dao.LigneDeCommandeDao;
import org.ma.fstt.dao.ProduitDao;
import org.ma.fstt.entity.LignedeCommande;

import java.io.IOException;
import java.util.List;

@WebServlet("/LignedeCommandeController")
public class LignedeCommandeController extends HttpServlet {



        private final LigneDeCommandeDao ligneDeCommandeDao = new LigneDeCommandeDao();
        private final ProduitDao produitDao = new ProduitDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "list":
                        listLignesDeCommande(req, resp);
                        break;
                    case "edit":
                        editLigneDeCommande(req, resp);
                        break;
                    case "delete":
                        deleteLigneDeCommande(req, resp);
                        break;
                    default:
                        listLignesDeCommande(req, resp);
                        break;
                }
            } else {
                listLignesDeCommande(req, resp);
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if ("save".equalsIgnoreCase(action)) {
                saveLigneDeCommande(req, resp);
            } else if ("update".equalsIgnoreCase(action)) {
                updateLigneDeCommande(req, resp);
            }
        }


        private void listLignesDeCommande(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<LignedeCommande> lignes = ligneDeCommandeDao.getLignedeCommandes();
            req.setAttribute("lignesDeCommande", lignes);
            req.getRequestDispatcher("/lignesDeCommande/list.jsp").forward(req, resp);
        }

        private void editLigneDeCommande(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Long id = Long.parseLong(req.getParameter("id"));
            LignedeCommande ligne = ligneDeCommandeDao.trouverById(id);

            if (ligne != null) {
                req.setAttribute("ligneDeCommande", ligne);
                req.getRequestDispatcher("lignesDeCommande/edit.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("lignesDeCommande?action=list");
            }
        }

        private void deleteLigneDeCommande(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            Long id = Long.parseLong(req.getParameter("id"));

            if (ligneDeCommandeDao.deleteLignedeCommande(id)) {
                resp.sendRedirect("lignesDeCommande?action=list");
            } else {
                resp.getWriter().write("Error deleting the Ligne de Commande.");
            }
        }

        private void saveLigneDeCommande(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            LignedeCommande ligne = new LignedeCommande();
            Long produitId = Long.parseLong(req.getParameter("produitId"));
            ligne.setProduit(produitDao.trouverById(produitId));
            ligne.setQuantite(Integer.parseInt(req.getParameter("quantite")));
            ligne.setPrixUnitaire(Double.parseDouble(req.getParameter("prix")));
            ligneDeCommandeDao.ajouterLignedeCommande(ligne);
            resp.sendRedirect("/lignesDeCommande?action=list");
        }

        private void updateLigneDeCommande(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            Long id = Long.parseLong(req.getParameter("id"));

            LignedeCommande ligne = ligneDeCommandeDao.trouverById(id);
            if (ligne != null) {

                ligne.setProduit(produitDao.trouverById(id));
                ligne.setQuantite(Integer.parseInt(req.getParameter("quantite")));
                ligne.setPrixUnitaire(Double.parseDouble(req.getParameter("prix")));


                ligneDeCommandeDao.updateLignedeCommande(ligne);
                resp.sendRedirect("/lignesDeCommande?action=list");
            } else {
                resp.getWriter().write("Ligne de commande introuvable.");
            }
        }
    }


