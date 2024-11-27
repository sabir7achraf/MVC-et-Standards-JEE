package org.ma.fstt.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ma.fstt.dao.ProduitDao;
import org.ma.fstt.entity.Produit;



import java.io.IOException;
import java.util.List;

@WebServlet("/ProduitController")
public class ProduitController extends HttpServlet {

        ProduitDao produitDao = new ProduitDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null) {
            switch(action) {
                case "edit":
                    editProduit(req,resp);
                    break;
                case "delete":
                    deleteProduit(req,resp);
                    break;
                default:
                    listProduit(req,resp);
            }

        }else{
            listProduit(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action != null && action.equals("save")) {
            saveProduit(req,resp);
        }
    }
    private void listProduit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produit> produits = produitDao.getProduits();
        req.setAttribute("produit", produits);
        req.getRequestDispatcher("cProduitJsp/listeProduit.jsp").forward(req, resp);
    }
    private void deleteProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id =Long.parseLong((req.getParameter("id")));
        if (produitDao.deleteProduit(id)) {
            resp.sendRedirect("ProduitController?action=list");
        } else {
            resp.sendRedirect("ProduitController?action=list&error=delete");
        }
    }
    private void editProduit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Produit produit = produitDao.trouverById(id);
        req.setAttribute("produit", produit);
        req.getRequestDispatcher("cProduitJsp/editProduit.jsp").forward(req, resp);
    }
    private void saveProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String description = req.getParameter("description");
        String numProduit = req.getParameter("numProduit");
        Float price = Float.parseFloat(req.getParameter("price"));
        Produit produit = new Produit();
        produit.setDescription(description);
        produit.setNumProduit(numProduit);
        produit.setPrice(price);

        if (id == 0) {
            produitDao.ajouterProduit(produit);
        } else {
            produitDao.updateProduit(produit);
        }

        resp.sendRedirect("ProduitController?action=list");
    }
}
