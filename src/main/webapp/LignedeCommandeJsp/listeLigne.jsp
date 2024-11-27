<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Lignes de Commande</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Liste des Lignes de Commande</h1>
<a href="addLigne.jsp">Ajouter une Ligne de Commande</a>
<table class="styled-table">
    <tr>
        <th>ID</th>
        <th>Produit</th>
        <th>Quantité</th>
        <th>prix Unitaire</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="ligne" items="${ligneCommande}">
        <tr>
            <td>${ligne.id}</td>
            <td>${ligne.produit.numProduit}</td>
            <td>${ligne.quantite}</td>
            <td>${ligne.prixUnitaire}</td>
            <td>
                <a href="editLigne.jsp?id=${ligne.id}">Modifier</a>
                <a href="deleteLigne.jsp?id=${ligne.id}">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>