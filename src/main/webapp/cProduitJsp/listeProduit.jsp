<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Produits</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Liste des Produits</h1>
<a href="/demo/cProduitJsp/addProduit.jsp">Ajouter un Produit</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prix</th>
        <th>description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="produit" items="${produit}">
        <tr>
            <td>${produit.id}</td>
            <td>${produit.numProduit}</td>
            <td>${produit.price}</td>
            <td>${produit.description}</td>
            <td>
                <a href="/demo/ProduitController?id=${produit.id}&action=edit">Modifier</a> |
                <a href="/demo/ProduitController?id=${produit.id}&action=delete">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
