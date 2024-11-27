
Gestion des Commandes - Application Web JEE
Objectif
Ce projet vise à maîtriser les standards JEE (Servlet, JSP, JavaBean) via le développement d'une application web de gestion de commandes pour plusieurs clients. L'application suit le patron de conception MVC.

Fonctionnalités
Modules disponibles :
Espace Client
Ajouter, modifier, supprimer et consulter des clients.
Espace Produit
Gestion des produits : CRUD complet.
Espace Commande
Gestion des commandes avec association de produits et de clients.
Structure du projet
Étapes de réalisation
Étape 1 : Diagramme de classe
Quatre classes principales :
Client
Commande
Produit
LignedeCommande
Étape 2 : Base de données
Traduction du diagramme de classes en schéma relationnel.
Implémentation dans MySQL.
Étape 3 : Création du projet Maven
Conversion en projet dynamique Maven.
Ajout de la dépendance MySQL Connector au fichier pom.xml :
xml
Copy code
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>x.x.x.x</version>
</dependency>
Étape 4 : Couche persistance
Création des classes entités dans le package ma.fstt.entities.
Implémentation des classes DAO dans ma.fstt.dao.
Ajout d'un service dans ma.fstt.service.
Exemple :
java
Copy code
public interface ClientRepository {
    Client trouverById(String id);
    void ajouterClient(Client client);
}
java
Copy code
public class ClientDAO implements ClientRepository {
    // Implémentation des méthodes
}
Étape 5 : Couche présentation
Création des Servlets et JSP pour les espaces :
Client
Produit
Commande
Intégration de JSTL pour les expressions et manipulation des données.
Ajout de fonctionnalités JavaScript (jQuery).
Injection des dépendances via @Inject et @ApplicationScoped.
Prérequis
Outils :

IntelliJ IDEA
Maven
Serveur Tomcat
MySQL
Technologies utilisées :

Java 8+
JEE (Servlet, JSP, JavaBeans)
JSTL
JavaScript (jQuery)
Installation et Exécution
Clonez le projet :
bash
Copy code
git clone <URL_DU_DEPOT>
Configurez la base de données MySQL :

Importez le script SQL disponible dans le dossier database/.
Mettez à jour le fichier persistence.xml avec vos paramètres MySQL :

xml
Copy code
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/nom_bdd" />
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="password" />
Compilez et déployez sur Tomcat :
bash
Copy code
mvn clean install
Aperçu de l'application
![image](https://github.com/user-attachments/assets/413eaec1-df41-45f9-b44e-5ba31f1f47fb)

Espace Client
![image](https://github.com/user-attachments/assets/a3ea911a-167d-4445-8b46-eb342a5cca3e)
![image](https://github.com/user-attachments/assets/a095e797-fa79-48d2-a84a-da1709416cd8)
![image](https://github.com/user-attachments/assets/c228bfdb-8ff9-4309-bb05-5f3f24373bd2)
![image](https://github.com/user-attachments/assets/130b3b53-dbbd-4952-98b0-80e89184c71a)

Espace Produit
![image](https://github.com/user-attachments/assets/4c5d484a-4fd4-4bcf-b432-d1e856f46d4e)

Espace Commande
![image](https://github.com/user-attachments/assets/30752e82-fb57-4dd8-9b5c-a5db8c64fe4f)
![image](https://github.com/user-attachments/assets/02b8765f-4673-489c-bb43-4e89957bf3a2)


Auteur
Nom : Sabir achraf
Université : Université Abdelmalek Essaadi, Faculté des Sciences et Techniques de Tanger
Département : logiciels et systèmes intelligents
