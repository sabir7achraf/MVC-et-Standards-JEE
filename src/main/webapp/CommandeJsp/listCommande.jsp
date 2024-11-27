<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des Commandes</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Liste des Commandes</h1>
<a href="/demo/CommandeJsp/effectuerCommande.jsp">Ajouter une Commande</a>
<table class="styled-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Date de commande</th>
        <th>Client</th>
        <th>LignDeCommande</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="commande" items="${commandes}">
        <tr>
            <td>${commande.id}</td>
            <td>${commande.description}</td>
            <td>${commande.date_commande}</td>
            <td>${commande.client.name}</td>
            <td><a href="/demo/CommandeController?id=${commande.id}&action=ligne"> voir les ligne de commande </a></td>

            <td>
                <a href="/demo/CommandeController?id=${commande.id}&action=edit">Modifier</a>
                <a href="/demo/CommandeController?id=${commande.id}&action=delete">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>