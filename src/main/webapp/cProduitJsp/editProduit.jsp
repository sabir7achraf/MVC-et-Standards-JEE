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
<h1>Edit Produit</h1>
<form class="styled-form" action="/demo/ProduitController?action=save" method="post">
    <input type="hidden" name="id" value=${produit.id}>

    <label>Nom Produit</label>
    <input type="text" name="numProduit" value="${produit.numProduit}"><br>

    <label>Description :</label>
    <input type="text" name="description" value="${produit.description}"><br>

    <label>Price :</label>
    <input type="text" name="price" value="${produit.price}"><br>



    <button type="submit">Enregistrer</button>
</form>
</body>
</html>
