<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Client</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styleSheet.css">
</head>
<body>
<h1>Ajouter un Client</h1>
<form class="styled-form" action="/demo/ClientController?action=insert" method="post">
    <label>Nom:</label>
    <input type="text" name="name" required><br>
    <label>Prenom:</label>
    <input type="text" name="prenom" required><br>
    <label>Tele:</label>
    <input type="number" name="tele" required><br>

    <button type="submit">Enregistrer</button>
</form>
</body>
</html>