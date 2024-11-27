<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Clients</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Liste des Clients</h1>
<a href="ClientJsp/addClient.jsp">Ajouter un Client</a>
<table class="styled-table" >
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Tele</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.prenom}</td>
            <td>${client.tele}</td>
            <td>
                <a href="/demo/ClientController?id=${client.id}&action=edit">Modifier</a>
                <a href="/demo/ClientController?id=${client.id}&action=delete">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
