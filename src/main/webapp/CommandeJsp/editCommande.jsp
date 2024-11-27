<%--
  Created by IntelliJ IDEA.
  User: loi
  Date: 11/27/2024
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Commande</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<form class="styled-form" action="/demo/CommandeController?action=save" method="post">
    <input type="hidden" name="id" value=${commande.id}>

    <label>Description :</label>
    <input type="text" name="description" value="${commande.description}"><br>

    <label>Client :</label>
    <input type="number" name="client" value="${commande.client.id}"><br>

    <label>Date :</label>
    <input type="date" name="date_commande" value="${commande.date_commande}"><br>

    <label>Produit :</label>
    <input type="text" name="produit"><br>





    <button type="submit">Enregistrer</button>
</form>
</body>
</html>
