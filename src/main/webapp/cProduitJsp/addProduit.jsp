<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Produit</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Ajouter un Produit</h1>
<form class="styled-form" action="/demo/ProduitController?action=save" method="post">
    <input type="hidden" name="id" value="0">
    <label>NomProduit:</label>
    <input type="text" name="numProduit" required><br>
    <label>Prix:</label>
    <input type="number" name="price" step="0.01" required><br>

    <label>description:</label>
    <input type="text" name="description" step="0.01" required><br>

    <button type="submit">Enregistrer</button>
</form>
</body>
</html>
