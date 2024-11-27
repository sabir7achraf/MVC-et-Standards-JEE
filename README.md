# Gestion des Commandes - Application Web JEE


## Objectif
Ce projet a pour but de maîtriser les standards JEE (Servlet, JSP, JavaBean) en développant une application web de gestion de commandes pour plusieurs clients. L'application est conçue selon le patron de conception **MVC**.



## Fonctionnalités
### Modules disponibles :
- **Espace Client**
  - Ajouter, modifier, supprimer et consulter des clients.
- **Espace Produit**
  - Gestion complète des produits (CRUD).
- **Espace Commande**
  - Gestion des commandes avec association des produits et des clients.



## Structure du Projet
### Étapes de réalisation :
1. **Diagramme de Classe**
   - Quatre classes principales :
     - `Client`
     - `Commande`
     - `Produit`
     - `LignedeCommande`
   
2. **Base de Données**
   - Traduction du diagramme de classe en schéma relationnel.
   - Implémentation dans MySQL.

3. **Création du Projet Maven**
   - Conversion du projet en projet dynamique Maven.
   - Ajout de la dépendance MySQL Connector dans `pom.xml` :
     ```xml
     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>x.x.x.x</version>
     </dependency>
     ```

4. **Couche Persistance**
   - Création des classes entités dans le package `ma.fstt.entities`.
   - Implémentation des classes DAO dans `ma.fstt.dao`.
   - Ajout d'un service dans `ma.fstt.service`.
     Exemple :
     ```java
     public interface ClientRepository {
         Client trouverById(String id);
         void ajouterClient(Client client);
     }
     ```

     ```java
     public class ClientDAO implements ClientRepository {
         // Implémentation des méthodes
     }
     ```

5. **Couche Présentation**
   - Création des **Servlets** et **JSP** pour les espaces :
     - Client
     - Produit
     - Commande
   - Utilisation de **JSTL** pour les expressions et la manipulation des données.
   - Ajout de fonctionnalités JavaScript (**jQuery**).
   - Injection des dépendances via `@Inject` et `@ApplicationScoped`.



## Prérequis
### Outils nécessaires :
- **IntelliJ IDEA**
- **Maven**
- **Serveur Tomcat**
- **MySQL**

### Technologies utilisées :
- **Java 21**
- **JEE** (Servlet, JSP, JavaBeans)
- **JSTL**
- **JavaScript** (jQuery)

---

## Installation et Exécution
### Étapes :
1. **Clonez le projet** :
   ```bash
   git clone <URL_DU_DEPOT>
   ```
   ###configuration de MySQL

1. **Importez le script SQL** :  
   - Le script SQL est disponible dans le dossier `database/`. Importez-le dans votre base de données MySQL pour initialiser la structure et les données nécessaires.

2. **Mettez à jour le fichier `persistence.xml`** :  
   - Configurez vos paramètres MySQL en modifiant les propriétés suivantes dans le fichier `persistence.xml` :
     ```xml
     <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/nom_bdd" />
     <property name="javax.persistence.jdbc.user" value="root" />
     <property name="javax.persistence.jdbc.password" value="password" />
     ```

3. **Compilez et déployez le projet sur Tomcat** :  
   - Exécutez la commande suivante pour compiler le projet et générer l'artefact déployable :
     ```bash
     mvn clean install
     ```



## Aperçu de l'Application

### Interface Utilisateur :
![image](https://github.com/user-attachments/assets/22b6e993-41be-461f-9f59-01ac05e58ac2)

- **Espace Client**  
  Permet d'ajouter, de modifier, de supprimer et de consulter les clients.
  ![image](https://github.com/user-attachments/assets/c9584ebd-e1bb-4c43-ae4e-1c3486595213)
  ![image](https://github.com/user-attachments/assets/32270c10-91c0-4346-a10f-f2f3cc0768ff)
  ![image](https://github.com/user-attachments/assets/69851706-b3c6-4713-8b1d-173a924f8687)
  ![image](https://github.com/user-attachments/assets/3cf25424-99ac-4119-b059-d4a0d60d129f)





- **Espace Produit**  
  Permet de gérer les produits (ajout, modification, suppression et consultation).
  ![image](https://github.com/user-attachments/assets/544aa02e-ef04-41f8-9d62-487d5d054f6f)


- **Espace Commande**  
  Permet de gérer les commandes, avec une association des produits et des clients.
  ![image](https://github.com/user-attachments/assets/b91b6880-7b58-41e9-8109-8bd387ea0d09)
  ![image](https://github.com/user-attachments/assets/1dc72534-df8d-4892-b95a-4aa377535b29)



---

## Auteur
- **Nom** : Ashraf sabir
- **Université** : Université Abdelmalek Essaadi, Faculté des Sciences et Techniques de Tanger
- **Département** : logiciels et systèmes intelligents

