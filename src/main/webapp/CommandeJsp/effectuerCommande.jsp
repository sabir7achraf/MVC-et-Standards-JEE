<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajouter Commande</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Ajouter une Commande</h1>
<form class="styled-form" action="/demo/CommandeController?action=save" method="post">
    <input type="hidden" name="id" value="0">

    <label>Description :</label>
    <input type="text" name="description" required><br>

    <label>Client :</label>
    <input type="number" name="client" required><br>

    <label>DateCommande :</label>
    <input type="date" name="date_commande" required><br>

    <label>Produit :</label>
    <input type="text" name="produit" ><br>

    <button type="submit">Enregistrer</button>
</form>
</body>
</html>