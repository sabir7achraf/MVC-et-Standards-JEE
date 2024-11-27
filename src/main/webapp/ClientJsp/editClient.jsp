<%--
  Created by IntelliJ IDEA.
  User: loi
  Date: 11/26/2024
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Client </title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<form class="styled-form" action="/demo/ClientController?action=update" method="post">
    <input type="hidden" name="id" value="${client.id}">
    <label>Nom :</label>
    <input type="text" name="name" value="${client.name}" required>
    <label>Prénom :</label>
    <input type="text" name="prenom" value="${client.prenom}" required>
    <label>Téléphone :</label>
    <input type="number" name="tele" value="${client.tele}" required>
    <button type="submit">Mettre à jour</button>
</form>
</body>
</html>
